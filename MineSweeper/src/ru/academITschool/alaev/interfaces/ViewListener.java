package ru.academITschool.alaev.interfaces;


public interface ViewListener {
    // событие, которое означает, что view хочет открыть поле
    void needMakeMove(int x, int y, int rows, int columns, int mines);
}
