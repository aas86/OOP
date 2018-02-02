package ru.academITschool.alaev.model;

public class Cell {
    private boolean isOpen = false;
    private boolean isMarked = false;
    private boolean isMined;
    private int mineCounter;
    private int rowPosition;
    private int columnPosition;
    private double value;


    public Cell(int rowPosition, int columnPosition, double value) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
        this.value = value;

    }


    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
