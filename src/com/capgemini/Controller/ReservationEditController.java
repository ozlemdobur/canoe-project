package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.Reservations;
import com.capgemini.View.ReservationEditMenuView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationEditController{

    Model model = new Model();
    ReservationEditMenuView reservationEditMenuView = new ReservationEditMenuView();
    ReservationProgressController reservationProgressController = new ReservationProgressController(model);
    private String canoeType;
    private String canoeId;
    private String date;
    private String duration;
    private String chosenKey;
    private String startTime;
    private String endTime;
    private String roomNumber;
    private String cost;
    int count=-1;
    Reservation editedReservation;


    public void execute() throws FileNotFoundException, ParseException {
        reservationEditMenuView.executeView();
        String reservationId = reservationEditMenuView.getInputReservationId().trim().toUpperCase(Locale.ROOT);

        boolean check=false;
        for(Reservation reservation : model.getReservations()){
            count++;
            if(reservationId.equals(reservation.getReservationId())){
                roomNumber=reservation.getRoomNumber();
                canoeType=reservation.getCanoeType();
                canoeId=reservation.getCanoeId();
                date=reservation.getDate();
                duration=reservation.getDuration();
                startTime=reservation.getStartTime();
                endTime=reservation.getEndTime();
                cost = reservation.getCost();
                Reservation selectedReservation = new Reservation(reservationId,roomNumber,canoeType,canoeId,date,duration,startTime,endTime,cost);
                reservationEditMenuView.selectedReservation(selectedReservation);
                check=true;
                break;
            }
        }

        if(check&&reservationEditMenuView.checkReservation()){
            switch (chosenKey = reservationEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "RN":
                    editedReservation = new Reservation(reservationId,reservationEditMenuView.getNewRoomNumber(),canoeType,canoeId,date,duration,startTime,endTime,cost);
                    write(editedReservation);
                    break;
                case "CT":
                    String newCanoeType =reservationEditMenuView.getNewCanoeType();
                    //String newCanoeID = checkAvailableCanoeType(newCanoeType,date,startTime,endTime);
                    String newCanoeID = reservationProgressController.whichCanoeIsFree(date,newCanoeType,startTime);
                    if(newCanoeID==null){
                        reservationEditMenuView.warningMessage();
                        break;
                    }
                    cost=reservationProgressController.costCalculating(duration,newCanoeID);
                    editedReservation = new Reservation(reservationId, roomNumber,newCanoeType, newCanoeID, date, duration,startTime,endTime,cost);
                    write(editedReservation);
                    /*if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                    break;
                    }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();

                    }
                     */
                    break;

                case "DT":
                    String newDuration = reservationEditMenuView.getNewDuration();
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, newDuration, duration,startTime,endTime,cost);
                    String newdtCanoeID = reservationProgressController.whichCanoeIsFree(editedReservation.getDate(),editedReservation.getCanoeType(),editedReservation.getStartTime());
                   if(newdtCanoeID==null){
                       reservationEditMenuView.warningMessage();
                       break;
                }
                   cost=reservationProgressController.costCalculating(newDuration,newdtCanoeID);
                   editedReservation= new Reservation(reservationId,roomNumber,canoeType,canoeId,date,newDuration,startTime,endTime,cost);


                    /* if(checkFreeReservation(editedReservation)) {
                        write(editedReservation);
                        break;
                    }else {reservationEditMenuView.warningMessage();
                        reservationEditMenuView.noSaved();
                        break;
                    }

                    */

                case "DR":
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, date,reservationEditMenuView.getNewDuration(),startTime,endTime,cost);
                if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                    break;
                }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();
                    break;
                }
                case "ST":
                    String newSTime = reservationEditMenuView.getNewStartTime().trim();
                    editedReservation = new Reservation(reservationId, roomNumber, canoeType, canoeId, date, duration, newSTime, endTime,cost);
                    if(checkFreeReservation(editedReservation)) {
                        write(editedReservation);
                        break;
                    }else {reservationEditMenuView.warningMessage();
                        reservationEditMenuView.noSaved();
                        break;
                    }
                default: System.out.println(GREEN_BOLD + "You entered wrong key." + TEXT_RESET);
            }
        }else if (!check){
            System.out.println(GREEN_BOLD + "The reservation is not found please check the information and try again." + TEXT_RESET);
        }
    }



    private void write(Reservation saveReservation) throws FileNotFoundException {
        String cost = costCalculating(saveReservation.getDuration(),saveReservation.getCanoeId());
        if(reservationEditMenuView.saveReservation(cost,saveReservation)) {
            PrintWriter writer = new PrintWriter("src/com/capgemini/Model/ReservationDB");
            model.getReservations().set(count, saveReservation);
            writer.print("");
            for (Reservation reservation : model.getReservations()) {
                writer.println(reservation.getReservationId() + "," +
                        reservation.getRoomNumber() + "," +
                        reservation.getCanoeType() + "," +
                        reservation.getCanoeId() + "," +
                        reservation.getDate() + "," +
                        reservation.getDuration() + "," +
                        reservation.getStartTime() + "," +
                        reservation.getEndTime());
            }
            writer.close();
            message(chosenKey);
        }
    }


    public void message(String shortcut){
        switch (shortcut) {
            case "RN" -> reservationEditMenuView.successfulMessage("Room Number");
            case "CT" -> reservationEditMenuView.successfulMessage("Canoe Type");
            case "ST" -> reservationEditMenuView.successfulMessage("Start time");
            case "DT" -> reservationEditMenuView.successfulMessage("Date");
            case "DR" -> reservationEditMenuView.successfulMessage("Duration");
        }
    }


    public boolean checkFreeReservation(Reservation cReservation){
        String startT = cReservation.getStartTime();
        String endT = cReservation.getEndTime();
        String canoeID = cReservation.getCanoeId();
        String date = cReservation.getDate();
        for (Reservation reservation: model.getReservations()){
            if(!reservation.equals(cReservation)){
                 if(!reservation.equals(cReservation)&&date.equals(reservation.getDate())&&(startT.equals(reservation.getStartTime())||endT.equals(reservation.getEndTime()))&&canoeID.equals(reservation.getCanoeId())){
                       return false;
                 }
            }

        }
        return true;
    }

    public String checkAvailableCanoeType(String newCanoeType, String date, String startTime, String endTime) {
        List<Canoe> availableCanoes = new ArrayList<>();
        List<Canoe> selectedCanoesType = new ArrayList<>();
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().trim().equals(newCanoeType.trim().toUpperCase(Locale.ROOT))) {
                selectedCanoesType.add(canoe);
            }
        }

        for (Reservation reservation : model.getReservations()) {
            if (date.equals(reservation.getDate()) && (startTime.equals(reservation.getStartTime()))) {
                for (Canoe canoe : selectedCanoesType) {
                    if (!reservation.getCanoeId().equals(canoe.getCanoeId())) {
                        availableCanoes.add(canoe);
                    }
                }
            }
            if (date.equals(reservation.getDate()) && endTime.equals(reservation.getEndTime())) {
                for (Canoe canoe : selectedCanoesType) {
                    if (!reservation.getCanoeId().equals(canoe.getCanoeId())) {
                        availableCanoes.add(canoe);
                    }
                }
            }
        }

        if (availableCanoes.size() == 0) return null;
        else return availableCanoes.get(0).getCanoeId();
    }

    public String costCalculating(String duration, String canoeId) {
        double price = 0;
        int intDuration = Integer.parseInt(duration.trim());
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                price = Double.parseDouble(canoe.getTripPrice().trim());
            }
        }
        double totalCost = intDuration * price / 30;
        return totalCost + "";
    }

    public String checkAvailabilitycanoeminutes(Reservation reservation, String newCanoeType) throws ParseException {
        List<Canoe> availableCanoes = new ArrayList<>();
        List<Canoe> selectedCanoesType = new ArrayList<>();

        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().trim().equals(newCanoeType.trim().toUpperCase(Locale.ROOT))) {
                selectedCanoesType.add(canoe);
            }
        }

        for(Reservation reservation1: model.getReservations()){
            if (date.equals(reservation.getDate()) && (startTime.equals(reservation.getStartTime()))) {
                for (Canoe canoe : selectedCanoesType) {
                    if (!reservation.getCanoeId().equals(canoe.getCanoeId())) {
                        availableCanoes.add(canoe);
                    }
                }
            }
        }


        for(int i = 0 ; i<=Integer.parseInt(reservation.getDuration()); i++){
            String myTime = reservation.getStartTime();
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date d = df.parse(myTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.MINUTE, 1);

        }

        return null;
    }
}



/*
 for (Reservation reservation : model.getReservations()) {
            if (date.equals(reservation.getDate()) && (startTime.equals(reservation.getStartTime()))) {
                for (Canoe canoe : selectedCanoes) {
                    if (!reservation.getCanoeId().equals(canoe.getCanoeId())) {
                        availableCanoes.add(canoe);
                    }
                }
            }
                if (date.equals(reservation.getDate()) && endTime.equals(reservation.getEndTime())) {
                    for (Canoe canoe : selectedCanoes) {
                        if (!reservation.getCanoeId().equals(canoe.getCanoeId())) {
                            availableCanoes.add(canoe);
                        }
                    }
                }

                if (availableCanoes.size() == 0) return null;
                else return availableCanoes.get(0).getCanoeId();
            }

        return null;
 */