package com.capgemini.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Users() {
        File file = new File("src/com/capgemini/Model/UserDB");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] user = scanner.nextLine().split(",");
                users.add(new User(user[0], user[1], user[2], user[3]));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void print() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}