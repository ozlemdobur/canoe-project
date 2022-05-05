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
        int price = 0;
        int intDuration = Integer.parseInt(duration);
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                price = Integer.parseInt(canoe.getTripPrice());
            }
        }
        int totalCost = intDuration * price / 30;
        return totalCost + "";
    }

    public String newIdForNewReservation() {
        int newIdForNewReservation = Integer.parseInt(model.getReservations().get(model.getReservations().size() - 1).getReservationId());
        return (newIdForNewReservation + 1) + "";

    }

    public String whichCanoeIsFree(String reservationDate, String canoeType) {
        List<Integer> rezervedCanoieId = new <Integer>ArrayList();

        for (Reservation reservation : model.getReservations()) {
            if (reservation.getDate().equals(reservationDate) &&
                    reservation.getCanoeType().equals(canoeType)) {
                rezervedCanoieId.add(Integer.parseInt(reservation.getCanoeId()));
            }
        }
        Collections.sort(rezervedCanoieId);
        if (rezervedCanoieId.size() == 0) {
            return "1";
        }
        int i = 0;
        for (Canoe canoe : model.getCanoes()) {
            while (i < rezervedCanoieId.size()) {
                if (!rezervedCanoieId.get(i).toString().contains(canoe.getCanoeId()) && canoe.getCanoeType().equals(canoeType)) {
                    return canoe.getCanoeId();
                } else {
                    i++;
                    break;
                }
            }


           /* while (i < rezervedCanoieId.size()) {
                if (!rezervedCanoieId.get(i).toString().contains(canoe.getCanoeId()) && canoe.getCanoeType().equals(canoeType)) {
                    return canoe.getCanoeId();
                } else {
                    i++;
                    break;
                }
            }*/
        }
        return null;
    }

    public String defaultCanoeDuration(String canoeId) {
        String defaultCanoeDuration = "30";
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                return canoe.getTimeOfTheMinimumTrip();
            }
        }
        return defaultCanoeDuration;
    }
}
