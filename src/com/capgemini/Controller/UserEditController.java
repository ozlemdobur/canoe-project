package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.User;
import com.capgemini.View.UserEditMenuView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserEditController {
    String id, name, role, password, chosenKey;
    UserEditMenuView userEditMenuView = new UserEditMenuView();
    Model model = new Model();
    User editedUser;
    int count=-1;

    public void execute() throws FileNotFoundException {
        userEditMenuView.executeView();
        id = userEditMenuView.getEditId();

        boolean check = false;
        for (User user : model.getUsers()) {
            count++;
            if (id.equals(user.getUserId())) {
                name=user.getUserName();
                password = user.getPassword();
                role = user.getRoleKey();
                userEditMenuView.selectedUser(id, name, role);
                check = true;
                break;
            }
        }
        if (check) {
            switch (chosenKey = userEditMenuView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "NM":
                    editedUser = new User(id, userEditMenuView.getNewName(), password, role);
                    userEditMenuView.editedUserView(editedUser);
                    if(userEditMenuView.askSave().equals("Y")){write(editedUser);}
                    break;
                case "RL":
                    String newRole = userEditMenuView.getNewRole();
                    editedUser = new User(id, name, password, newRole);
                    if(newRole.equals("AD")||newRole.equals("GM")||newRole.equals("RE")){
                        userEditMenuView.editedUserView(editedUser);
                    }else{userEditMenuView.warnMessage();break;}
                    if(userEditMenuView.askSave().equals("Y")){write(editedUser);}
                    break;
                default:
                    userEditMenuView.warnMessage();
            }

        }else{
            System.out.println(GREEN_BOLD + "The user is not found please check information and try again." + TEXT_RESET);
        }
    }


    private void write(User editedUser) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        model.getUsers().set(count,editedUser);
        writer.print("");
        for (User user : model.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.close();
        userEditMenuView.successfulMessage(chosenKey);
    }
}
