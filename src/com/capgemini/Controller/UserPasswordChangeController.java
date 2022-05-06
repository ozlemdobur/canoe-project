package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.User;
import com.capgemini.View.UserPasswordChangeView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class UserPasswordChangeController {
    UserPasswordChangeView userPasswordChangeView = new UserPasswordChangeView();
    String id,name,password,role,newPassword;
    Model model = new Model();
    User changedUser;
    int count=-1;
    public void execute() throws FileNotFoundException {
        userPasswordChangeView.executeView();
        id= userPasswordChangeView.getInputId().trim().toUpperCase(Locale.ROOT);
        boolean check=false;
        for(User user : model.getUsers()){
            count++;
            if(id.equals(user.getUserId())){
                name=user.getUserName();
                password=user.getPassword();
                role=user.getRoleKey();
                check=true;
                break;
            }
        }
        if(check) {
            userPasswordChangeView.selectedUser(id, name, role, password);
            newPassword = userPasswordChangeView.getNewPassword();
            changedUser =  new User(id,name,newPassword,role);
            userPasswordChangeView.showChangedUser(changedUser);
            if(userPasswordChangeView.aSave().equals("Y")){write(changedUser);}
        }else{
            System.out.println(GREEN_BOLD + "The user is not found please enter correct information" + TEXT_RESET);
        }


    }



    private void write(User changedUser) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/UserDB");
        model.getUsers().set(count,changedUser);
        writer.print("");
        for (User user : model.getUsers()) {
            writer.println(user.getUserId() + "," +
                    user.getUserName() + "," +
                    user.getPassword() + "," +
                    user.getRoleKey());
        }
        writer.close();
        userPasswordChangeView.successfulMessage();
    }
}
