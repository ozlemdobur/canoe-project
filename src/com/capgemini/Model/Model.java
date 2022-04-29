package com.capgemini.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<User> users = new ArrayList<User>();
    private List<Role> roles = new ArrayList<Role>();
    private List<Permission> permissions = new ArrayList<Permission>();
    private List<View> views = new ArrayList<View>();
    private User activeUser = new User();
    public Model() {
        Users users = new Users();
        this.users=users.getUsers();
        Roles roles = new Roles();
        this.roles = roles.getRoles();
        Views views = new Views();
        this.views = views.getViews();
        Permissions permissions = new Permissions();
        this.permissions = permissions.getPermissions();
        this.activeUser = activeUser;
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

}
