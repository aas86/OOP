package ru.academITschool.alaev.model;


class Record {
    private String name;
    private int time;

    Record(String name, int time) {
        this.name = name;
        this.time = time;
    }

    String getName() {
        return name;
    }

    int getTime() {
        return time;
    }
}
