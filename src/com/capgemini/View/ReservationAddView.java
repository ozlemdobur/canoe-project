package com.capgemini.View;

import com.capgemini.Controller.ReservationProgressController;
import com.capgemini.Model.Reservation;

import java.text.ParseException;
import java.util.*;

import static com.capgemini.Main.TEXT_RED;
import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationAddView {

    public Reservation execute(ReservationProgressController progressController) throws ParseException {
        String roomNumber, canoeType, reservationDate, duration, canoeId, startTime, endTime;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "*******************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION ADD MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "*******************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation Id : " + progressController.newIdForNewReservation() + TEXT_RESET);
        //Reservation Id
        System.out.println(GREEN_BOLD + "Reservation Id : " + progressController.newIdForNewReservation() + TEXT_RESET);
        //Room Number
        System.out.print(GREEN_BOLD + "Room Number : " + TEXT_RESET);
        roomNumber = scanner.nextLine();
        //Canoe Type
        System.out.println(GREEN_BOLD + "Supboard(1 Person) [ S ] - Kajak(2 Persons) - [ K ] - Rowing(4 Persons) [ R ]- Electrical (4 Persons) [ E ]" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Canoe Type : " + TEXT_RESET);
        canoeType = scanner.nextLine().toUpperCase();
        //Reservation Date
        System.out.print(GREEN_BOLD + "Date [dd-mm-yyyy] : " + TEXT_RESET);
        reservationDate = scanner.nextLine();
        //Control the date if it is before today
        if (!progressController.dateChecking(reservationDate)) {
            System.out.println(TEXT_RED + "Please enter the correct day format!" + TEXT_RESET);
            return null;
        }
        //Starting Time -- Control the time if it is correct type
        System.out.print(GREEN_BOLD + "Start Time [ hh:mm ] : " + TEXT_RESET);
        startTime = scanner.nextLine().toUpperCase();
        if (!startTime.contains(":")) {
            System.out.println(TEXT_RED + "Please enter the correct time format!" + TEXT_RESET);
            return null;
        }
        //Duration of the trip Invoke the default trip from the canoedb
        duration = progressController.defaultCanoeDuration(canoeType);
        System.out.print(GREEN_BOLD + "Duration (default " + duration + " minutes) : " + TEXT_RESET);
        duration = scanner.nextLine();
        if (duration.equals("")) {
            duration = progressController.defaultCanoeDuration(canoeType);
        }
        //It calculates the endtime of the trip by using the starttime and the duration
        endTime = progressController.endTimeCalculating(startTime, duration);
        System.out.println(GREEN_BOLD + "END TIME : " + endTime + TEXT_RESET);
        //It gives automaticly a canoid
        canoeId = progressController.whichCanoeIsFree(reservationDate, canoeType, startTime);
        if (canoeId == null) {
            warningMessages();
            return new Reservation();
        }
        System.out.println(GREEN_BOLD + "Canoe Id: " + canoeId + TEXT_RESET);
        //It calculates the total cost by using the duration and canoeid
        String cost = progressController.costCalculating(duration, canoeId);
        System.out.println(GREEN_BOLD + "TOTAL COST : " + cost + TEXT_RESET);

        //Confirm Screen to add a new reservation
        System.out.print(GREEN_BOLD + "DO YOU WANT TO ADD NEW RESERVATION [ Y / N]) " + TEXT_RESET);
        String answer = scanner.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            if (!progressController.newIdForNewReservation().trim().equals("") && !roomNumber.trim().equals("") && !canoeType.trim().equals("") && !reservationDate.trim().equals("") && !duration.trim().equals("")) {
                Reservation newReservation = new Reservation(progressController.newIdForNewReservation(), roomNumber, canoeType, canoeId, reservationDate, duration, startTime, endTime);
                successedMessages();
                return newReservation;
            }else{
                failedMessages();
                return null;
            }
        }
        return null;
    }

    public void successedMessages() {
        System.out.println(TEXT_RED + "You added a new reservation!" + TEXT_RESET);
    }

    public void warningMessages() {
        System.out.println(TEXT_RED + "Please select others canoe type!" + TEXT_RESET);
    }

    public void failedMessages() {
        System.out.println(TEXT_RED + "You didn't add a new reservation!" + TEXT_RESET);
    }
}
