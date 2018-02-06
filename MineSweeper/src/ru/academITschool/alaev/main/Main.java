package ru.academITschool.alaev.main;

import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.model.Move;
import ru.academITschool.alaev.text.TextUI;

public class Main {
    public static void main(String[] args) {

        TextUI consoleView = new TextUI();
        Minesweeper minesweeper = new Move();
        Controller controller = new Controller(consoleView, minesweeper);
        consoleView.addViewListener(controller);
        consoleView.startApplication();

    }
}
