package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UserAddController {
    private Model model;
    private User newUser;

    public UserAddController(Model model, User newUser) {
        this.model = model;
        this.newUser = newUser;
    }

    public boolean execute() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("src/com/capgemini/Model/UserDB"));
        model.getUsers().add(newUser);
        for (User users : model.getUsers()) {
            writer.println(users.getUserId() + "," +
                    users.getUserName() + "," +
                    users.getPassword() + "," +
                    users.getRoleKey());
        }
        writer.close();
        return true;
    }
}
