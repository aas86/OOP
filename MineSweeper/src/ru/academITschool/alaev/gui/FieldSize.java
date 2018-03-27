package ru.academITschool.alaev.gui;


public class FieldSize {
    private int height;
    private int width;
    private int mines;

    public FieldSize() {
        this.height = 9;
        this.width = 9;
        this.mines = 10;
    }

    public FieldSize(int height, int width, int mines) {
        this.height = height;
        this.width = width;
        this.mines = mines;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getMines() {
        return mines;
    }
}
