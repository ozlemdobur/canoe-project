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
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  RESERVATION EDIT MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to edit a Reservation" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Reservation ID :");
        inputReservationId = sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Room Number [RN]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Canoe Type [CT]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Date [DT]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Duration [DR]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Start Time [ST]" + TEXT_RESET);



        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void selectedReservation(Reservation reservation) {
        System.out.println(GREEN_BOLD + "Here is the chosen Reservation" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Reservation ID :" + TEXT_RESET + reservation.getReservationId());
        System.out.println(GREEN_BOLD + "Room Number :" + TEXT_RESET + reservation.getRoomNumber());
        System.out.println(GREEN_BOLD + "Canoe Type :" + TEXT_RESET + reservation.getCanoeType());
        System.out.println(GREEN_BOLD + "Canoe ID :" + TEXT_RESET + reservation.getCanoeId());
        System.out.println(GREEN_BOLD + "Date :" + TEXT_RESET + reservation.getDate());
        System.out.println(GREEN_BOLD + "Duration :" + TEXT_RESET + reservation.getDuration());
        System.out.println(GREEN_BOLD + "Start time :" + TEXT_RESET + reservation.getStartTime());
        System.out.println(GREEN_BOLD + "End Time :" + TEXT_RESET + reservation.getEndTime());


    }

    public boolean checkReservation() {
        System.out.println(GREEN_BOLD + "Are you sure if it is correct reservation that you want to edit? Yes[Y]/No[N]" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        return false;
    }
    public boolean saveReservation() {
        System.out.println(TEXT_RED + "Do yu want to save the changes? Yes[Y]/No[N]" + TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if (yesorno.equals("Y")) {
            return true;
        }
        System.out.println(TEXT_RED + "Changes are not saved" + TEXT_RESET);
        return false;
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "Congratulations " + chosenKey + " is changed successfully!!!!" + TEXT_RESET);
        System.out.println(TEXT_RED + "You edited the reservation !" + TEXT_RESET);

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

    public String getNewStartTime() {
        System.out.println(GREEN_BOLD + "Please enter New Start Time" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Start Time [hh:mm]:" + TEXT_RESET);
        String newSTime = sc.nextLine();
        if (!newSTime.contains(":")) {
            System.out.println(TEXT_RED + "You entered wrong time format." + TEXT_RESET);
            return null;
        }
        return newSTime;
    }

    public void warningMessage(){
        System.out.println(TEXT_RED + "This reservation is already booked, Please select others canoe type, reservation time, date, duration!" + TEXT_RESET);
    }

    public void noSaved(){
        System.out.println(TEXT_RED + "Changes are not saved, previous reservation is still booked" + TEXT_RESET);
    }
}