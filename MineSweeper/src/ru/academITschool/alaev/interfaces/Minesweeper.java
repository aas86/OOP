package ru.academITschool.alaev.interfaces;


import ru.academITschool.alaev.model.PlayingField;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface Minesweeper {
    PlayingField makeMove(int x, int y, int rows, int columns, int mines,
                          boolean rightButtonClick, boolean wheelClick);

    void makeNewGame(boolean firsMove);
    void writeRecord(long gameTime, String name) throws IOException;
    boolean isRecord(long gameTime) throws FileNotFoundException;

}


