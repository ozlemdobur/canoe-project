package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;
import com.capgemini.Model.User;

import java.util.Scanner;

public class UserListController {
    Model model = new Model();
    public void execute() {
        model.getUsers().toString();
        System.out.print(String.format("%-25s","USER NAME"));
        System.out.print(String.format("%-30s","FULL NAME"));
        System.out.println(String.format("%-15s","PASSWORD"));
        for(User user :model.getUsers()){
            System.out.print(String.format("%-25s",user.getUserId()));
            System.out.print(String.format("%-30s",user.getUserName()));
            System.out.println(String.format("%-15s","*******"));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Click enter to continue");
        sc.nextLine();
    }
}
