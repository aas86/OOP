package ru.academITschool.alaev.main;


import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.Model;
import ru.academITschool.alaev.model.PlayingField;
import ru.academITschool.alaev.text.TextUI;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        //--------------------------------------------------------------------
                /*
                * Проверка Random

        Random matrix = new Random();
        PlayingField field = new PlayingField(9, 9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field.getField()[i][j] = new Cell(i, j, matrix.nextInt(81));
            }
        }
        Cell[][] result = field.getField();
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                if (result[i][j].getValue() >= 0 && result[i][j].getValue() < 9 ) {
                    System.out.printf("%s  ", "b");
                } else{
                    System.out.printf("%s  ", "X");
                }
            }
        }
        System.out.println();
        //--------------------------------------------------------------------*/

        TextUI consoleView = new TextUI();
        Minesweeper minesweeper = new Model();
        Controller controller = new Controller(consoleView, minesweeper);
        consoleView.addViewListener(controller);
        consoleView.startApplication();

    }
}
