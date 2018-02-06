package ru.academITschool.alaev.model;

import ru.academITschool.alaev.interfaces.Minesweeper;

import java.util.Random;

public class Move implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;

    private PlayingField generateField(int rows, int columns) {
        return new PlayingField(rows, columns);
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns, int mines) { // x и y координаты хода
        if (firstMove) {
            this.playingField = generateField(rows, columns);
            this.playingField.generateBombs(x, y, mines, rows, columns);
            firstMove = false;
            return playingField;
        } else {
            return playingField;
        }
    }
}
