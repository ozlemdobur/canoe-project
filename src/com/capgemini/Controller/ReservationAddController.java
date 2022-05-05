package com.capgemini.Controller;

<<<<<<< HEAD
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
=======
import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
import com.capgemini.View.ReservationAddView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85

public class ReservationAddController {
    private Model model;
    private Reservation newReservation;

    public ReservationAddController(Model model) {
        this.model = model;
    }

<<<<<<< HEAD
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
=======
    public void execute()  {
        ReservationAddView reservationAddView = new ReservationAddView();
        Reservation newReservation = reservationAddView.execute(model,(model.getReservations().size()+1)+"");
        //boolean isItSaved = newRecordForAddReservation();
        //reservationAddView.successedMessages();

    }

    public boolean newRecordForAddReservation(Reservation newReservation){
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
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
