package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.User;
import com.capgemini.Model.Users;
import com.capgemini.View.LoginView;

import java.util.ArrayList;

public class LoginController {
    private Model model;

    public LoginController(Model model) {
        this.model = model;
    }

    public boolean execute() {
        LoginController loginController = new LoginController(model);
        LoginView loginView = new LoginView();
        ArrayList<String> loginNamePassword = loginView.login();
        boolean loginStatus = loginController.isItLogin(loginNamePassword, model);
        return loginStatus;
    }

    public boolean isItLogin(ArrayList<String> loginInformation, Model model) {

        for (User users : model.getUsers()) {
            if (users.getUserName().equals(loginInformation.get(0).toUpperCase())
                    && users.getPassword().equals(loginInformation.get(1))) {
                model.setActiveUser(new User(users.getUserId(), users.getUserName(), users.getPassword(), users.getRoleKey()));
                return true;
            }
        }
        return false;
    }
}