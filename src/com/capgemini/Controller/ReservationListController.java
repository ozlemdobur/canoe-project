package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationListController {
    private Model model;

    public ReservationListController(Model model) {
        this.model = model;
    }

    public void execute() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print(GREEN_BOLD + "DATE : " + TEXT_RESET);
        String date = sc.nextLine();
        model.getReservations().toString();
        System.out.print(String.format("%-10s", "ID"));
        System.out.print(String.format("%-10s", "ROOM"));
        System.out.print(String.format("%-12s", "CANOE ID"));
        System.out.print(String.format("%-15s", "CANOE TYPE"));
        System.out.print(String.format("%-15s", "DATE"));
        System.out.print(String.format("%-10s", "DURATION"));
        System.out.print(String.format("%-12s", "START"));
        System.out.print(String.format("%-12s", "END"));
        System.out.println(String.format("%-12s", "COST"));
        for (Reservation reservation : model.getReservations()) {
            if (reservation.getDate().equals(date)) {
                System.out.print(String.format("%-10s", reservation.getReservationId()));
                System.out.print(String.format("%-10s", reservation.getRoomNumber()));
                System.out.print(String.format("%-12s", reservation.getCanoeId()));
                if (reservation.getCanoeType().trim().equals("S")) {
                    System.out.print(String.format("%-15s", "Supboard"));
                } else if (reservation.getCanoeType().trim().equals("K")) {
                    System.out.print(String.format("%-15s", "Kajak"));
                } else if (reservation.getCanoeType().trim().equals("R")) {
                    System.out.print(String.format("%-15s", "Rowing"));
                } else if (reservation.getCanoeType().trim().equals("E")) {
                    System.out.print(String.format("%-15s", "Electrical"));
                }
                System.out.print(String.format("%-15s", reservation.getDate()));
                System.out.print(String.format("%-10s", reservation.getDuration()));
                System.out.print(String.format("%-12s", reservation.getStartTime()));
                System.out.print(String.format("%-12s", reservation.getEndTime()));
                System.out.println(String.format("%-12s", reservation.getCost()));
            }
        }
            System.out.println("");
        System.out.println("Click enter to continue!");
        sc.nextLine();
    }

}
