package com.capgemini.View;

import com.capgemini.Model.Canoe;
import java.util.Locale;
import java.util.Scanner;
import static com.capgemini.Main.*;

public class CanoeEditView {
    Scanner sc = new Scanner(System.in);
    String editId;

    public void executeView() {
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "*********  CANOE EDIT MENU  ********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the id of the canoe that you want to edit" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Id: ");
        editId = sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please choose which info you want to change: Type[TY]-Seats[SE]-MinimumTrip[MT]-Price[PR]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewType() {
        System.out.println(GREEN_BOLD + "Please enter New Type" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New Type: " + TEXT_RESET);
        String type = sc.nextLine();
        while(!(type.toUpperCase().equals("S") || type.toUpperCase().equals("K") || type.toUpperCase().equals("R") || type.toUpperCase().equals("E"))) {
            System.out.println(GREEN_BOLD + "Please choose one of the existed canoe types!"+ TEXT_RESET);
            System.out.print(GREEN_BOLD + "Type: " + TEXT_RESET);
            type = sc.nextLine();
        }
        return type.trim().toUpperCase(Locale.ROOT);
    }

    public String getNewNumberOfTheSeats() {
        System.out.println(GREEN_BOLD + "Please enter the number of seats" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New number of seats: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewTimeOfTheMinimumTrip() {
        System.out.println(GREEN_BOLD + "Please enter minimum tour time" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New minimum tour time :" + TEXT_RESET);
        String timeOfTheMinimumTrip = sc.nextLine();
        while(Integer.parseInt(timeOfTheMinimumTrip) < 30) {
            System.out.println(TEXT_RED + "Duration of the tour must be at least 30 minutes!"+ TEXT_RESET);
            System.out.print(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: "+ TEXT_RESET);
            timeOfTheMinimumTrip = sc.nextLine();
        }
        return timeOfTheMinimumTrip.trim().toUpperCase(Locale.ROOT);
    }

    public String getNewPrice() {
        System.out.println(GREEN_BOLD + "Please enter the new tour price per minimum tour time" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New price: " + TEXT_RESET);
        return sc.nextLine();
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "Congratulations! " + chosenKey + " is changed successfully!" + TEXT_RESET);
    }

    public void selectedCanoe(String id, String type, String seats, String minimumTrip, String price) {
        System.out.println(TEXT_RED + "Here is the selected canoe: " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id: " + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Type: " + TEXT_RESET + type);
        System.out.println(GREEN_BOLD + "Number of the Seats: " + TEXT_RESET + seats);
        System.out.println(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: " + TEXT_RESET + minimumTrip);
        System.out.println(GREEN_BOLD + "Tour Price per " + minimumTrip + " Minutes: " + TEXT_RESET + price);
    }

    public String askSave() {
        System.out.println(GREEN_BOLD + "Do you want to save ? Yes[Y]/No[N]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void editedCanoeView(Canoe canoe) {
        System.out.println(GREEN_BOLD + "Here is the selected canoe: " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id: " + TEXT_RESET + canoe.getCanoeId());
        System.out.println(GREEN_BOLD + "Type: " + TEXT_RESET + canoe.getCanoeType());
        System.out.println(GREEN_BOLD + "Number of the Seats: " + TEXT_RESET + canoe.getNumberOfTheSeats());
        System.out.println(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: " + TEXT_RESET + canoe.getTimeOfTheMinimumTrip());
        System.out.println(GREEN_BOLD + "Tour Price per " + canoe.getTimeOfTheMinimumTrip() + " Minutes: " + TEXT_RESET + canoe.getTripPrice());
    }

    public void warnMessage() {
        System.out.println(GREEN_BOLD + "You entered the wrong key(s)" + TEXT_RESET);
    }
    public String getEditId() {
        return editId.trim().toUpperCase(Locale.ROOT);
    }
}