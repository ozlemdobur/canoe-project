package com.capgemini.View;

import com.capgemini.Model.Users;

import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserDeleteView {
    Scanner sc = new Scanner(System.in);
    String id, name;
    public void execute (){


        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER DELETE MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete an User"+ TEXT_RESET);
        System.out.print(GREEN_BOLD + "Name : ");
        name=sc.nextLine();
        System.out.println(GREEN_BOLD + "Id : ");
        id=sc.nextLine();

    }

    public String getId() {
        return id.trim().toUpperCase(Locale.ROOT);
    }

    public String getName() {
        return name.trim().toUpperCase(Locale.ROOT);
    }

    public void successMessage() {
        System.out.println(GREEN_BOLD + "You deleted the user Successfully!!!!"+ TEXT_RESET);
    }

    public void selectedUser(String id, String name, String role, String password){
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Name :" + TEXT_RESET+name);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET+id);
        System.out.println(GREEN_BOLD + "Role :" + TEXT_RESET+role);
        System.out.println(GREEN_BOLD + "Password :" + TEXT_RESET+password);

    }

    public boolean checkUser(){
        System.out.println(GREEN_BOLD + "Are you sure to delete the user? Yes(Y)/No(N)"+ TEXT_RESET);
        String yesorno = sc.nextLine().trim().toUpperCase(Locale.ROOT);
        if(yesorno.equals("Y")){
            return true;
        }
        return false;
    }

}
