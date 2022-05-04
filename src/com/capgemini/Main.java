package com.capgemini;

import com.capgemini.Controller.LoginController;
import com.capgemini.Controller.MainMenuController;
import com.capgemini.Model.Model;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String TEXT_RESET = "\u001B[0m";
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        LoginController loginController = new LoginController(model);
        boolean loginStatus = loginController.execute();
        MainMenuController mainMenuController = new MainMenuController(model);
        mainMenuController.execute(loginStatus);

	// write your code here
    }
}
