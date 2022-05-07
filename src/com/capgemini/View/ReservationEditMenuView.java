package com.capgemini.View;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class ReservationEditMenuView {
    Scanner sc = new Scanner(System.in);
    String inputReservationId, inputRoomNumber;

    public String getInputReservationId() {
        return inputReservationId;
    }

    public String getInputRoomNumber() {
        return inputRoomNumber;
    }

    public void executeView() {
        System.out.println(GREEN_BOLD + "********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION EDIT MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to edit a Reservation" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Reservation ID :");
        inputReservationId = sc.nextLine();
        System.out.print(GREEN_BOLD + "Room Number : ");
        inputRoomNumber = sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation ID (RI)" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Room Number (RN)" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Canoe Type (CT)" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Canoe ID (CI)" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Date (DT)" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Duration (DR)" + TEXT_RESET);


        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
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
        System.out.println(GREEN_BOLD + "Are you sure if it is correct reservation that you want to edit? Yes(Y)/No(N)" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        return false;
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "You changed the reservation !" + TEXT_RESET);

    }

    public String getNewReservationId() {
        System.out.println(GREEN_BOLD + "Please enter New Reservation ID" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Reservation ID :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewRoomNumber() {
        System.out.println(GREEN_BOLD + "Please enter New Room Number" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Room Number :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewCanoeType() {
        System.out.println(GREEN_BOLD + "Please enter New Canoe Type" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Canoe Type :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewCanoeId() {
        System.out.println(GREEN_BOLD + "Please enter Canoe ID" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Canoe ID :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewDate() {
        System.out.println(GREEN_BOLD + "Please enter New Date" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Date :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewDuration() {
        System.out.println(GREEN_BOLD + "Please enter New Duration" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Duration :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

}
