package com.capgemini.View;

import com.capgemini.Controller.ReservationAddController;
import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;

import java.util.*;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationAddView {

    public Reservation execute(Model model, String newIdForNewReservation) {
        String roomNumber, canoeType, reservationDate, duration, canoeId;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION ADD MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation Id : " + TEXT_RESET + newIdForNewReservation);
        System.out.print(GREEN_BOLD + "Room Number : " + TEXT_RESET);
        roomNumber = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Date [dd-mm-yyyy] : " + TEXT_RESET);
        reservationDate = scanner.nextLine();
        System.out.println(GREEN_BOLD + "Supboard(1 Person) [ S ] - Kajak(2 Persons) - [ K ] - Rowing(4 Persons) [ R ]- Electrical (4 Persons) [ E ]" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Canoe Type : " + TEXT_RESET);
        canoeType = scanner.nextLine().toUpperCase();
        canoeId = whichCanoeIsFree(model, reservationDate, canoeType);
        System.out.print(GREEN_BOLD + "Canoe Id: " + TEXT_RESET);
        duration = defaultCanoeDuration(model, canoeId);
        System.out.print(GREEN_BOLD + "Duration (default " + duration + " minutes) : " + TEXT_RESET);
        if (scanner.nextLine().equals("")) {
            duration = defaultCanoeDuration(model, canoeId);
        }
        System.out.println(duration);
        System.out.println(canoeId);
        if (!newIdForNewReservation.trim().equals("") && !roomNumber.trim().equals("") && !canoeType.trim().equals("") && !reservationDate.trim().equals("") && !duration.trim().equals("")) {
            Reservation newReservation = new Reservation(newIdForNewReservation, roomNumber, canoeType, canoeId, reservationDate, duration);
            return newReservation;
        }
        return null;
    }

    public String defaultCanoeDuration(Model model, String canoeId) {
        String defaultCanoeDuration = "30";
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                return canoe.getTimeOfTheMinimumTrip();
            }
        }
        return defaultCanoeDuration;
    }

    public String whichCanoeIsFree(Model model, String reservationDate, String canoeType) {
        List<String> rezervedCanoieId = new <String>ArrayList();
        for (Reservation reservation : model.getReservations()) {
            if (reservation.getDate().equals(reservationDate) &&
                    reservation.getCanoeType().equals(canoeType)) {
                rezervedCanoieId.add(reservation.getCanoeId());
            }
        }
       Collections.sort(rezervedCanoieId);
        for (int i = 0; i < rezervedCanoieId.size(); i++) {
            for (Canoe canoe : model.getCanoes()) {
                if (!canoe.getCanoeId().contains(rezervedCanoieId.get(i)) && canoe.getCanoeType().equals(canoeType)) {
                    return canoe.getCanoeId();
                }
            }
        }
        return null;
    }

    public void successedMessages() {
        System.out.println(GREEN_BOLD + "You added a new reservation!" + TEXT_RESET);
    }

    public void failedMessages() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields!" + TEXT_RESET);
    }
}
