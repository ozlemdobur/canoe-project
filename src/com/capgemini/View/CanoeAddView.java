package com.capgemini.View;

import com.capgemini.Model.Canoe;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class CanoeAddView {
    public Canoe execute(String newIdForNewCanoe) {
        String type, numberOfTheSeats, timeOfTheMinimumTrip, tripPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER ADD MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new User"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : "+ TEXT_RESET + newIdForNewCanoe);
        System.out.print(GREEN_BOLD + "Type : "+ TEXT_RESET);
        type = scanner.nextLine();
        System.out.print(GREEN_BOLD + "NumberOfTheSeats : "+ TEXT_RESET);
        numberOfTheSeats = scanner.nextLine();
        System.out.print(GREEN_BOLD + "timeOfTheMinimumTrip : "+ TEXT_RESET);
        timeOfTheMinimumTrip = scanner.nextLine();
        System.out.print(GREEN_BOLD + "tripPrice : "+ TEXT_RESET);
        tripPrice = scanner.nextLine();
        if (    !newIdForNewCanoe.trim().equals("") &&
                !type.trim().equals("") &&
                !numberOfTheSeats.trim().equals("") &&
                !timeOfTheMinimumTrip.trim().equals("")) {
            Canoe newCanoe = new Canoe(newIdForNewCanoe, type.toUpperCase(), numberOfTheSeats, timeOfTheMinimumTrip.toUpperCase(), tripPrice);
            return newCanoe;
        }
        return null;
    }

    public void successedMessages() {
        System.out.println(GREEN_BOLD + "You added a new canoe!"+ TEXT_RESET);
    }
    public void failedMessages() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields!"+ TEXT_RESET);
    }

}
