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
    int count=-1;
    public void execute() throws FileNotFoundException {
        userPasswordChangeView.executeView();
        id= userPasswordChangeView.getInputId().trim().toUpperCase(Locale.ROOT);
        name=userPasswordChangeView.getInputName().trim().toUpperCase(Locale.ROOT);
        boolean check=false;
        for(User user : model.getUsers()){
            count++;
            if(id.equals(user.getUserId())&&name.equals(user.getUserName())){
                password=user.getPassword();
                role=user.getRoleKey();
                check=true;
                break;
            }
        }
        if(check) {
            userPasswordChangeView.selectedUser(id, name, role, password);
            newPassword = userPasswordChangeView.getNewPassword();
            write(id, name, newPassword, role);
        }else{
            System.out.println(GREEN_BOLD + "The user is not found please enter correct information" + TEXT_RESET);
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
        userPasswordChangeView.successfulMessage();
    }
}
