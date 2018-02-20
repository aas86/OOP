package ru.academITschool.alaev.main;

import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.gui.FrameView;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.model.Move;
import ru.academITschool.alaev.text.TextUI;

public class Main {
    public static void main(String[] args) {
        TextUI consoleView = new TextUI();
        View frameView = new FrameView();
        Minesweeper minesweeper = new Move();
        Controller controller = new Controller(consoleView, minesweeper);
        consoleView.addViewListener(controller);
    //    consoleView.startApplication();
        frameView.startApplication();
    }
}
