package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.View.ReservationEditMenuView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                Reservation selectedReservation = new Reservation(reservationId,roomNumber,canoeType,canoeId,date,duration,startTime,endTime);
                reservationEditMenuView.selectedReservation(selectedReservation);
                check=true;
                break;
            }
        }

        if(check&&reservationEditMenuView.checkReservation()){
            switch (chosenKey = reservationEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "RN":
                    editedReservation = new Reservation(reservationId,reservationEditMenuView.getNewRoomNumber(),canoeType,canoeId,date,duration,startTime,endTime);
                    write(editedReservation);
                    break;
                case "CT":
                    String newCanoeType =reservationEditMenuView.getNewCanoeType();
                    //String newCanoeID = checkAvailableCanoeType(newCanoeType,date,startTime,endTime);
                    //String newCanoeID = reservationProgressController.whichCanoeIsFree(date,newCanoeType,startTime);
                    editedReservation=new Reservation(reservationId, roomNumber,newCanoeType, canoeId, date, duration,startTime,endTime);
                    String nCanoeId  = availableCanoes(editedReservation,newCanoeType);
                    if(nCanoeId==null){
                        reservationEditMenuView.warningMessage();
                        break;
                    }

                    editedReservation = new Reservation(reservationId, roomNumber,newCanoeType, nCanoeId, date, duration,startTime,endTime);
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
                    String newDate = reservationEditMenuView.getNewDate();
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, newDate, duration,startTime,endTime);
                    String newdateCanoeID = availableCanoes(editedReservation,editedReservation.getCanoeType());
                   if(newdateCanoeID==null){
                       reservationEditMenuView.warningMessage();
                       break;
                }
                   editedReservation= new Reservation(reservationId,roomNumber,canoeType,newdateCanoeID,newDate,duration,startTime,endTime);
                    write(editedReservation);
                    break;
                    /* if(checkFreeReservation(editedReservation)) {
                        write(editedReservation);
                        break;
                    }else {reservationEditMenuView.warningMessage();
                        reservationEditMenuView.noSaved();
                        break;
                    }

                    */

                case "DR":

                    String newDuration = reservationEditMenuView.getNewDuration();
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, date, newDuration,startTime,reservationProgressController.endTimeCalculating(startTime,newDuration));
                    String newdurationCanoeId = availableCanoes(editedReservation,editedReservation.getCanoeType());
                    if(newdurationCanoeId==null){
                        reservationEditMenuView.warningMessage();
                        break;
                    }
                    editedReservation= new Reservation(reservationId,roomNumber,canoeType,newdurationCanoeId,date,newDuration,startTime,reservationProgressController.endTimeCalculating(startTime,newDuration));
                    write(editedReservation);
                    break;
                    /*editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, date,reservationEditMenuView.getNewDuration(),startTime,reservationProgressController.endTimeCalculating(startTime,duration));
                if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                    break;
                }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();
                    break;

                     */

                case "ST":
                    String newSTime = reservationEditMenuView.getNewStartTime().trim();
                    editedReservation = new Reservation(reservationId, roomNumber, canoeType, canoeId, date, duration, newSTime, reservationProgressController.endTimeCalculating(newSTime, duration));
                    String newstCanoeId = availableCanoes(editedReservation,editedReservation.getCanoeType());
                    if(newstCanoeId==null){
                        reservationEditMenuView.warningMessage();
                        break;
                    }
                    editedReservation= new Reservation(reservationId,roomNumber,canoeType,newstCanoeId,date,duration,newSTime,reservationProgressController.endTimeCalculating(newSTime,duration));
                    write(editedReservation);
                    break;
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

    public String availableCanoes(Reservation reservation, String newCanoeType) throws ParseException {
        List<String> selectedCanoes = new ArrayList<>();

        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().trim().equals(newCanoeType.trim().toUpperCase(Locale.ROOT))) {
                selectedCanoes.add(canoe.getCanoeId());
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date stTime = df.parse(reservation.getStartTime());
        Date endTime = df.parse(reservation.getEndTime());
        Date rzStTime;
        Date rzEndTme;


        for(Reservation reservation1: model.getReservations()){

            if(!reservation1.equals(reservation)&&
                    reservation1.getDate().equals(reservation.getDate())&&
                reservation1.getCanoeType().trim().equals(newCanoeType)){

                rzStTime=df.parse(reservation1.getStartTime());
                rzEndTme=df.parse(reservation1.getEndTime());

                if (rzStTime.after(stTime)&&rzStTime.before(endTime)){
                    selectedCanoes.remove(reservation1.getCanoeId());
                }else if(rzEndTme.after(stTime)&&rzEndTme.before(endTime)){
                    selectedCanoes.remove(reservation1.getCanoeId());
                }

            }

        }

        if (!selectedCanoes.isEmpty()){
            return selectedCanoes.get(0);
        }

        return null;
    }
}