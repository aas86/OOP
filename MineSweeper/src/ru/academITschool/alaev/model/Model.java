package ru.academITschool.alaev.model;


import ru.academITschool.alaev.interfaces.Minesweeper;

public class Model implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;


    private PlayingField fieldGenerator(int rows, int columns) {
        return new PlayingField(rows, columns);
    }

    private void bombsGenerator(PlayingField playingField, int rows, int columns) {
        Cell[][] cells = playingField.getField();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               cells[i][j] = new Cell(i,j,Math.random());
            }
        }
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns) {
        if (firstMove) {
            this.playingField = fieldGenerator(rows, columns);
            bombsGenerator(this.playingField, rows, columns);
            firstMove = false;
            return playingField;
        } else {
            return playingField;
        }
    }
}
