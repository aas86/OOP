package ru.academITschool.alaev.model;


import ru.academITschool.alaev.interfaces.Minesweeper;

import java.util.Random;

public class Model implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;


    private void bombsGenerator(PlayingField playingField, int rows, int columns) {
        Cell[][] cells = playingField.getField();
        Random generator = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(i, j, generator.nextInt(rows*columns));
            }
        }
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns) { // x и y координаты хода
        if (firstMove) {
            this.playingField = new PlayingField(rows, columns);
            bombsGenerator(this.playingField, rows, columns);
            firstMove = false;
            return playingField;
        } else {
            return playingField;
        }
    }
}
