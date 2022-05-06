package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.User;
import com.capgemini.Model.Users;
import com.capgemini.View.UserEditMenuView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserEditController {
    String id, name, role, password, chosenKey;
    UserEditMenuView userEditMenuView = new UserEditMenuView();
    Users users = new Users();
    Model model = new Model();
    int count=-1;

    public void execute() throws FileNotFoundException {
        userEditMenuView.executeView();
        name = userEditMenuView.getEditName();
        id = userEditMenuView.getEditId();

        boolean check = false;
        for (User user : model.getUsers()) {
            count++;
            if (id.equals(user.getUserId()) && name.equals(user.getUserName())) {
                password = user.getPassword();
                role = user.getRoleKey();
                userEditMenuView.selectedUser(id, name, role, password);
                check = true;
                break;
            }
        }
        if (check) {
            switch (chosenKey = userEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "NM":
                    write(id, userEditMenuView.getNewName().trim().toUpperCase(Locale.ROOT), password, role);
                    break;
                case "ID":
                    write(userEditMenuView.getNewId().trim(), name, password, role);
                    break;
                case "RL":
                    write(id, name, password, userEditMenuView.getNewRole().trim().toUpperCase(Locale.ROOT));
                    break;
                default:
                    System.out.println(GREEN_BOLD + "You entered wrong key(s)" + TEXT_RESET);
            }

        }else{
            System.out.println(GREEN_BOLD + "The user is not found please check information and try again." + TEXT_RESET);
        }
    }


    private void write(String id, String name, String password, String role) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        model.getUsers().remove(count);
        writer.print("");
        for (User user : model.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.println(id+","+name+","+password+","+role);
        writer.close();
        userEditMenuView.successfulMessage(chosenKey);
    }
}
