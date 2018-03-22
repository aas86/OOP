package ru.academITschool.alaev.model;


public class Records {
    private String name;
    private int time;

    public Records(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }
}
