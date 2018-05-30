package ru.academits.alaev.model;

public class Data {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int id;
    private String name;

    Data(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
