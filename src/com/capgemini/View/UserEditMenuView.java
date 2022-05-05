package com.capgemini.View;

import com.capgemini.Controller.CanoeController;
import com.capgemini.Controller.ReservationController;
import com.capgemini.Controller.UserController;
import com.capgemini.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserEditMenuView {
    Scanner sc = new Scanner(System.in);
    List<String> data = new ArrayList<>();
    String editName, editId, chosenKey;

    public String executeView() {

        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  USER EDIT MENU  *********" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the name and id of the user who you want to edit" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Name : ");
        editName = sc.nextLine();
        //data.add(sc.nextLine());
        System.out.print(GREEN_BOLD + "ID : ");
        editId = sc.nextLine();
        //data.add(sc.nextLine());
        return editName.trim().toUpperCase(Locale.ROOT) + "," + editId.trim().toUpperCase(Locale.ROOT);
    }

    public String getNewRole() {
        System.out.println(GREEN_BOLD + "Please enter New Role" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Role :" + TEXT_RESET);
        return sc.nextLine();
    }

    public String getNewId() {
        System.out.println(GREEN_BOLD + "Please enter New ID" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New ID :" + TEXT_RESET);
        return sc.nextLine();
    }

    public String getNewName() {
        System.out.println(GREEN_BOLD + "Please enter New Name" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "New Name :" + TEXT_RESET);
        return sc.nextLine();
    }

    public String askForChange() {
        System.out.println(GREEN_BOLD + "Please chose which info you want to change Name(NM)-ID(ID)-Role(RL)" + TEXT_RESET);
        return sc.nextLine();
    }

    public void successfulMessage(){
        System.out.println(GREEN_BOLD + "Congratulations transaction completed successfully!!!!" + TEXT_RESET);

    }

    public void selectedUser(String id, String name, String role){
        System.out.println(GREEN_BOLD + "Here is the chosen User" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "Name :" + TEXT_RESET+name);
        System.out.println(GREEN_BOLD + "ID :" + TEXT_RESET+id);
        System.out.println(GREEN_BOLD + "Role :" + TEXT_RESET+role);
    }

    public String askIfitisCorrect(){
        System.out.println(GREEN_BOLD + "Is it correct user ?(Y/N)" + TEXT_RESET);
        return sc.nextLine();
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