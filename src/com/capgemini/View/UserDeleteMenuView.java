package com.capgemini.View;

import com.capgemini.Model.User;
import com.capgemini.Model.Users;

import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserDeleteMenuView {

    public String execute (){
        String id, name;
        Scanner sc = new Scanner(System.in);
        Users selectedUser = new Users();
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER ADD MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete an User"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : ");
        id=sc.nextLine();
        System.out.print(GREEN_BOLD + "Name : ");
        name=sc.nextLine();
        String idAndName=id.trim()+","+name.trim().toUpperCase();
        /*if(!id.trim().equals("")&&!name.trim().equals("")){
            User newUser = new User(id, name.toUpperCase(),"","");
            return newUser;
        }
        return null;
         */
        return idAndName;
    }

    public void successMessage() {
        System.out.println(GREEN_BOLD + "You added the user!"+ TEXT_RESET);
    }

    public void failMessage() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields with correct information!"+ TEXT_RESET);
    }
}
