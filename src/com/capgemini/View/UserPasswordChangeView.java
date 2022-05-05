package com.capgemini.View;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserPasswordChangeView {
    Scanner sc = new Scanner(System.in);
    String inputName, inputId;


    public void executeView (){

        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER PASSWORD CHANGE MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the name and id of the user who you want to change password" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Name : ");
        inputName = sc.nextLine();
        //data.add(sc.nextLine());
        System.out.print(GREEN_BOLD + "ID : ");
        inputId = sc.nextLine();
        //data.add(sc.nextLine());
    }

    public String getNewPassword() {
        System.out.println(GREEN_BOLD + "Please enter New Password" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Password :" + TEXT_RESET);
        return sc.nextLine();
    }

    public void selectedUser(String id, String name, String role, String password){
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Name :" + TEXT_RESET+name);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET+id);
        System.out.println(GREEN_BOLD + "Role :" + TEXT_RESET+role);
        System.out.println(GREEN_BOLD + "Password :" + TEXT_RESET+password);
    }


    public String getInputName() {
        return inputName;
    }

    public String getInputId() {
        return inputId;
    }

    public void successfulMessage() {
        System.out.println(GREEN_BOLD + "Congratulations password changed successfully!!!!" + TEXT_RESET);

    }
}
