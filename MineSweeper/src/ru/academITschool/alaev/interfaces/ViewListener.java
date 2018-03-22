package ru.academITschool.alaev.interfaces;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface ViewListener {
    // событие, которое означает, что view хочет открыть поле
    void needMakeMove(int x, int y, int rows, int columns, int mines,
                      boolean rightButtonClick, boolean wheelClick);

    void needNewGame(boolean firstMove);
    void needWriteRecord(long gameTime, String name) throws IOException;
    boolean isRecord(long gameTime) throws FileNotFoundException;
}

