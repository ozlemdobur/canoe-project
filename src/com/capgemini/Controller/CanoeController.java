package com.capgemini.Controller;

import com.capgemini.Model.*;
import com.capgemini.View.CanoeAddView;
import com.capgemini.View.CanoeDeleteView;
import com.capgemini.View.CanoeMenuView;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CanoeController {
    public void execute(Model model) throws IOException, ParseException {
        boolean selectedAnyMenu = true;
        while (selectedAnyMenu) {
            CanoeMenuView canoeMenuView = new CanoeMenuView();
            List<String> canoeMenuList = canoeMenuList(model);
            String selectedCanoeMenuItem = canoeMenuView.show(canoeMenuList);
            switch (selectedCanoeMenuItem) {
                case "CA" -> {
                    CanoeAddView canoeAddView = new CanoeAddView();
                    Canoe newCanoe = canoeAddView.execute((model.getCanoes().size() + 1) + "");
                    if (newCanoe != null) {
                        CanoeAddController canoeAddController = new CanoeAddController(model, newCanoe);
                        canoeAddController.execute();
                        canoeAddView.succeededMessages();
                        execute(model);
                    } else {
                        canoeAddView.failedMessages();
                        selectedCanoeMenuItem = "CA";
                    }
                }
                case "CE" -> {
                    CanoeEditController canoeEditController = new CanoeEditController();
                    canoeEditController.execute();
                }
                case "CD" -> {
                    CanoeDeleteController canoeDeleteController = new CanoeDeleteController();
                    CanoeDeleteView canoeDeleteView = new CanoeDeleteView();
                    canoeDeleteController.execute();
                    canoeDeleteView.successMessage();
                }
                case "E" -> {
                    MainMenuController mainMenuController = new MainMenuController(model);
                    mainMenuController.execute(true);
                }
                default -> throw new IllegalStateException("Unexpected value: " + selectedCanoeMenuItem);
            }
        }
        System.out.println("Reservation Controller");
    }
    
    public List<String> canoeMenuList(Model model) {
        List<String> canoeMenuList = new ArrayList<>();
        List<String> canoeMenuViewKeyList = new ArrayList<>();
        for (Permission permission : model.getPermissions()) {
            if (model.getActiveUser().getRoleKey().equals(permission.getpRoleKey()) &&
                    permission.getpViewKey().length() == 2 && permission.getpViewKey().startsWith("C")) {
                canoeMenuViewKeyList.add(permission.getpViewKey());
            }
        }
        for (View view : model.getViews()) {
            if (canoeMenuViewKeyList.contains(view.getViewKey())) {
                canoeMenuList.add(view.getViewName() + " [" + view.getViewKey() + "]");
            }
        }
        canoeMenuList.add("Exit (E)");
        return canoeMenuList;
    }
}