package ru.academITschool.alaev.interfaces;


import ru.academITschool.alaev.model.PlayingField;
import ru.academITschool.alaev.model.RecordTable;

import java.io.IOException;

public interface Minesweeper {
    PlayingField makeMove(int x, int y, int rows, int columns, int mines,
                          boolean rightButtonClick, boolean wheelClick);

    void makeNewGame(boolean firsMove);
    RecordTable writeRecord(long gameTime, String name) throws IOException;

}


