package com.capgemini.View;

import com.capgemini.Model.Canoe;

import java.util.Locale;
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
        System.out.println(GREEN_BOLD + "Id: " + TEXT_RESET + newIdForNewCanoe);

        System.out.println(GREEN_BOLD + "Supboard(1 Person) [ S ] - Kajak(2 Persons) - [ K ] - Rowing(4 Persons) [ R ]- Electrical (4 Persons) [ E ]" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Type: " + TEXT_RESET);
        type = scanner.nextLine().toUpperCase(Locale.ROOT);
        while(!(type.toUpperCase().equals("S") || type.toUpperCase().equals("K") || type.toUpperCase().equals("R") || type.toUpperCase().equals("E"))) {
            System.out.println(GREEN_BOLD + "Please choose one of the existed canoe types!"+ TEXT_RESET);
            System.out.print(GREEN_BOLD + "Type: " + TEXT_RESET);
            type = scanner.nextLine();
        }

        System.out.print(GREEN_BOLD + "Number of the Seats: "+ TEXT_RESET);
        numberOfTheSeats = scanner.nextLine();

        System.out.print(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: "+ TEXT_RESET);
        timeOfTheMinimumTrip = scanner.nextLine();
        while(Integer.parseInt(timeOfTheMinimumTrip) < 30) {
                System.out.println(TEXT_RED + "Duration of the tour must be at least 30 minutes!"+ TEXT_RESET);
                System.out.print(GREEN_BOLD + "Duration(Minutes) of the Minimum Tour: "+ TEXT_RESET);
                timeOfTheMinimumTrip = scanner.nextLine();
        }

        System.out.print(GREEN_BOLD + "Tour Price per " + timeOfTheMinimumTrip + " Minutes: " + TEXT_RESET);
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