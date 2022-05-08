package com.capgemini.View;

import com.capgemini.Model.Canoe;
import java.util.Locale;
import java.util.Scanner;
import static com.capgemini.Main.*;

public class CanoeEditView {
    Scanner sc = new Scanner(System.in);
    String editId, editType, editSeats, editMinimumTrip, editPrice;

    public void executeView() {
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "*********  CANOE EDIT MENU  ********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the id of the canoe who you want to edit" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "ID : ");
        editId = sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change Type[TY]-Seats[SE]-MinimumTrip[MT]-Price[PR]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewType() {
        System.out.println(GREEN_BOLD + "Please enter New Type" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New Type :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewNumberOfTheSeats() {
        System.out.println(GREEN_BOLD + "Please enter new number of the seats" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New number of the seats :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewTimeOfTheMinimumTrip() {
        System.out.println(GREEN_BOLD + "Please enter new time of the minimum trip" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New time of the minimum trip :" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewPrice() {
        System.out.println(GREEN_BOLD + "Please enter new price" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New price :" + TEXT_RESET);
        return sc.nextLine();
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "Congratulations " + chosenKey + " is changed successfully!!!!" + TEXT_RESET);
    }

    public void selectedCanoe(String id, String type, String seats, String minimumTrip, String price) {
        System.out.println(TEXT_RED + "Here is the selected canoe: " + TEXT_RESET);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Type :" + TEXT_RESET + type);
        System.out.println(GREEN_BOLD + "Number of the Seats :" + TEXT_RESET + seats);
        System.out.println(GREEN_BOLD + "Time of the Minimum Trip :" + TEXT_RESET + minimumTrip);
        System.out.println(GREEN_BOLD + "Trip Price :" + TEXT_RESET + price);
    }

    public String askSave() {
        System.out.println(GREEN_BOLD + "Do you want to save ? Yes[Y]/No[N]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void editedCanoeView(Canoe canoe) {
        System.out.println(GREEN_BOLD + "Here is the selected canoe" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET + canoe.getCanoeId());
        System.out.println(GREEN_BOLD + "Type :" + TEXT_RESET + canoe.getCanoeType());
        System.out.println(GREEN_BOLD + "Number of the Seats :" + TEXT_RESET + canoe.getNumberOfTheSeats());
        System.out.println(GREEN_BOLD + "Time of the Minimum Trip :" + TEXT_RESET + canoe.getTimeOfTheMinimumTrip());
        System.out.println(GREEN_BOLD + "Trip Price :" + TEXT_RESET + canoe.getTripPrice());
    }

    public void warnMessage() {
        System.out.println(GREEN_BOLD + "You entered wrong key(s)" + TEXT_RESET);
    }
    public String getEditId() {
        return editId.trim().toUpperCase(Locale.ROOT);
    }
}