package ru.academITschool.alaev.interfaces;


import ru.academITschool.alaev.model.PlayingField;

public interface Minesweeper {
    PlayingField makeMove(int x, int y, int rows, int columns, int mines,
                          boolean flag, boolean questioned, boolean wheelClick);

    void makeNewGame(boolean firsMove);

}


