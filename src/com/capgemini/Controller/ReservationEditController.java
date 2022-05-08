package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.Reservations;
import com.capgemini.View.ReservationEditMenuView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
                if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();
                }
                    break;
                case "CT":
                    String newCanoeType =reservationEditMenuView.getNewCanoeType();
                    String newCanoeID = checkAvailableCanoeType(newCanoeType,date,startTime,endTime);

                    if(newCanoeID==null){
                        reservationEditMenuView.warningMessage();
                        break;
                    }

                    editedReservation = new Reservation(reservationId, roomNumber,newCanoeType, newCanoeID, date, duration,startTime,endTime);
                    if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                    break;
                    }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();
                    break;
                    }
                case "DT":
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, reservationEditMenuView.getNewDate(), duration,startTime,endTime);
                    if(checkFreeReservation(editedReservation)) {
                        write(editedReservation);
                        break;
                    }else {reservationEditMenuView.warningMessage();
                        reservationEditMenuView.noSaved();
                        break;
                    }

                case "DR":
                    duration=reservationEditMenuView.getNewDuration();
                    editedReservation= new Reservation(reservationId, roomNumber, canoeType, canoeId, date,duration,startTime,reservationProgressController.endTimeCalculating(startTime,duration));
                if(checkFreeReservation(editedReservation)) {
                    write(editedReservation);
                    break;
                }else {reservationEditMenuView.warningMessage();
                    reservationEditMenuView.noSaved();
                    break;
                }
                case "ST":
                    String newSTime = reservationEditMenuView.getNewStartTime().trim();
                    editedReservation = new Reservation(reservationId, roomNumber, canoeType, canoeId, date, duration, newSTime, reservationProgressController.endTimeCalculating(newSTime, duration));
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
        if(reservationEditMenuView.saveReservation()) {
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
           if(date.equals(reservation.getDate())){
               if(startT.equals(reservation.getStartTime())){
                   if(canoeID.equals(reservation.getCanoeId())){
                       return false;
                   }
               }
           }
        }
        return true;
    }

    public String checkAvailableCanoeType(String newCanoeType, String date, String startTime, String endTime) {
        List<Canoe> availableCanoes = new ArrayList<>();
        List<Canoe> selectedCanoesType = new ArrayList<>();
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().equals(newCanoeType.trim().toUpperCase(Locale.ROOT))) {
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