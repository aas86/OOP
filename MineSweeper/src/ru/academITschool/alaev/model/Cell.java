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

    void setBombLabel(String bombLabel) {
        this.bombLabel = bombLabel;
    }

    public String getBombLabel() {
        return bombLabel;
    }

    Cell(int rowPosition, int columnPosition) {
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;

    }

    public void setRowPosition(int x) {
        this.rowPosition = x;
    }

    int getRowPosition() {
        return this.rowPosition;
    }


    public void setColumnPosition(int y) {
        this.columnPosition = y;
    }

    int getColumnPosition() {
        return this.columnPosition;
    }

    public boolean isMined() {
        return isMined;
    }

    void setMined(boolean mined) {
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


    public String mineCounterToString() {
        return String.valueOf(mineCounter);
    }

    public int getMineCounter() {
        return mineCounter;
    }

    void setMineCounter() {
        this.mineCounter += 1;
    }

    void setMineCounter_Debug(int n) {
        this.mineCounter = n;
    }

    public boolean isOpen() {
        return isOpen;
    }

    void setOpen(boolean open) {
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

    void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isQuestioned() {
        return isQuestioned;
    }

    void setQuestioned(boolean questioned) {
        isQuestioned = questioned;
    }
}
