package com.capgemini.Controller;

import com.capgemini.Model.*;
import com.capgemini.View.ReservationAddView;
import com.capgemini.View.ReservationMenuView;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    public void execute(Model model) throws IOException, ParseException {
        boolean selectedAnyMenu = true;
        while (selectedAnyMenu) {
            ReservationMenuView reservationMenuView = new ReservationMenuView();
            List reservationMenuList = reservationMenuList(model);
            String selectedReservationMenuItem = reservationMenuView.show(reservationMenuList);
            switch (selectedReservationMenuItem) {
                case "RA":
                   //ReservationAddController reservationAddController = new ReservationAddController(model);
                    //reservationAddController.execute();

                    new ReservationAddController(model).execute();
                    break;
                case "RE":
                    ReservationEditController reservationEditController = new ReservationEditController();
                    reservationEditController.execute();
                    break;
                case "RD":
                    ReservationDeleteController reservationDeleteController = new ReservationDeleteController();
                    reservationDeleteController.execute();
                    break;
                case "RL":
                    ReservationListController reservationListController = new ReservationListController(model);
                    reservationListController.execute();
                    break;
                case "E":
                    MainMenuController mainMenuController = new MainMenuController(model);
                    mainMenuController.execute(true);
            }
        }
    }

    public List<String> reservationMenuList(Model model) {
        List<String> reservationMenuList = new ArrayList<String>();
        List<String> reservationMenuViewKeyList = new ArrayList<String>();
        for (Permission permission : model.getPermissions()) {
            if (model.getActiveUser().getRoleKey().equals(permission.getpRoleKey()) &&
                    permission.getpViewKey().length() == 2 && permission.getpViewKey().startsWith("R")) {
                reservationMenuViewKeyList.add(permission.getpViewKey());
            }
        }
        for (View view : model.getViews()) {
            if (reservationMenuViewKeyList.contains(view.getViewKey())) {
                reservationMenuList.add(view.getViewName() + " [" + view.getViewKey() + "]");
            }
        }
        reservationMenuList.add("Exit (E)");
        return reservationMenuList;
    }
}


