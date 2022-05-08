package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Permission;
import com.capgemini.Model.User;
import com.capgemini.Model.View;
import com.capgemini.View.UserAddView;
import com.capgemini.View.UserMenuView;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public void execute(Model model) throws IOException, ParseException {
        boolean selectedAnyMenu = true;
        while (selectedAnyMenu) {
            UserMenuView userMenuView = new UserMenuView();
            List userMenuList = userMenuList(model);
            String selectedUserMenuItem = userMenuView.show(userMenuList);
            switch (selectedUserMenuItem) {
                case "UA":
                    UserAddView userAddView = new UserAddView();
                    User newUser = userAddView.execute((model.getUsers().size() + 1) + "");
                    if (newUser != null) {
                        UserAddController userAddController = new UserAddController(model, newUser);
                        boolean isItSaved = userAddController.execute();
                        userAddView.successedMessages();
                        execute(model);
                    } else {
                        userAddView.failedMessages();
                        selectedUserMenuItem = "UA";
                        break;
                    }
                    UserAddController userAddController = new UserAddController(model, newUser);
                    userAddController.execute();
                    break;
                case "UE":
                    UserEditController userEditController = new UserEditController();
                    userEditController.execute();
                    break;
                case "UD":
                    UserDeleteController userDeleteController = new UserDeleteController();
                    userDeleteController.execute();
                    break;
                case "UP":
                    UserPasswordChangeController userPasswordChangeController = new UserPasswordChangeController();
                    userPasswordChangeController.execute();
                    break;
                case "E":
                    MainMenuController mainMenuController = new MainMenuController(model);
                    mainMenuController.execute(true);
            }
        }
        System.out.println("Reservation Controller");
    }

    public List<String> userMenuList(Model model) {
        List<String> userMenuList = new ArrayList<String>();
        List<String> userMenuViewKeyList = new ArrayList<String>();
        for (Permission permission : model.getPermissions()) {
            if (model.getActiveUser().getRoleKey().equals(permission.getpRoleKey()) &&
                    permission.getpViewKey().length() == 2 && permission.getpViewKey().startsWith("U")) {
                userMenuViewKeyList.add(permission.getpViewKey());
            }
        }
        for (View view : model.getViews()) {
            if (userMenuViewKeyList.contains(view.getViewKey())) {
                userMenuList.add(view.getViewName() + " [" + view.getViewKey() + "]");
            }
        }
        userMenuList.add("Exit (E)");
        return userMenuList;
    }
}

