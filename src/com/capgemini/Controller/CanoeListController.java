package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Canoe;

import java.io.IOException;

public class CanoeListController {
    private Model model;

    public CanoeListController(Model model) {
        this.model = model;
    }

    public void execute() throws IOException {
        model.getCanoes().toString();

        System.out.print(String.format("%-12s","ID"));
        System.out.print(String.format("%-15s","TYPE"));
        System.out.print(String.format("%-15s","NUMBER OF THE SEATS"));
        System.out.print(String.format("%-10s","DURATION OF THE MINIMUM TOUR"));
        System.out.print(String.format("%-12s","TOUR PRICE"));

        for(Canoe){
            System.out.print(String.format("%-10s",reservation.getReservationId()));
            System.out.print(String.format("%-10s",reservation.getRoomNumber()));
            System.out.print(String.format("%-12s",reservation.getCanoeId()));
            System.out.print(String.format("%-15s",reservation.getCanoeType()));
            System.out.print(String.format("%-15s",reservation.getDate()));
            System.out.print(String.format("%-10s",reservation.getDuration()));
            System.out.print(String.format("%-12s",reservation.getStartTime()));
            System.out.print(String.format("%-12s",reservation.getEndTime()));
            System.out.println(String.format("%-12s",reservation.getCost()));
        }
    }
}

