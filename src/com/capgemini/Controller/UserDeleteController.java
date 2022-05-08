package com.capgemini.Controller;

import com.capgemini.Model.User;
import com.capgemini.Model.Users;
import com.capgemini.View.UserDeleteView;

import java.io.*;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserDeleteController {

    String id, name, password, role;
    UserDeleteView userDeleteMenuView = new UserDeleteView();
    Users users = new Users();
    int count=-1;


    public void execute() throws FileNotFoundException {
        userDeleteMenuView.execute();
        id= userDeleteMenuView.getId();
        boolean check = false;
        for (User user : users.getUsers()) {
            count++;
            if (id.equals(user.getUserId())) {
                name=user.getUserName();
                password = user.getPassword();
                role = user.getRoleKey();
                userDeleteMenuView.selectedUser(id, name, role);
                check = true;
                break;
            }
        }

        if(check&& userDeleteMenuView.checkUser()){
            delete(count);
        }else if (!check){
            userDeleteMenuView.nFound();
        }


    }

    private void delete(int index) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        users.getUsers().remove(index);
        writer.print("");
        for (User user : users.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.close();
        userDeleteMenuView.successMessage();
    }
}

