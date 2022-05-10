package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Canoe;

import java.io.IOException;
import java.util.Scanner;

public class CanoeListController {
    private Model model;
    Scanner scanner = new Scanner(System.in);

    public CanoeListController(Model model) {
        this.model = model;
    }

    public void execute() throws IOException {
        model.getCanoes().toString();

        System.out.printf("%-10s","ID");
        System.out.printf("%-15s","TYPE");
        System.out.printf("%-15s","SEATS");
        System.out.printf("%-18s","DURATION");
        System.out.printf("%-18s","PRICE");

        for(Canoe canoe : model.getCanoes()){
            System.out.printf("\n%-10s",canoe.getCanoeId());

            switch (canoe.getCanoeType().trim()) {
                case "S" -> System.out.printf("%-15s", "Supboard");
                case "K" -> System.out.printf("%-15s", "Kajak");
                case "R" -> System.out.printf("%-15s", "Rowing");
                case "E" -> System.out.printf("%-15s", "Electrical");
            }

            System.out.printf("%-15s",canoe.getNumberOfTheSeats());
            System.out.printf("%-18s",canoe.getTimeOfTheMinimumTrip());
            System.out.printf("%-18s",canoe.getTripPrice());
        }
        System.out.println("");
        System.out.println("Click enter to continue");
        scanner.nextLine();
    }
}

