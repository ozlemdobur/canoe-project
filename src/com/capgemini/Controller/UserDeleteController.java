package com.capgemini.Controller;

import com.capgemini.Model.User;
import com.capgemini.Model.Users;
import com.capgemini.View.UserDeleteView;

import java.io.*;

public class UserDeleteController {

    String deleteIdAndName, id, name, password, role;
    UserDeleteView userDeleteMenuView = new UserDeleteView();
    Users users = new Users();


    public void execute() throws FileNotFoundException {

        deleteIdAndName = userDeleteMenuView.execute();
        id = deleteIdAndName.substring(0, deleteIdAndName.indexOf(','));
        name = deleteIdAndName.substring(deleteIdAndName.indexOf(',') + 1);
        System.out.println(id);
        System.out.println(name);


        for (int i = 0; i < users.getUsers().size(); i++) {
            String checkId = users.getUsers().get(i).getUserId();
            String checkName = users.getUsers().get(i).getUserName();
            if (id.equals(checkId) && name.equals(checkName)) {
                password = users.getUsers().get(i).getPassword();
                role = users.getUsers().get(i).getUserId();
                users.getUsers().remove(i);
                users.setUsers(users.getUsers());
            }
        }

        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        writer.print("");
        for (User user : users.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.close();
    }
}

