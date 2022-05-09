package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;

import java.util.Scanner;

public class UserListController {
    Model model = new Model();
    public void execute() {
        model.getUsers().toString();
        System.out.print(String.format("%-10s","ID"));
        System.out.print(String.format("%-20s","USER NAME"));
        System.out.println(String.format("%-12s","PASSWORD"));
        for(User user :model.getUsers()){
            System.out.print(String.format("%-10s",user.getUserId()));
            System.out.print(String.format("%-20s",user.getUserName()));
            System.out.println(String.format("%-12s","*******"));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Click enter to continue");
        sc.nextLine();
    }
}
