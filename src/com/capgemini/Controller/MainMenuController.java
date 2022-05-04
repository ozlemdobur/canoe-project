package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Permission;
import com.capgemini.Model.View;
import com.capgemini.View.LoginView;
import com.capgemini.View.MainMenuView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenuController {
    public Model model;
    public MainMenuController(Model model){
        this.model = model;
    }
    public void execute(boolean loginStatus) throws IOException {

        while (loginStatus) {
            MainMenuView mainMenuView = new MainMenuView();
            String selectedMainMenuItem = mainMenuView.showMainMenu(mainMenuList(model));
            switch (selectedMainMenuItem) {
                case "R":
                    ReservationController reservationController = new ReservationController();
                    reservationController.execute();
                    break;
                case "C":
                    CanoeController canoeController = new CanoeController();
                    canoeController.execute();
                    break;
                case "U":
                    UserController userController = new UserController();
                    userController.execute(model);
                    break;
                case "E":
                    System.exit(-1);
            }
        }
    }


    public List<String> mainMenuList(Model model) {
        List<String> mainMenuList = new ArrayList<String>();
        // Model model = new Model();
        for (Permission permission : model.getPermissions()) {
            if (model.getActiveUser().getRoleKey().equals(permission.getpRoleKey()) &&
                    permission.getpViewKey().length() == 1) {
                for (View view : model.getViews()) {
                    if (permission.getpViewKey().equals(view.getViewKey())) {
                        mainMenuList.add(view.getViewName() + " [" + view.getViewKey() + "]");
                    }
                }
            }
        }
        mainMenuList.add("Exit (E)");
        return mainMenuList;
    }

}
//model.

//       activeUser = loginController.checkUserPassword(loginNamePassword, model);
// while (activeUser. != null) {
//  System.out.println(activeUser.getUserName());

// }

   /* public void execute() {
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        User activeUser = loginController.execute(loginView.login(), model);
        while (activeUser != null) {
            System.out.println(activeUser.getUserName());

        }*/




