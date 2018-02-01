package ru.academITschool.alaev.model;


import ru.academITschool.alaev.interfaces.Minesweeper;

public class Model implements Minesweeper {
    private boolean firstMove = true;


    private void fieldGenerator() {

    }

    private void bombsGenerator() {

    }

    @Override
    public int[][] makeMove(int x, int y) {
        if (firstMove) {
            fieldGenerator();
            bombsGenerator();
            firstMove = false;
            return new int[][]{{0,0,0},{0,0,0}};
        } else {
            return new int[][]{{1,1,1},{1,1,1}};
        }
    }
}
