package com.capgemini.View;

import com.capgemini.Model.Reservation;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class ReservationEditMenuView {
    Scanner sc = new Scanner(System.in);
    String inputReservationId, inputRoomNumber;

    public String getInputReservationId() {
        return inputReservationId;
    }


    public void executeView() {
        System.out.println(GREEN_BOLD + "*********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION EDIT MENU  **********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "*********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to edit a Reservation" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Reservation ID :");
        inputReservationId = sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Room Number  [RN]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Canoe Type   [CT]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Date         [DT]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Duration     [DR]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Start Time   [ST]" + TEXT_RESET);



        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void selectedReservation(Reservation reservation) {
        System.out.println(GREEN_BOLD + "Here is the chosen Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation ID  : " + TEXT_RESET + reservation.getReservationId());
        System.out.println(GREEN_BOLD + "Room Number     : " + TEXT_RESET + reservation.getRoomNumber());
        System.out.println(GREEN_BOLD + "Canoe Type      : " + TEXT_RESET + reservation.getCanoeType());
        System.out.println(GREEN_BOLD + "Canoe ID        : " + TEXT_RESET + reservation.getCanoeId());
        System.out.println(GREEN_BOLD + "Date            : " + TEXT_RESET + reservation.getDate());
        System.out.println(GREEN_BOLD + "Duration        : " + TEXT_RESET + reservation.getDuration());
        System.out.println(GREEN_BOLD + "Start time      : " + TEXT_RESET + reservation.getStartTime());
        System.out.println(GREEN_BOLD + "End Time        : " + TEXT_RESET + reservation.getEndTime());
        System.out.println(GREEN_BOLD + "Cost            : " + TEXT_RESET + reservation.getCost());


    }

    public boolean checkReservation() {
        System.out.println(GREEN_BOLD + "Is it the correct reservation? Yes[Y]/No[N]" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        return false;
    }
    public boolean saveReservation(Reservation reservation) {
        System.out.println(GREEN_BOLD + "Reservation ID  : " + TEXT_RESET + reservation.getReservationId());
        System.out.println(GREEN_BOLD + "Room Number     : " + TEXT_RESET + reservation.getRoomNumber());
        System.out.println(GREEN_BOLD + "Canoe Type      : " + TEXT_RESET + reservation.getCanoeType());
        System.out.println(GREEN_BOLD + "Canoe ID        : " + TEXT_RESET + reservation.getCanoeId());
        System.out.println(GREEN_BOLD + "Date            : " + TEXT_RESET + reservation.getDate());
        System.out.println(GREEN_BOLD + "Duration        : " + TEXT_RESET + reservation.getDuration());
        System.out.println(GREEN_BOLD + "Start time      : " + TEXT_RESET + reservation.getStartTime());
        System.out.println(GREEN_BOLD + "End Time        : " + TEXT_RESET + reservation.getEndTime());
        System.out.println(GREEN_BOLD + "Cost            : " + TEXT_RESET + reservation.getCost());
        System.out.println(TEXT_RED + "Do you want to save the changes? Yes[Y]/No[N]" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        System.out.println(TEXT_RED + "Changes are not saved." + TEXT_RESET);
        return false;
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "Congratulations " + chosenKey + " is changed successfully!!!!" + TEXT_RESET);
    }


    public String getNewRoomNumber() {
        System.out.println(GREEN_BOLD + "Please enter New Room Number" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Room Number: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewCanoeType() {
        System.out.println(GREEN_BOLD + "Please enter New Canoe Type" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Sup board(1 Person)    [ S ]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Kajak(2 Persons)       [ K ]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Rowing(4 Persons)      [ R ]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Electrical (4 Persons) [ E ]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }


    public String getNewDate() {
        System.out.println(GREEN_BOLD + "Please enter New Date" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Date [DD-MM-YYYY]: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewDuration() {
        System.out.println(GREEN_BOLD + "Please enter New Duration" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Duration: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewStartTime() {
        System.out.println(GREEN_BOLD + "Please enter New Start Time" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Start Time [hh:mm]: " + TEXT_RESET);
        String newSTime = sc.nextLine();
        if (!newSTime.contains(":")) {
            System.out.println(TEXT_RED + "You entered wrong time format." + TEXT_RESET);
            return null;
        }
        return newSTime.trim().toUpperCase(Locale.ROOT);
    }

    public void warningMessage(){
        System.out.println(TEXT_RED + "This reservation is already booked." + TEXT_RESET);
        System.out.println(TEXT_RED + "Please select another canoe type, reservation time, date, duration!" + TEXT_RESET);
    }

    public void noSaved(){
        System.out.println(TEXT_RED + "Changes are not saved." + TEXT_RESET);
    }
}