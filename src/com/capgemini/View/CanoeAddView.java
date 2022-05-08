package com.capgemini.View;

import com.capgemini.Model.Canoe;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class CanoeAddView {
    public Canoe execute(String newIdForNewCanoe) {
        String type, numberOfTheSeats, timeOfTheMinimumTrip, tripPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  CANOE ADD MENU  ********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new Canoe"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : "+ TEXT_RESET + newIdForNewCanoe);
        System.out.print(GREEN_BOLD + "Type : "+ TEXT_RESET);
        type = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Number of the Seats : "+ TEXT_RESET);
        numberOfTheSeats = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Time of the Minimum Trip : "+ TEXT_RESET);
        timeOfTheMinimumTrip = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Trip Price : "+ TEXT_RESET);
        tripPrice = scanner.nextLine();
        if (    !newIdForNewCanoe.trim().equals("") &&
                !type.trim().equals("") &&
                !numberOfTheSeats.trim().equals("") &&
                !timeOfTheMinimumTrip.trim().equals("")) {
            return new Canoe(newIdForNewCanoe, type.toUpperCase(), numberOfTheSeats, timeOfTheMinimumTrip.toUpperCase(), tripPrice);
        }
        return null;
    }

    public void succeededMessages() {
        System.out.println(TEXT_RED + "You added a new canoe!" + TEXT_RESET);
    }
    public void failedMessages() { System.out.println(TEXT_RED + "Please fill in the all fields!" + TEXT_RESET); }
}
