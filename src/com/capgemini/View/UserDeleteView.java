package com.capgemini.View;

import com.capgemini.Model.Users;

import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserDeleteView {

    public String execute (){
        String id, name;
        Scanner sc = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER DELETE MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete an User"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : ");
        id=sc.nextLine();
        System.out.print(GREEN_BOLD + "Name : ");
        name=sc.nextLine();
        String idAndName=id.trim()+","+name.trim().toUpperCase();
        return idAndName;
    }

    public void successMessage() {
        System.out.println(GREEN_BOLD + "You added the user!"+ TEXT_RESET);
    }

    public void failMessage() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields with correct information!"+ TEXT_RESET);
    }
}
