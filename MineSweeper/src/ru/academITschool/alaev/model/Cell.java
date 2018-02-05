package ru.academITschool.alaev.model;

public class Cell {
    private boolean isOpen = false;
    private boolean isMarked = false;
    private boolean isMined;
    private int mineCounter;
    private int rowPosition;
    private int columnPosition;
    private int value;


    public Cell(int rowPosition, int columnPosition, int value) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
        this.value = value;

    }


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
