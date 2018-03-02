package ru.academITschool.alaev.controller;

import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;


public class Controller implements ViewListener {

    private final View view;
    private Minesweeper minesweeper;

    public Controller(View view, Minesweeper minesweeper) {
        this.view = view;
        this.minesweeper = minesweeper;
    }

    @Override
    public void needMakeMove(int x, int y, int rows, int columns, int mines,
                             boolean flag, boolean questioned, boolean openField) {
        view.showMove(minesweeper.makeMove(x, y, rows, columns, mines, flag, questioned, openField ));
    }

    @Override
    public void needNewGame(boolean firstMove) {
        minesweeper.makeNewGame(firstMove);
    }

}
