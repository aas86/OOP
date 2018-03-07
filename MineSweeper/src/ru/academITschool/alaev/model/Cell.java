package ru.academITschool.alaev.model;

public class Cell {
    private boolean isOpen = false;
    private boolean isMarked = false;
    private boolean isFlagged = false;
    private boolean isQuestioned = false;
    private boolean isMined;
    private int mineCounter;
    private String bombLabel;
    private int rowPosition;
    private int columnPosition;

    public void setBombLabel(String bombLabel) {
        this.bombLabel = bombLabel;
    }

    public String getBombLabel() {
        return bombLabel;
    }

    public Cell(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;

    }

    public void setRowPosition(int x) {
        this.rowPosition = x;
    }

    public int getRowPosition() {
        return this.rowPosition;
    }


    public void setColumnPosition(int y) {
        this.columnPosition = y;
    }

    public int getColumnPosition() {
        return this.columnPosition;
    }

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


public String mineCounterToString(){
        return String.valueOf(mineCounter);
}
    public int getMineCounter() {
        return mineCounter;
    }

    public void setMineCounter() {
        this.mineCounter += 1;
    }
    public void setMineCounter_Debug(int n){
    this.mineCounter = n;
    }
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isQuestioned() {
        return isQuestioned;
    }

    public void setQuestioned(boolean questioned) {
        isQuestioned = questioned;
    }
}
