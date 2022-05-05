package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Canoes;
import com.capgemini.View.CanoeDeleteView;
import java.io.*;

public class CanoeDeleteController {
    String deleteIdAndType, id, type, numberOfTheSeats, timeOfTheMinimumTrip, tripPrice;
    CanoeDeleteView canoeDeleteView = new CanoeDeleteView();
    Canoes canoes = new Canoes();

    public void execute() throws FileNotFoundException {
        deleteIdAndType = canoeDeleteView.execute();
        id = deleteIdAndType.substring(0, deleteIdAndType.indexOf(','));
        type = deleteIdAndType.substring(deleteIdAndType.indexOf(',') + 1);
        System.out.println(id);
        System.out.println(type);

        for (int i = 0; i < canoes.getCanoes().size(); i++) {
            String checkId = canoes.getCanoes().get(i).getCanoeId();
            String checkType = canoes.getCanoes().get(i).getCanoeType();
            if (id.equals(checkId) && type.equals(checkType)) canoes.getCanoes().remove(i);
        }

        PrintWriter writer = new PrintWriter("src/com/capgemini/Model/CanoeDB");
        writer.print("");
        for (Canoe canoe : canoes.getCanoes()) {
            writer.println(canoe.getCanoeId() + ", " +
                    canoe.getCanoeType() + ", " +
                    canoe.getNumberOfTheSeats() + ", " +
                    canoe.getTimeOfTheMinimumTrip() + ", " +
                    canoe.getTripPrice());
        }
        writer.close();
    }
}

