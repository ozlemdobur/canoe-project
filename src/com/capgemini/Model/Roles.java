package com.capgemini.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roles {
    List<Role> roles = new ArrayList<Role>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Roles(){
        File file = new File("src/com/capgemini/Model/RoleDB");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] role = scanner.nextLine().split(",");
                roles.add(new Role(role[0], role[1]));
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void print() {
        for (Role role: roles) {
            System.out.println(role);
        }
    }
}
