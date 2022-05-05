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
        name= userDeleteMenuView.getName();

        /*
        for (int i = 0; i < users.getUsers().size(); i++) {
            String checkId = users.getUsers().get(i).getUserId();
            String checkName = users.getUsers().get(i).getUserName();
            if (id.equals(checkId) && name.equals(checkName)) {
                password = users.getUsers().get(i).getPassword();
                role = users.getUsers().get(i).getRoleKey();
                users.getUsers().remove(i);
                users.setUsers(users.getUsers());
            }
        }
         */

        boolean check = false;

        for (User user : users.getUsers()) {
            count++;
            if (id.equals(user.getUserId()) && name.equals(user.getUserName())) {
                password = user.getPassword();
                role = user.getRoleKey();
                userDeleteMenuView.selectedUser(id,name,role,password);
                check = true;
                break;
            }
        }

        if(check&& userDeleteMenuView.checkUser()){
            delete(count);
        }else if (check==false){
            System.out.println(GREEN_BOLD + "The user is not found please check information and try again." + TEXT_RESET);
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


/*




         for (User user : users.getUsers()) {
            String checkId = user.getUserId();
            String checkName = user.getUserName();
            if (id.equals(checkId) && name.equals(checkName)) {
                password = user.getPassword();
                role = user.getRoleKey();
                users.getUsers().remove(user);
                users.setUsers(users.getUsers());
            }
        }
 */

