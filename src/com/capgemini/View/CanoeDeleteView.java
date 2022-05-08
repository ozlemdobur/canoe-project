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
        System.out.print(GREEN_BOLD + "ID : ");
        id = sc.nextLine();
    }

    public String getId() {
        return id.trim().toUpperCase(Locale.ROOT);
    }

    public void selectedCanoe(String id, String type, String seats, String minimumTrip, String price) {
        System.out.println(TEXT_RED + "Here is the selected canoe" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Type :" + TEXT_RESET + type);
        System.out.println(GREEN_BOLD + "Number of the Seats :" + TEXT_RESET + seats);
        System.out.println(GREEN_BOLD + "Time of the Minimum Trip :" + TEXT_RESET + minimumTrip);
        System.out.println(GREEN_BOLD + "Trip Price :" + TEXT_RESET + price);
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
    public void failMessage() {
        System.out.println(TEXT_RED + "Please fill in the all fields with correct information!"+ TEXT_RESET);
    }
}