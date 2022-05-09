package com.capgemini.View;

import com.capgemini.Model.Reservation;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class ReservationDeleteMenuView {
    Scanner sc = new Scanner(System.in);
    private String inputReservationId, inputRoomNumber;

    public void execute() {
        System.out.println(GREEN_BOLD + "***********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION DELETE MENU  **********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "***********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete a Reservation" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Reservation ID :" + TEXT_RESET);
        inputReservationId = sc.nextLine();
    }

    public void selectedReservation(Reservation reservation) {
        System.out.println(GREEN_BOLD + "Here is the chosen Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation ID : " + TEXT_RESET + reservation.getReservationId());
        System.out.println(GREEN_BOLD + "Room Number    : " + TEXT_RESET + reservation.getRoomNumber());
        System.out.println(GREEN_BOLD + "Canoe Type     : " + TEXT_RESET + reservation.getCanoeType());
        System.out.println(GREEN_BOLD + "Canoe ID       : " + TEXT_RESET + reservation.getCanoeId());
        System.out.println(GREEN_BOLD + "Date           : " + TEXT_RESET + reservation.getDate());
        System.out.println(GREEN_BOLD + "Duration       : " + TEXT_RESET + reservation.getDuration());
        System.out.println(GREEN_BOLD + "Start Time     : " + TEXT_RESET + reservation.getStartTime());
        System.out.println(GREEN_BOLD + "End Time       : " + TEXT_RESET + reservation.getEndTime());


    }

    public boolean checkReservation() {
        System.out.println(TEXT_RED + "Do you want to delete the reservation ? Yes[Y]/No[N]" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        return false;
    }

    public String getInputReservationId() {
        return inputReservationId;
    }

    public String getInputRoomNumber() {
        return inputRoomNumber;
    }

    public void successMessage() {
        System.out.println(TEXT_RED + "Congratulations the reservation is deleted successfully" + TEXT_RESET);
        System.out.println(TEXT_RED + "You deleted the reservation!" + TEXT_RESET);
    }
}
