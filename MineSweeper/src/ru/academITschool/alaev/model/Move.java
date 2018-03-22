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

    public void writeRecord(long gameTime, String name) throws IOException {
        RecordWriter recordWriter = new RecordWriter();
        if (recordWriter.isEmpty()) {
            recordWriter.writeFirstRecord(gameTime, name);
        } /*else if (recordWriter.isLessThenFive()) { // Если меньше 5 рекордов, то записываем всё
            recordWriter.writeRecord(gameTime, name);
        } */else { // Иначе, если больше 5, то проверяем, а нужно ли записывать текущее время (является ли оно рекордом)
            // Для этого находим худшее время и сравниваем с ним.
            recordWriter.writeRecord(gameTime, name);

            }
        }


    @Override
    public void makeNewGame(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
