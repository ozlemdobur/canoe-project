package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.View.ReservationAddView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReservationAddController {
    private Model model;
    private Reservation newReservation;

    public ReservationAddController(Model model) {
        this.model = model;
    }

    public boolean execute() {
        ReservationAddView reservationAddView = new ReservationAddView();
        ReservationProgressController progressController = new ReservationProgressController(model);
        Reservation newReservation = reservationAddView.execute(progressController);        //Reservation newReservation = reservationAddView.execute(model,(model.getReservations().size()+1)+"");
        if(newReservation.getReservationId() == null){
            return false;
        }
        boolean isItSaved = newRecordForAddReservation(newReservation);
        if (isItSaved) {
            reservationAddView.successedMessages();
            return true;
        } else {
            reservationAddView.failedMessages();
            return false;
        }
    }

    public boolean newRecordForAddReservation(Reservation newReservation) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File("src/com/capgemini/Model/ReservationDB"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        model.getReservations().add(newReservation);
        for (Reservation reservations : model.getReservations()) {
            writer.println(reservations.getReservationId() + "," +
                    reservations.getRoomNumber() + "," +
                    reservations.getCanoeType() + "," +
                    reservations.getCanoeId() + "," +
                    reservations.getDate() + "," +
                    reservations.getDuration());
        }
        writer.close();
        return true;

    }
}
