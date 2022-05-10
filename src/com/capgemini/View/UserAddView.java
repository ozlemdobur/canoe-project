package com.capgemini.View;

import com.capgemini.Model.User;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class UserAddView {

    public User execute(String newIdForNewUser) {
        String name, password, role,userName;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER ADD MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new User" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Username : " + TEXT_RESET);
        userName=scanner.nextLine();
        System.out.print(GREEN_BOLD + "Full Name : " + TEXT_RESET);
        name = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Password : " + TEXT_RESET);
        password = scanner.nextLine();
        System.out.println(GREEN_BOLD + "Receptionist[RE] - Administrator[ AD ] - General Manager [GM] " + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Role : " + TEXT_RESET);
        role = scanner.nextLine();
        if (!userName.trim().equals("") && !name.trim().equals("") && !password.trim().equals("") && !role.trim().equals("")) {
            User newUser = new User(userName.trim().toUpperCase(Locale.ROOT), name.toUpperCase(), password, role.toUpperCase());
            return newUser;
        }
        return null;
    }

    public void successedMessages() {
        System.out.println(TEXT_RED + "You added a new user!" + TEXT_RESET);
    }

    public void failedMessages() {
        System.out.println(TEXT_RED + "Please fill in the all fields!" + TEXT_RESET);
    }
}
