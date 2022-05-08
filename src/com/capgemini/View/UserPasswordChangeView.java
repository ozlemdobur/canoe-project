package com.capgemini.View;

import com.capgemini.Model.User;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class UserPasswordChangeView {
    Scanner sc = new Scanner(System.in);
    String inputName, inputId;


    public void executeView() {
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER PASSWORD CHANGE MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the name and id of the user who you want to change password" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "ID : ");
        inputId = sc.nextLine();
    }

    public String getNewPassword() {
        System.out.println(GREEN_BOLD + "Please enter New Password" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Password :" + TEXT_RESET);
        return sc.nextLine();
    }

    public void selectedUser(String id, String name, String role, String password) {
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Name :" + TEXT_RESET + name);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Role :" + TEXT_RESET + role);
        System.out.println(GREEN_BOLD + "Password :" + TEXT_RESET + password);
    }


    public String getInputName() {
        return inputName;
    }

    public String getInputId() {
        return inputId;
    }

    public void successfulMessage() {
        System.out.println(TEXT_RED + "Congratulations password changed successfully!!!!" + TEXT_RESET);
        System.out.println(TEXT_RED + "You changed the password successfully!!!!" + TEXT_RESET);
    }

    public String aSave() {
        System.out.println(GREEN_BOLD + "Do you want to save ? Yes[Y]/No[N]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void showChangedUser(User changedUser) {
        System.out.println(GREEN_BOLD + "Name :" + TEXT_RESET + changedUser.getUserName());
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET + changedUser.getUserId());
        System.out.println(GREEN_BOLD + "Role :" + TEXT_RESET + changedUser.getRoleKey());
        System.out.println(GREEN_BOLD + "Password :" + TEXT_RESET + changedUser.getPassword());
    }
}