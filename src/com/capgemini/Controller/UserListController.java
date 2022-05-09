package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;

import java.util.Scanner;

public class UserListController {
    Model model = new Model();

    public void execute() {
        model.getUsers().toString();
        System.out.print(String.format("%-25s", "USER NAME"));
        System.out.print(String.format("%-30s", "FULL NAME"));
        System.out.print(String.format("%-15s", "PASSWORD"));
        System.out.println(String.format("%-30s", "ROLE"));
        for (User user : model.getUsers()) {
            System.out.print(String.format("%-25s", user.getUserId()));
            System.out.print(String.format("%-30s", user.getUserName()));
            System.out.print(String.format("%-15s", "*******"));
            if (user.getRoleKey().equals("AD")) {
                System.out.println(String.format("%-30s", "ADMIN"));
            } else if (user.getRoleKey().equals("GM")) {
                System.out.println(String.format("%-30s", "MANAGER"));
            } else if (user.getRoleKey().equals("RE")) {
                System.out.println(String.format("%-30s", "RECEPTIONIST"));
            }

        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Click enter to continue");
        sc.nextLine();
    }
}
