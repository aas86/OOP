package ru.academITschool.alaev.model;

public class Cell {
    private boolean isOpen = false;
    private boolean isMarked = false;
    private boolean isMined;
    private int mineCounter;
    private int rowPosition;
    private int columnPosition;
  //  private int value;

    public Cell(int rowPosition, int columnPosition, boolean isMined) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
        this.isMined = isMined;
    }

    public void setRowPosition(int x) {
        this.rowPosition = x;
    }

    public void setColumnPosition(int y) {
        this.columnPosition = y;
    }

    public Cell(int rowPosition, int columnPosition/*, int value*/) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
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
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return this.rowPosition == cell.rowPosition && this.columnPosition == cell.columnPosition
                && this.isMined == cell.isMined && this.isOpen == cell.isOpen && this.isMarked == cell.isMarked
                && this.mineCounter == cell.mineCounter;
    }
}
