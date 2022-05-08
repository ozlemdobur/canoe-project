package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Permission;
import com.capgemini.Model.View;
import com.capgemini.View.MainMenuView;
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
                    reservationController.execute(model);
                    break;
                case "C":
                    CanoeController canoeController = new CanoeController();
                    canoeController.execute(model);
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