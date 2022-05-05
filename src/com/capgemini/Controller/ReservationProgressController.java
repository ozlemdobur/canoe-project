package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationProgressController {
    private Model model;

    public ReservationProgressController(Model model) {
        this.model = model;
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

    public String newIdForNewReservation() {
        int newIdForNewReservation = Integer.parseInt(model.getReservations().get(model.getReservations().size() - 1).getReservationId());
        return (newIdForNewReservation + 1) + "";

    }

    public String whichCanoeIsFree(String reservationDate, String canoeType) {
        List<Integer> rezervedCanoeId = new <Integer>ArrayList();

        for (Reservation reservation : model.getReservations()) {
            if (reservation.getDate().equals(reservationDate) &&
                    reservation.getCanoeType().equals(canoeType)) {
                rezervedCanoeId.add(Integer.parseInt(reservation.getCanoeId()));
            }
        }
        Collections.sort(rezervedCanoeId);
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().equals(canoeType)) {
                if (!rezervedCanoeId.contains(Integer.valueOf(canoe.getCanoeId()))) {
                    return canoe.getCanoeId();
                }
            }
        }
        return null;
    }

    public String defaultCanoeDuration(String canoeId) {
        String defaultCanoeDuration = "30";
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                return canoe.getTimeOfTheMinimumTrip().trim();
            }
        }
        return defaultCanoeDuration;
    }
}
