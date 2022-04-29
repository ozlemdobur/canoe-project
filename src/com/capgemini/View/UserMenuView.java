package com.capgemini.View;

import java.util.List;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserMenuView {
    String selectedDetailMenu;
    public String show(List activeDetailMenu){
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "******************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********  USER MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "******************************"+ TEXT_RESET);
        for (int i = 0; i < activeDetailMenu.size() ; i++) {
            System.out.println( activeDetailMenu.get(i));
        }
        System.out.print(GREEN_BOLD + "Please select the menu :"+ TEXT_RESET );
        selectedDetailMenu = scanner.nextLine().toUpperCase();
        return selectedDetailMenu;
    }
}
