package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Canoes;
import com.capgemini.View.CanoeDeleteView;
import java.io.*;

public class CanoeDeleteController<check> {
    String id, type, numberOfTheSeats, timeOfTheMinimumTrip, tripPrice;
    CanoeDeleteView canoeDeleteView = new CanoeDeleteView();
    Canoes canoes = new Canoes();
    int count = -1;


    public void execute() throws FileNotFoundException {
        canoeDeleteView.execute();
        id = canoeDeleteView.getId();
        boolean check = false;
        for (Canoe canoe : canoes.getCanoes()) {
            count++;
            if (id.equals(canoe.getCanoeId())) {
                type = canoe.getCanoeType();
                numberOfTheSeats = canoe.getNumberOfTheSeats();
                timeOfTheMinimumTrip = canoe.getTimeOfTheMinimumTrip();
                tripPrice = canoe.getTripPrice();
                canoeDeleteView.selectedCanoe(id, type, numberOfTheSeats, timeOfTheMinimumTrip, tripPrice);
                check = true;
                break;
            }
        }


        if (check&&canoeDeleteView.checkUser()) {
        try {
            delete(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } else if (!check) {
            canoeDeleteView.nFound();
        }
    }

    private void delete(int index) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/CanoeDB");
        canoes.getCanoes().remove(index);
        writer.print("");
        for (Canoe canoe : canoes.getCanoes()) {
            writer.println(canoe.getCanoeId() + "," +
                    canoe.getCanoeType() + "," +
                    canoe.getNumberOfTheSeats() + "," +
                    canoe.getTimeOfTheMinimumTrip() + "," +
                    canoe.getTripPrice());
        }
        writer.close();
        canoeDeleteView.successMessage();
    }
}