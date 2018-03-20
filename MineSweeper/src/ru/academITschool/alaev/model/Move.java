package ru.academITschool.alaev.model;

import ru.academITschool.alaev.interfaces.Minesweeper;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Move implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;


    private PlayingField generateField(int rows, int columns, int mines) {
        return new PlayingField(rows, columns, mines);
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns, int mines,
                                 boolean rightButtonClick, boolean wheelClick) {
        // x и y координаты хода
        // rows, columns и mines нужны для первого хода, т.к
        // после первого хода создаётся игровое поле с минами
        if (firstMove) {
            this.playingField = generateField(rows, columns, mines);
            this.playingField.generateBombs(x, y, mines, rows, columns);
            //this.playingField.generate_Bombs_Debug();
            this.playingField.countBombs(rows, columns);
            this.playingField.move(x, y, rightButtonClick, wheelClick, true);
            firstMove = false;
            //System.out.println(playingField.getOpenedCount());
            return playingField;
        } else {
            playingField.move(x, y, rightButtonClick, wheelClick, false);
            //System.out.println(playingField.getOpenedCount());
            return playingField;
        }
    }

    public RecordTable writeRecord(long gameTime, String name) throws IOException {
        RecordTable recordTable = null;
        try {
            recordTable = new RecordTable(gameTime, name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return recordTable;
    }

    @Override
    public void makeNewGame(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
