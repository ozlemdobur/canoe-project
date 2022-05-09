package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.View.ReservationAddView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;

public class ReservationAddController {
    private Model model;

    public ReservationAddController(Model model) {
        this.model = model;
    }

    public void execute() throws ParseException {
        ReservationAddView reservationAddView = new ReservationAddView();
        ReservationProgressController progressController = new ReservationProgressController(model);
        Reservation newReservation = reservationAddView.execute(progressController);        //Reservation newReservation = reservationAddView.execute(model,(model.getReservations().size()+1)+"");
        if (newReservation != null) {
            newRecordForAddReservation(newReservation);
        } else {
            reservationAddView.failedMessages();
        }
    }

    public void newRecordForAddReservation(Reservation newReservation) {
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
                    reservations.getDuration() + "," +
                    reservations.getStartTime() + "," +
                    reservations.getEndTime()+ "," +
                    reservations.getCost());
        }
        writer.close();
    }
}
