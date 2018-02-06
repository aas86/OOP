package ru.academITschool.alaev.model;

import ru.academITschool.alaev.interfaces.Minesweeper;

import java.util.Random;

public class Move implements Minesweeper {
    private boolean firstMove = true;
    private PlayingField playingField;

    private PlayingField fieldGenerator(int rows, int columns) {
        return new PlayingField(rows, columns);
    }
    private PlayingField bombsGenerator(int x, int y, int mines, int rows, int columns){
        Random generator = new Random();
        while (mines != 0){
            int xBomb = generator.nextInt(rows);
            int yBomb = generator.nextInt(columns);
            Cell cell = playingField.getField()[xBomb][yBomb];
            Cell firstMoveCell = playingField.getField()[x][y];
            if (!cell.isMined() && cell != firstMoveCell){
                cell.setMined(true);
                mines--;
            }
        }
        return playingField;
    }

    @Override
    public PlayingField makeMove(int x, int y, int rows, int columns, int mines) { // x и y координаты хода
        if (firstMove) {
            this.playingField = fieldGenerator(rows, columns);
            this.playingField = bombsGenerator(x, y, mines, rows, columns);
            firstMove = false;
            return playingField;
        } else {
            return playingField;
        }
    }
}
