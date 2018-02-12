package ru.academITschool.alaev.text;

import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.PlayingField;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI implements View {
    @SuppressWarnings("unchecked")
    private final ArrayList<ViewListener> listeners = new ArrayList();
    private final Scanner commandScan = new Scanner(System.in);
    private final Scanner moveScan = new Scanner(System.in);
    private final static String EXIT_COMMAND = "exit";
    private final static String START_COMMAND = "start";
    private final static String CHANGE_FIELD = "change field";
    private boolean gameOver = false;
    private int rows = 9;
    private int columns = 9;
    private int mines = 10;

    @Override
    public void startApplication() {
        System.out.println("Если нужно изменить размер поля введите команду change field");
        System.out.println("Для выхода введите exit");
        System.out.println("Для начала введите start");

        while (!gameOver) {
            String text = commandScan.nextLine();
            // int columns = 9;
            //   int rows = 9;
           // int mines = 10;
            if (text.toLowerCase().equals(EXIT_COMMAND)) {
                break;
            } else if (text.toLowerCase().equals(CHANGE_FIELD)) {
                System.out.println("Введите количество строк");
                String inputRows = moveScan.nextLine();
                rows = Integer.parseInt(inputRows);
                System.out.println("Введите количество столбцов");
                String inputColumns = moveScan.nextLine();
                columns = Integer.parseInt(inputColumns);
            }
            while (!gameOver) {
                System.out.println("Введите координаты от 0 до 8 или exit");
                String textX = moveScan.nextLine();
                if (textX.equals(EXIT_COMMAND)) {
                    return;
                }
                String textY = moveScan.nextLine();
                if (textY.equals(EXIT_COMMAND)) {
                    return;
                }
                int x = Integer.parseInt(textX);
                int y = Integer.parseInt(textY);

                for (ViewListener listener : listeners) {
                    listener.needMakeMove(x, y, rows, columns, mines);

                }
            }
        }
    }


    @Override
    public void addViewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void showMove(PlayingField field) {
        if (field.isGameOver()) {
            Cell[][] result = field.getField();
            for (int i = 0; i < field.getRows(); i++) {
                System.out.println();
                for (int j = 0; j < field.getColumns(); j++) {
                    if (!result[i][j].isMined()) {
                        System.out.printf("%s   ", result[i][j].getMineCounter());
                    } else if (result[i][j].isMined()) {
                        System.out.printf("X   ");
                    }
                }
            }
            System.out.println();
            System.out.println("GAME OVER!");
            gameOver = true;
        } else {
            System.out.println();
            Cell[][] result1 = field.getField();
            for (int i = 0; i < field.getRows(); i++) {
                System.out.println();
                for (int j = 0; j < field.getColumns(); j++) {
                    if (result1[i][j].isOpen()) {
                        System.out.printf("%d ", result1[i][j].getMineCounter());
                    } else {
                        System.out.printf("%s ", "C");
                    }
                }
            }
            System.out.println();
            if (field.getOpenedCount() == rows * columns - mines) {
                System.out.println("YOU WIN!");
                gameOver = true;
            }
        }
    }
}
