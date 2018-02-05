package ru.academITschool.alaev.model;

import ru.academITschool.alaev.interfaces.Minesweeper;

public class Model implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;

    private PlayingField fieldGenerator(int rows, int columns, int mines, int x, int y) {
        return new PlayingField(rows, columns, mines, x, y);
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns, int mines) { // x и y координаты хода
        if (firstMove) {
            this.playingField = fieldGenerator(rows, columns, mines, x, y);
            firstMove = false;
            return playingField;
        } else {
            return playingField;
        }
    }
}
