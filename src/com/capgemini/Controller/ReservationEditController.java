package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;
import com.capgemini.View.ReservationEditMenuView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationEditController {
    Model model = new Model();
    ReservationEditMenuView reservationEditMenuView = new ReservationEditMenuView();
    private String reservationId,roomNumber,canoeType,canoeId,date,duration,chosenKey;
    int count=-1;
    public void execute() throws FileNotFoundException{
        reservationEditMenuView.executeView();
        reservationId=reservationEditMenuView.getInputReservationId().trim().toUpperCase(Locale.ROOT);
        roomNumber=reservationEditMenuView.getInputRoomNumber().trim().toUpperCase(Locale.ROOT);

        boolean check=false;
        for(Reservation reservation : model.getReservations()){
            count++;
            if(reservationId.equals(reservation.getReservationId())&&roomNumber.equals(reservation.getRoomNumber())){
                canoeType=reservation.getCanoeType();
                canoeId=reservation.getCanoeId();
                date=reservation.getDate();
                duration=reservation.getDuration();
                reservationEditMenuView.selectedReservation(reservationId,roomNumber,canoeType,canoeId,date,duration);
                check=true;
                break;
            }
        }

        if(check&&reservationEditMenuView.checkReservation()){
            switch (chosenKey=reservationEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "RI":
                    write(reservationEditMenuView.getNewReservationId(),roomNumber,canoeType,canoeId,date,duration);
                    break;
                case "RN":
                    write(reservationId,reservationEditMenuView.getNewRoomNumber(),canoeType,canoeId,date,duration);
                    break;
                case "CT":
                    write(reservationId,roomNumber,reservationEditMenuView.getNewCanoeType(),canoeId,date,duration);
                    break;
                case "CI":
                    write(reservationId,roomNumber,canoeType,reservationEditMenuView.getNewCanoeId(),date,duration);
                    break;
                case "DT":
                    write(reservationId,roomNumber,canoeType,canoeId,reservationEditMenuView.getNewDate(),duration);
                    break;
                case "DR":
                    write(reservationId,roomNumber,canoeType,canoeId,date,reservationEditMenuView.getNewDuration());
                    break;
                default:
                    System.out.println(GREEN_BOLD + "You entered wrong key." + TEXT_RESET);
            }
        }else if (!check){
            System.out.println(GREEN_BOLD + "The reservation is not found please check the information and try again." + TEXT_RESET);
        }
    }

    private void write(String reservationId, String roomNumber, String canoeType, String canoeId, String date, String duration) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/ReservationDB");
        model.getReservations().remove(count);
        writer.print("");
        for (Reservation reservation : model.getReservations()) {
            writer.println(reservation.getReservationId() + "," +
                    reservation.getRoomNumber() + "," +
                    reservation.getCanoeType() + "," +
                    reservation.getCanoeId() + "," +
                    reservation.getDate() + "," +
                    reservation.getDuration());
        }
        writer.println(reservationId+","+roomNumber+","+canoeType+","+canoeId+","+date+","+duration);
        writer.close();
        message(chosenKey);
    }

    public void message(String shortcut){
        switch (shortcut) {
            case "RI":
                reservationEditMenuView.successfulMessage("Reservation ID");
                break;
            case "RN":
                reservationEditMenuView.successfulMessage("Room Number");
                break;
            case "CT":
                reservationEditMenuView.successfulMessage("Canoe Type");
                break;
            case "CI":
                reservationEditMenuView.successfulMessage("Canoe ID");
                break;
            case "DT":
                reservationEditMenuView.successfulMessage("Date");
                break;
            case "DR":
                reservationEditMenuView.successfulMessage("Duration");
                break;
        }
    }
}
