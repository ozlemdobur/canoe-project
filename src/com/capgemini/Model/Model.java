package com.capgemini.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<User> users = new ArrayList<User>();
    private List<Role> roles = new ArrayList<Role>();
    private List<Permission> permissions = new ArrayList<Permission>();
    private List<View> views = new ArrayList<View>();
    private List<Canoe> canoes = new ArrayList<Canoe>();
    private User activeUser = new User();
<<<<<<< HEAD
    private List<Reservation> reservations = new ArrayList<Reservation>();

=======
    private List<Reservation> reservations=new ArrayList<>();
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
    public Model() {
        Users users = new Users();
        this.users=users.getUsers();
        Roles roles = new Roles();
        this.roles = roles.getRoles();
        Views views = new Views();
        this.views = views.getViews();
        Permissions permissions = new Permissions();
        this.permissions = permissions.getPermissions();
        Reservations reservations = new Reservations();
        this.reservations = reservations.getReservations();
        Canoes canoes = new Canoes();
        this.canoes = canoes.getCanoes();
<<<<<<< HEAD
        this.activeUser = activeUser;
=======
        Reservations reservations = new Reservations();
        this.reservations=reservations.getReservations();
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
    }

    public User getActiveUser() {
        return activeUser;
    }
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    public List<View> getViews() {
        return views;
    }
    public void setViews(List<View> views) {
        this.views = views;
    }
<<<<<<< HEAD
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Canoe> getCanoes() {
        return canoes;
    }

    public void setCanoes(List<Canoe> canoes) {
        this.canoes = canoes;
    }

=======
    public List<Reservation> getReservations(){return reservations;}
>>>>>>> 15d3d7c6739efbbd579fe3e170e96b58e36f6c85
}
