package ru.academITschool.alaev.main;

import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.gui.FieldSize;
import ru.academITschool.alaev.gui.FrameView;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.model.Move;
import ru.academITschool.alaev.text.TextUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TextUI consoleView = new TextUI();
        FieldSize fieldSize = new FieldSize();
        View frameView = new FrameView(fieldSize.getHeight(), fieldSize.getWidth(), fieldSize.getMines());
        Minesweeper minesweeper = new Move();
        Controller controller = new Controller(frameView, minesweeper);
       // Controller controller = new Controller(consoleView, minesweeper);
        frameView.addViewListener(controller);
       // consoleView.addViewListener(controller);
       // consoleView.startApplication();
        frameView.startApplication();
//        consoleView.startApplication();
    }
}
