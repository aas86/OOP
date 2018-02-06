package ru.academITschool.alaev.model;


import java.util.Random;

public class PlayingField {
    private Cell[][] field;
    private int rows;
    private int columns;

    public PlayingField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public void generateBombs(int x, int y, int mines, int rows, int columns) {
        Random generator = new Random();
        int minesCount = mines;
        while (minesCount != 0) {
            int xBomb = generator.nextInt(rows);
            int yBomb = generator.nextInt(columns);
            Cell cell = field[xBomb][yBomb];
            Cell firstMoveCell = field[x][y];
            if (!cell.isMined() && cell != firstMoveCell) {
                cell.setMined(true);
                minesCount--;
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
