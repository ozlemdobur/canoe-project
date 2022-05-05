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
    String data, id, name, role, password, newId, newName, newRole, chosenKey;
    UserEditMenuView userEditMenuView = new UserEditMenuView();
    Users users = new Users();
    int count;
    User user = new User();
    Model model = new Model();

    public void execute() throws FileNotFoundException {
        data = userEditMenuView.executeView();
        name = data.substring(0, data.indexOf(','));
        id = data.substring(data.indexOf(',') + 1);


        for (int i = 0; i < users.getUsers().size(); i++) {
            if (id.equals(users.getUsers().get(i).getUserId()) && name.equals(users.getUsers().get(i).getUserName())) {
                role = users.getUsers().get(i).getRoleKey();
                password = users.getUsers().get(i).getPassword();
                users.getUsers().remove(i);
                break;
            }
        }

        System.out.println(role);

        userEditMenuView.selectedUser(name,id,role);

        switch (userEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
            case "NM":
                write(id,userEditMenuView.getNewName().trim().toUpperCase(Locale.ROOT),password,role);
                break;
            case "ID":
                write(userEditMenuView.getNewId().trim(),name,password,role);
                break;
            case "RL":
                write(id,name,password,userEditMenuView.getNewRole().trim().toUpperCase(Locale.ROOT));
                break;
            default:
                System.out.println(GREEN_BOLD + "You entered wrong key(s)" + TEXT_RESET);
        }



    }

    private void checkKeyWord () throws FileNotFoundException {

    }

    private void write(String id, String name, String password, String role) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        writer.print("");
        for (User user : users.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.println(id+","+name+","+password+","+role);
        writer.close();
        userEditMenuView.successfulMessage();
    }
}
