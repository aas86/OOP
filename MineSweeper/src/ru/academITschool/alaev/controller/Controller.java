package ru.academITschool.alaev.controller;

import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;

import java.io.IOException;


public class Controller implements ViewListener {

    private final View view;
    private Minesweeper minesweeper;

    public Controller(View view, Minesweeper minesweeper) {
        this.view = view;
        this.minesweeper = minesweeper;
    }

    @Override
    public void needMakeMove(int x, int y, int rows, int columns, int mines,
                             boolean rightButtonClick, boolean openField) {
        view.showMove(minesweeper.makeMove(x, y, rows, columns, mines, rightButtonClick, openField ));
    }

    @Override
    public void needWriteRecord(long gameTime, String name) throws IOException {
       minesweeper.writeRecord(gameTime, name);
    }

    @Override
    public void needNewGame(boolean firstMove) {
        minesweeper.makeNewGame(firstMove);
    }



}
