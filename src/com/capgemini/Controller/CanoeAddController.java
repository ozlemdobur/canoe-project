package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CanoeAddController {
    private Model model;
    private Canoe newCanoe;

    public CanoeAddController(Model model, Canoe newCanoe) {
        this.model = model;
        this.newCanoe = newCanoe;
    }

    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public Canoe getNewCanoe() {
        return newCanoe;
    }
    public void setNewCanoe(Canoe newCanoe) {
        this.newCanoe = newCanoe;
    }

    public boolean execute() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("src/com/capgemini/Model/CanoeDB"));
        model.getCanoes().add(newCanoe);
        for (Canoe canoes : model.getCanoes()) {
            writer.println(canoes.getCanoeId() + "," +
                    canoes.getCanoeType() + "," +
                    canoes.getNumberOfTheSeats() + "," +
                    canoes.getTimeOfTheMinimumTrip() + ", " +
                    canoes.getTripPrice());
        }
        writer.close();
        return true;
    }
}
