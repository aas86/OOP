package ru.academITschool.alaev.model;

public class Cell {
    private boolean isOpen = false;
    private boolean isMarked = false;
    private boolean isMined;
    private int mineCounter;
    private int rowPosition;
    private int columnPosition;
    //  private int value;

    public Cell(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;

    }

    public void setRowPosition(int x) {
        this.rowPosition = x;
    }

    public void setColumnPosition(int y) {
        this.columnPosition = y;
    }


  /*  public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }*/

    public boolean isMined() {
        return isMined;
    }

    public void setMined(boolean mined) {
        isMined = mined;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return this.rowPosition == cell.rowPosition && this.columnPosition == cell.columnPosition;
    }

    public int getMineCounter() {
        return mineCounter;
    }

    public void setMineCounter(int mineCounter) {
        this.mineCounter += mineCounter;
    }
}
