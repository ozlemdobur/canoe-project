package com.capgemini.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class make a list from the ViewDB!
 */
public class Views {
    List<View> views = new ArrayList<View>();

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    public Views(){
        File file = new File("src/com/capgemini/Model/ViewDB");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] view = scanner.nextLine().split(",");
                views.add(new View(view[0], view[1]));
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public void print() {
        for (View view: views) {
            System.out.println(view);
        }
    }
}
