package com.capgemini.Model;

public class Permission {
    private String pRoleKey;
    private String pViewKey;

    public Permission(String pRoleKey, String pViewKey) {
        this.pRoleKey = pRoleKey;
        this.pViewKey = pViewKey;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "pRoleKey='" + pRoleKey + '\'' +
                ", pViewKey='" + pViewKey + '\'' +
                '}';
    }

    public String getpRoleKey() {
        return pRoleKey;
    }
    public void setpRoleKey(String pRoleKey) {
        this.pRoleKey = pRoleKey;
    }
    public String getpViewKey() {
        return pViewKey;
    }
    public void setpViewKey(String pViewKey) {
        this.pViewKey = pViewKey;
    }
}
