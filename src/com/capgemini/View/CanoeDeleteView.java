package com.capgemini.View;

import com.capgemini.Model.Canoes;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class CanoeDeleteView {

    public String execute (){
        String id, type;
        Scanner sc = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "**********  CANOE DELETE MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "************************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Please enter the information to delete an Canoe"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "Id : ");
        id=sc.nextLine();
        System.out.print(GREEN_BOLD + "Type : ");
        type=sc.nextLine();
        String idAndType=id.trim()+","+type.trim().toUpperCase();
        return idAndType;
    }

    public void successMessage() {
        System.out.println(GREEN_BOLD + "You deleted the canoe!"+ TEXT_RESET);
    }
    public void failMessage() {
        System.out.println(GREEN_BOLD + "Please fill in the all fields with correct information!"+ TEXT_RESET);
    }
}
