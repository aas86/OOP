package ru.academITschool.alaev.controller;


import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListeners;

public class Controller implements ViewListeners {
    private final View view;
    private final Minesweeper minesweeper;

    public Controller(View view, Minesweeper minesweeper) {
        this.view = view;
        this.minesweeper = minesweeper;
    }

    @Override
    public void needMakeMove(int x, int y) {
       view.showMove(minesweeper.makeMove(x, y));
    }
}
