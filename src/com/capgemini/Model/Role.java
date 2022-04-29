package com.capgemini.Model;

public class Role {
    private String roleKey;
    private String roleName;

    public Role(String roleKey, String roleName) {
        this.roleKey = roleKey;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        super.toString();
        return "Role{" +
                "roleKey='" + roleKey + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public String getRoleKey() {
        return roleKey;
    }
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}