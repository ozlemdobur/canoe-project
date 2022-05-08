package com.capgemini.View;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class ReservationDeleteMenuView {
    Scanner sc = new Scanner(System.in);
    private String inputReservationId, inputRoomNumber;

    public void execute() {
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  Reservation DELETE MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete a Reservation" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Reservation ID :" + TEXT_RESET);
        inputReservationId = sc.nextLine();
        System.out.println(GREEN_BOLD + "Room Number : " + TEXT_RESET);
        inputRoomNumber = sc.nextLine();
    }

    public void selectedReservation(String reservationId, String roomNumber, String canoeType, String canoeID, String date, String duration) {
        System.out.println(GREEN_BOLD + "Here is the chosen Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation ID :" + TEXT_RESET + reservationId);
        System.out.println(GREEN_BOLD + "Room Number :" + TEXT_RESET + roomNumber);
        System.out.println(GREEN_BOLD + "Canoe Type :" + TEXT_RESET + canoeType);
        System.out.println(GREEN_BOLD + "Canoe ID :" + TEXT_RESET + canoeID);
        System.out.println(GREEN_BOLD + "Date :" + TEXT_RESET + date);
        System.out.println(GREEN_BOLD + "Duration :" + TEXT_RESET + duration);

    }

    public boolean checkReservation() {
        System.out.println(TEXT_RED + "Are you sure if it is correct reservation that you want to delete? Yes(Y)/No(N)" + TEXT_RESET);
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
    }
}
