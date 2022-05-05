package com.capgemini.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Canoes {
    private List<Canoe> canoes = new ArrayList<>();

    public Canoes() {
        File file = new File("src/com/capgemini/Model/CanoeDB");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] canoe = scanner.nextLine().split(",");
                canoes.add(new Canoe(canoe[0], canoe[1], canoe[2], canoe[3], canoe[4]));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void print() {
        for (Canoe canoe : canoes) System.out.println(canoe);
    }

    public List<Canoe> getCanoes() {
        return canoes;
    }

    public void setCanoes(List<Canoe> canoes) {
        this.canoes = canoes;
    }
}

