package ru.academITschool.alaev.model;

import java.util.Random;

public class PlayingField {
    private Cell[][] field;
    private int rows;
    private int columns;

    public PlayingField(int rows, int columns, int mines, int x, int y) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
        this.field[x][y] = new Cell(x, y, false);
        Random generator = new Random();
        while (mines != 0) {
            int xBomb = generator.nextInt(rows);
            int yBomb = generator.nextInt(columns);
            if (!(this.field[x][y].equals(this.field[xBomb][yBomb])) && this.field[xBomb][yBomb] == null) {
                this.field[xBomb][yBomb] = new Cell(xBomb, yBomb, true);
                mines--;
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public void print() {
        Cell[][] result = this.getField();
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                if (result[i][j] == null) {
                    System.out.printf("%s   ", ".");
                } else if (result[i][j].isMined()){
                    System.out.printf("X   ");
                }
            }
        }
        System.out.println();
    }
}
