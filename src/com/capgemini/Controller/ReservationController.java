package com.capgemini.Controller;

import com.capgemini.Model.*;
import com.capgemini.View.ReservationAddView;
import com.capgemini.View.ReservationMenuView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    public void execute(Model model) throws IOException {
        boolean selectedAnyMenu = true;
        while (selectedAnyMenu) {
            ReservationMenuView reservationMenuView = new ReservationMenuView();
            List reservationMenuList = reservationMenuList(model);
            String selectedReservationMenuItem = reservationMenuView.show(reservationMenuList);
<<<<<<< HEAD
            boolean isItSuccessed ;
            switch (selectedReservationMenuItem) {
                case "RA":
                    ReservationAddController reservationAddController = new ReservationAddController(model);
                    isItSuccessed = reservationAddController.execute();
                    if (isItSuccessed) {
                        execute(model);
                    } else {
                        selectedReservationMenuItem = "RA";
                        break;
                    }
=======
            switch (selectedReservationMenuItem) {
                case "RA":
                    ReservationAddController reservationAddController = new ReservationAddController(model);
                    reservationAddController.execute();
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
                    /*ReservationAddView reservationAddView = new ReservationAddView();
                    Reservation newReservation = reservationAddView.execute((model.getReservations().size() + 1) + "",model.get);
                    , newReservation);
                    boolean isItSaved = reservationAddController.execute();
                    reservationAddView.successedMessages();
                    execute(model);*/
                    /* if (newReservation != null) {
                        ReservationAddController reservationAddController = new ReservationAddController(model, newReservation);
                        boolean isItSaved = reservationAddController.execute();
                        userAddView.successedMessages();
                        execute(model);
                    } else {
                        userAddView.failedMessages();
                        selectedUserMenuItem = "UA";
                        break;
                    }
                    UserAddController userAddController = new UserAddController(model,newUser);
                    userAddController.execute();
                    break;*/
                case "RE":
<<<<<<< HEAD
                    UserEditController userEditController = new UserEditController();
                    userEditController.execute();
                    break;
                case "RD":
                    UserDeleteController userDeleteController = new UserDeleteController();
                    userDeleteController.execute();
=======
                    ReservationEditController reservationEditController = new ReservationEditController();
                    reservationEditController.execute();
                    break;
                case "RD":
                    ReservationDeleteController reservationDeleteController=new ReservationDeleteController();
                    reservationDeleteController.execute();
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
                    break;
                case "E":
                    MainMenuController mainMenuController = new MainMenuController(model);
                    mainMenuController.execute(true);
            }
        }
        System.out.println("Reservation Controller");
    }

    public List<String> reservationMenuList(Model model) {
        List<String> userMenuList = new ArrayList<String>();
        List<String> userMenuViewKeyList = new ArrayList<String>();
        for (Permission permission : model.getPermissions()) {
            if (model.getActiveUser().getRoleKey().equals(permission.getpRoleKey()) &&
                    permission.getpViewKey().length() == 2 && permission.getpViewKey().startsWith("R")) {
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


