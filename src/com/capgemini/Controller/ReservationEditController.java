package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.View.ReservationEditMenuView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationEditController {
    Model model = new Model();
    ReservationEditMenuView reservationEditMenuView = new ReservationEditMenuView();
    private String canoeType;
    private String canoeId;
    private String date;
    private String duration;
    private String chosenKey;
    int count=-1;
    public void execute() throws FileNotFoundException{
        reservationEditMenuView.executeView();
        String reservationId = reservationEditMenuView.getInputReservationId().trim().toUpperCase(Locale.ROOT);
        String roomNumber = reservationEditMenuView.getInputRoomNumber().trim().toUpperCase(Locale.ROOT);

        boolean check=false;
        for(Reservation reservation : model.getReservations()){
            count++;
            if(reservationId.equals(reservation.getReservationId())&& roomNumber.equals(reservation.getRoomNumber())){
                canoeType=reservation.getCanoeType();
                canoeId=reservation.getCanoeId();
                date=reservation.getDate();
                duration=reservation.getDuration();
                reservationEditMenuView.selectedReservation(reservationId, roomNumber,canoeType,canoeId,date,duration);
                check=true;
                break;
            }
        }

        if(check&&reservationEditMenuView.checkReservation()){
            switch (chosenKey = reservationEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "RI" -> write(reservationEditMenuView.getNewReservationId(), roomNumber, canoeType, canoeId, date, duration);
                case "RN" -> write(reservationId, reservationEditMenuView.getNewRoomNumber(), canoeType, canoeId, date, duration);
                case "CT" -> write(reservationId, roomNumber, reservationEditMenuView.getNewCanoeType(), canoeId, date, duration);
                case "CI" -> write(reservationId, roomNumber, canoeType, reservationEditMenuView.getNewCanoeId(), date, duration);
                case "DT" -> write(reservationId, roomNumber, canoeType, canoeId, reservationEditMenuView.getNewDate(), duration);
                case "DR" -> write(reservationId, roomNumber, canoeType, canoeId, date, reservationEditMenuView.getNewDuration());
                default -> System.out.println(GREEN_BOLD + "You entered wrong key." + TEXT_RESET);
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
            case "RI" -> reservationEditMenuView.successfulMessage("Reservation ID");
            case "RN" -> reservationEditMenuView.successfulMessage("Room Number");
            case "CT" -> reservationEditMenuView.successfulMessage("Canoe Type");
            case "CI" -> reservationEditMenuView.successfulMessage("Canoe ID");
            case "DT" -> reservationEditMenuView.successfulMessage("Date");
            case "DR" -> reservationEditMenuView.successfulMessage("Duration");
        }
    }
}
