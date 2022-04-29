package com.capgemini.View;

import com.capgemini.Model.User;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserAddView {

    public User execute(String newIdForNewUser) {
        String name, password, role;
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER ADD MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information for new User"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : "+ TEXT_RESET + newIdForNewUser);
        System.out.print(GREEN_BOLD + "Name : "+ TEXT_RESET);
        name = scanner.nextLine();
        System.out.print(GREEN_BOLD + "Password : "+ TEXT_RESET);
        password = scanner.nextLine();
        System.out.println(GREEN_BOLD + "Receptionist[RE] - Administrator[ AD ] - General Manager [GM] "+ TEXT_RESET);
        System.out.print(GREEN_BOLD + "Role : "+ TEXT_RESET);
        role = scanner.nextLine();
        if (!newIdForNewUser.trim().equals("") && !name.trim().equals("") && !password.trim().equals("") && !role.trim().equals("")) {
            User newUser = new User(newIdForNewUser, name.toUpperCase(), password, role.toUpperCase());
            return newUser;
        }
        return null;
    }

    public void successedMessages() {
        System.out.println(GREEN_BOLD + "You added a new user!"+ TEXT_RESET);
    }

    public void failedMessages() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields!"+ TEXT_RESET);
    }
}
