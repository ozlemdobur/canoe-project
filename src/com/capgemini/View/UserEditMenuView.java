package com.capgemini.View;

import com.capgemini.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.*;

public class UserEditMenuView {
    Scanner sc = new Scanner(System.in);
    List<String> data = new ArrayList<>();
    String editName, editId;

    public void executeView() {
        System.out.println(GREEN_BOLD + "*************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER EDIT MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "*************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Username : ");
        editId = sc.nextLine();
    }

    public String getNewRole() {
        System.out.println(GREEN_BOLD + "Please enter New Role - Admin[AD], General Manager[GM], Receptionist[RE]" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Role: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewId() {
        System.out.println(GREEN_BOLD + "Please enter New Username" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "New Username: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String getNewName() {
        System.out.println(GREEN_BOLD + "Please enter New Name" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Name: " + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change - Full Name[NM]/Role[RL]/Username[UN]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void successfulMessage(String chosenKey) {
        System.out.println(TEXT_RED + "Congratulations " + chosenKey + " is changed successfully!!!!" + TEXT_RESET);
    }

    public void selectedUser(String id, String name, String role) {
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Full Name  :" + TEXT_RESET + name);
        System.out.println(GREEN_BOLD + "Username   :" + TEXT_RESET + id);
        System.out.println(GREEN_BOLD + "Role       :" + TEXT_RESET + role);
    }

    public String askSave() {
        System.out.println(GREEN_BOLD + "Do you want to save ? Yes[Y]/No[N]" + TEXT_RESET);
        return sc.nextLine().trim().toUpperCase(Locale.ROOT);
    }

    public void editedUserView(User user) {
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Full Name :" + TEXT_RESET + user.getUserName());
        System.out.println(GREEN_BOLD + "Username  :" + TEXT_RESET + user.getUserId());
        System.out.println(GREEN_BOLD + "Role      :" + TEXT_RESET + user.getRoleKey());
    }

    public void warnMessage() {
        System.out.println(GREEN_BOLD + "You entered wrong key(s)" + TEXT_RESET);
    }

    public String getEditName() {
        return editName.trim().toUpperCase(Locale.ROOT);
    }

    public String getEditId() {
        return editId.trim().toUpperCase(Locale.ROOT);
    }
}





    /*
    switch (chosenKey) {
            case "NM":
                return getNewName();
            //data.add(getNewName());
            //return data;

            case "ID":
                return editName+"."+editId+"."+getNewId();
            //data.add(getNewId());
            //return data;

            case "RL":
                return editName+"."+editId+"."+getNewRole();
            //data.add(getNewRole());
            //return data;
            default:
                System.out.println(GREEN_BOLD + "You entered wrong key(s)" + TEXT_RESET);
                return editName+"."+editId;
            //return data;
     */