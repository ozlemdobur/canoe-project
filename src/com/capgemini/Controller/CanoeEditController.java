package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Canoe;
import com.capgemini.View.CanoeEditView;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

import static com.capgemini.Main.GREEN_BOLD;
import static com.capgemini.Main.TEXT_RESET;

public class CanoeEditController {
    String id, type, seats, minimumTrip, price, chosenKey;
    CanoeEditView canoeEditView = new CanoeEditView();
    Model model = new Model();
    Canoe editedCanoe;
    int count = -1;

    public void execute() throws FileNotFoundException {
        canoeEditView.executeView();
        id = canoeEditView.getEditId();

        boolean check = false;
        for (Canoe canoe : model.getCanoes()) {
            count++;
            if (id.equals(canoe.getCanoeId())) {
                type = canoe.getCanoeType();
                seats = canoe.getNumberOfTheSeats();
                minimumTrip = canoe.getTimeOfTheMinimumTrip();
                price = canoe.getTripPrice();
                canoeEditView.selectedCanoe(id, type, seats, minimumTrip, price);
                check = true;
                break;
            }
        }
        if (check) {
            switch (chosenKey = canoeEditView.askForChange().trim().toUpperCase(Locale.ROOT)) {
                case "TY":
                    editedCanoe = new Canoe(id, canoeEditView.getNewType(), seats, minimumTrip, price );
                    canoeEditView.editedCanoeView(editedCanoe);
                    if (canoeEditView.askSave().equals("Y")) write(editedCanoe);
                    break;
                case "SE":
                    editedCanoe = new Canoe(id, type, canoeEditView.getNewNumberOfTheSeats(), minimumTrip, price );
                    canoeEditView.editedCanoeView(editedCanoe);
                    if (canoeEditView.askSave().equals("Y")) write(editedCanoe);
                    break;
                case "MT":
                    editedCanoe = new Canoe(id, type, seats, canoeEditView.getNewTimeOfTheMinimumTrip(), price );
                    canoeEditView.editedCanoeView(editedCanoe);
                    if (canoeEditView.askSave().equals("Y")) write(editedCanoe);
                    break;
                case "PR":
                    editedCanoe = new Canoe(id, type, seats, minimumTrip, canoeEditView.getNewPrice() );
                    canoeEditView.editedCanoeView(editedCanoe);
                    if (canoeEditView.askSave().equals("Y")) write(editedCanoe);
                    break;
            }
        } else {
            System.out.println(GREEN_BOLD + "The canoe is not found please check information and try again." + TEXT_RESET);
        }
    }


    private void write(Canoe editedCanoe) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/CanoeDB");
        model.getCanoes().set(count,editedCanoe);
        writer.print("");
        for (Canoe canoe : model.getCanoes()) {
            writer.println(canoe.getCanoeId() + "," +
                    canoe.getCanoeType() + "," +
                    canoe.getNumberOfTheSeats() + "," +
                    canoe.getTimeOfTheMinimumTrip() + "," +
                    canoe.getTripPrice());
        }
        writer.close();
        canoeEditView.successfulMessage(chosenKey);
    }

}