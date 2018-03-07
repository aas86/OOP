package ru.academITschool.alaev.model;

import ru.academITschool.alaev.interfaces.Minesweeper;

import java.util.Timer;

public class Move implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;


    private PlayingField generateField(int rows, int columns, int mines) {
        return new PlayingField(rows, columns, mines);
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns, int mines,
                                 boolean flag, boolean questioned, boolean wheelClick) {
        // x и y координаты хода
        // rows, columns и mines нужны для первого хода, т.к
        // после первого хода создаётся игровое поле с минами
        if (firstMove) {
            this.playingField = generateField(rows, columns, mines);
            this.playingField.generateBombs(x, y, mines, rows, columns);

            //  this.playingField.generate_Bombs_Debug();
            this.playingField.countBombs(rows, columns);
            this.playingField.move(x, y, flag, questioned, wheelClick);
            firstMove = false;
            return playingField;
        } else {
            playingField.move(x, y, flag, questioned, wheelClick);
            return playingField;
        }
    }

    @Override
    public void makeNewGame(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
