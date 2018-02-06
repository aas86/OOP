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
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                field[i][j] = new Cell(i, j, false);
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
                if (!result[i][j].isMined()) {
                    System.out.printf("%s   ", ".");
                } else if (result[i][j].isMined()){
                    System.out.printf("X   ");
                }
            }
        }
        System.out.println();
    }
}
