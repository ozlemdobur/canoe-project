package com.capgemini.View;

import com.capgemini.Controller.ReservationProgressController;
import com.capgemini.Model.Reservation;

import java.util.*;

import static com.capgemini.Main.TEXT_RED;
import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationAddView {

    public Reservation execute(ReservationProgressController progressController) {
        String roomNumber, canoeType, reservationDate, duration, canoeId;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION ADD MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation Id : " + TEXT_RESET + progressController.newIdForNewReservation());
        System.out.print(GREEN_BOLD + "Room Number : " + TEXT_RESET);
        roomNumber = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Date [dd-mm-yyyy] : " + TEXT_RESET);
        reservationDate = scanner.nextLine();
        System.out.println(GREEN_BOLD + "Supboard(1 Person) [ S ] - Kajak(2 Persons) - [ K ] - Rowing(4 Persons) [ R ]- Electrical (4 Persons) [ E ]" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Canoe Type : " + TEXT_RESET);
        canoeType = scanner.nextLine().toUpperCase();
        canoeId = progressController.whichCanoeIsFree(reservationDate, canoeType);
        if (canoeId == null) {
            warningMessages();
            return new Reservation();
        }
        System.out.println(GREEN_BOLD + "Canoe Id: " + canoeId + TEXT_RESET);
        duration = progressController.defaultCanoeDuration(canoeId);
        System.out.print(GREEN_BOLD + "Duration (default " + duration + " minutes) : " + TEXT_RESET);
        duration = scanner.nextLine();
        if (duration.equals("")) {
            duration = progressController.defaultCanoeDuration(canoeId);
        }
        String cost = progressController.costCalculating(duration, canoeId);
        System.out.println(TEXT_RED + "TOTAL COST : " + cost);
        System.out.print(TEXT_RED + "DO YOU WANT TO ADD NEW RESERVATION [ Y / N]) " + TEXT_RESET);
        String answer = scanner.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            if (!progressController.newIdForNewReservation().trim().equals("") && !roomNumber.trim().equals("") && !canoeType.trim().equals("") && !reservationDate.trim().equals("") && !duration.trim().equals("")) {
                Reservation newReservation = new Reservation(progressController.newIdForNewReservation(), roomNumber, canoeType, canoeId, reservationDate, duration);
                return newReservation;
            }
        }
        return new Reservation();
    }

    public void successedMessages() {
        System.out.println(TEXT_RED + "You added a new reservation!" + TEXT_RESET);
    }

    public void warningMessages() {
        System.out.println(TEXT_RED + "The canoe type is full.Please select others canoe type!" + TEXT_RESET);
    }

    public void failedMessages() {
        System.out.println(TEXT_RED + "Please fill in the all fields!" + TEXT_RESET);
    }
}
