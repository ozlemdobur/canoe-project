package com.capgemini.View;

import java.util.List;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class CanoeMenuView {
    public String show(List activeDetailMenu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "******************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********  CANOE MENU  *********"+ TEXT_RESET);
        System.out.println(GREEN_BOLD + "******************************"+ TEXT_RESET);
        for (Object detailMenu : activeDetailMenu) System.out.println(detailMenu);
        System.out.print(GREEN_BOLD + "Please select the menu :"+ TEXT_RESET );
        return scanner.nextLine().toUpperCase();
    }
}
