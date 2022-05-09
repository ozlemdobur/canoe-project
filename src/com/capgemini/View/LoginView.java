package com.capgemini.View;

import java.util.ArrayList;
import java.util.Scanner;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class LoginView {

    public ArrayList<String> login() {
        ArrayList<String> loginNamePassword = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN_BOLD + "********************************************************************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "***************  MOLVENO RESORT CANOE RENTAL SYSTEM  ***************" + TEXT_RESET);
        System.out.println(GREEN_BOLD + "********************************************************************" + TEXT_RESET);
        System.out.print(GREEN_BOLD + "Please enter your user name: " + TEXT_RESET);
        loginNamePassword.add(scanner.nextLine());
        System.out.print(GREEN_BOLD + "Please enter your password: " + TEXT_RESET);
        loginNamePassword.add(scanner.nextLine());
        return loginNamePassword;
    }

}
