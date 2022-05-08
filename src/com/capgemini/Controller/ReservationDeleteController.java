package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;
import com.capgemini.View.ReservationDeleteMenuView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.capgemini.Main.*;

public class ReservationDeleteController {
    Model model = new Model();
    private String reservationId, roomNumber, canoeType, canoeId, date, duration;
    ReservationDeleteMenuView reservationDeleteMenuView = new ReservationDeleteMenuView();
    int count = -1;

    public void execute() throws FileNotFoundException {
        reservationDeleteMenuView.execute();
        reservationId = reservationDeleteMenuView.getInputReservationId();
        roomNumber = reservationDeleteMenuView.getInputRoomNumber();

        boolean check = false;
        for (Reservation reservation : model.getReservations()) {
            count++;
            if (reservationId.equals(reservation.getReservationId()) && roomNumber.equals(reservation.getRoomNumber())) {
                canoeType = reservation.getCanoeType();
                canoeId = reservation.getCanoeId();
                date = reservation.getDate();
                duration = reservation.getDuration();
                reservationDeleteMenuView.selectedReservation(reservationId, roomNumber, canoeType, canoeId, date, duration);
                check = true;
                break;
            }
        }

        if (check && reservationDeleteMenuView.checkReservation()) {
            delete(count);
        } else if (!check) {
            System.out.println(TEXT_RED + "The reservation is not found please check the information and try again." + TEXT_RESET);
        }


    }

    private void delete(int index) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/ReservationDB");
        model.getReservations().remove(index);
        writer.print("");
        for (Reservation reservation : model.getReservations()) {
            writer.println(reservation.getReservationId() + "," +
                    reservation.getRoomNumber() + "," +
                    reservation.getCanoeType() + "," +
                    reservation.getCanoeId() + "," +
                    reservation.getDate() + "," +
                    reservation.getDuration());
        }
        writer.close();
        reservationDeleteMenuView.successMessage();
    }

}
