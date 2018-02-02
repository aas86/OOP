package ru.academITschool.alaev.model;

public class PlayingField {
    private Cell[][] field;
    private int rows;
    private int columns;

    public PlayingField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
    }

    public Cell[][] getField() {
        return field;
    }

    public void print() {
        Cell[][] result = this.getField();
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                if (0 < result[i][j].getValue() && result[i][j].getValue() < 0.1) {
                    System.out.printf("%f ", result[i][j].getValue());
                } else{
                    System.out.printf("X        ");
                }
            }
        }
        System.out.println();
    }
}
