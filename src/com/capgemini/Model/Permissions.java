package com.capgemini.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permissions {
    List<Permission> permissions = new ArrayList<Permission>();

    public Permissions(){
        File file = new File("src/com/capgemini/Model/PermissonDB");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] permission = scanner.nextLine().split(",");
                permissions.add(new Permission(permission[0], permission[1]));
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public void print() {
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}