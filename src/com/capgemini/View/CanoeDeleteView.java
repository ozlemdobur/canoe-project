package com.capgemini.View;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class CanoeDeleteView {
    Scanner sc = new Scanner(System.in);
    String id;

    public void execute() {
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********  CANOE DELETE MENU  *******" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete a Canoe" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Id: ");
        id = sc.nextLine();
    }

    public String getId() {
        return id.trim().toUpperCase(Locale.ROOT);
    }

    public void selectedCanoe(String id, String type, String seats, String minimumTrip, String price) {
        System.out.println(TEXT_RED + "Here is the selected canoe" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id:" + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Type:" + TEXT_RESET + type);
        System.out.println(GREEN_BOLD + "Number of the Seats:" + TEXT_RESET + seats);
        System.out.println(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: " + TEXT_RESET + minimumTrip);
        System.out.println(GREEN_BOLD + "Tour Price per " + minimumTrip + " Minutes: "  + TEXT_RESET + price);
    }

    public boolean checkUser() {
        System.out.print(GREEN_BOLD + "Are you sure to delete the canoe? Yes(Y)/No(N)" + TEXT_RESET);
        String yesOrNo = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        return yesOrNo.equals("Y");
    }

    public void nFound() { System.out.println(TEXT_RED + "The canoe is not found please check information and try again." + TEXT_RESET); }
    public void successMessage() {
        System.out.println(TEXT_RED + "You deleted the canoe!"+ TEXT_RESET);
    }
}