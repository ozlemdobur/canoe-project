package com.capgemini.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class MainMenuView {
    String selectedMainMenuItem;
    public String showMainMenu(List<String> mainMenuList){
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD +"******************************"+ TEXT_RESET);
        System.out.println(GREEN_BOLD +"********  MAIN MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD +"******************************"+ TEXT_RESET);

        for (int i = 0; i < mainMenuList.size() ; i++) {
            System.out.println(mainMenuList.get(i));
        }
        System.out.println(GREEN_BOLD +"Please select the menu..."+ TEXT_RESET);
        selectedMainMenuItem = scanner.nextLine().toUpperCase();
        return selectedMainMenuItem;
    }
}

