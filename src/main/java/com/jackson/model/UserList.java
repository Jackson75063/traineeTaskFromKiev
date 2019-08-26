package com.jackson.model;

import java.util.List;

public class UserList {


    private String name;
    private List<User> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}

