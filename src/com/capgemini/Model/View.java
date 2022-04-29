package com.capgemini.Model;

public class View {
    private String viewKey;
    private String viewName;

    public View(String viewKey, String viewName) {
        this.viewKey = viewKey;
        this.viewName = viewName;
    }

    @Override
    public String toString() {
        return "View{" +
                "viewKey='" + viewKey + '\'' +
                ", viewName='" + viewName + '\'' +
                '}';
    }

    public String getViewName() {
        return viewName;
    }
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    public String getViewKey() {
        return viewKey;
    }
    public void setViewKey(String viewKey) {
        this.viewKey = viewKey;
    }
}
