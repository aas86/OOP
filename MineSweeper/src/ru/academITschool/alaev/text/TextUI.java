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
    private final Scanner scanner = new Scanner(System.in);
    //private final Scanner scanner1 = new Scanner(System.in);
    private final static String EXIT_COMMAND = "exit";
    private final static String START_COMMAND = "start";
    private final static String CHANGE_FIELD = "change field";
    private boolean gameOver = false;
    private int rows = 9;
    private int columns = 9;

    @Override
    public void startApplication() {
        System.out.println("Если нужно изменить размер поля введите команду change field");
        System.out.println("Для выхода введите exit");
        System.out.println("Для начала нажмите Enter");

        while (!gameOver) {
            String text = scanner.nextLine();
            // int columns = 9;
            //   int rows = 9;
            // int mines = 10;
            if (text.toLowerCase().equals(EXIT_COMMAND)) {
                break;
            } else if (text.toLowerCase().equals(CHANGE_FIELD)) {
                System.out.println("Введите количество строк");
                String inputRows = scanner.nextLine();
                rows = Integer.parseInt(inputRows);
                System.out.println("Введите количество столбцов");
                String inputColumns = scanner.nextLine();
                columns = Integer.parseInt(inputColumns);
            }
            while (!gameOver) {
                System.out.println("Введите координаты от 1 до 9 или exit");
                String textX = scanner.nextLine();
                if (textX.equals(EXIT_COMMAND)) {
                    return;
                }
                String textY = scanner.nextLine();
                if (textY.equals(EXIT_COMMAND)) {
                    return;
                }
                int x = Integer.parseInt(textX) - 1;
                int y = Integer.parseInt(textY) - 1;

                for (ViewListener listener : listeners) {
                    int mines = 10;
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
        System.out.println();
        if (field.isVictory()) {
            System.out.println("YOU WIN!");
            gameOver = true;
        } else if (field.isGameOver()) {
            System.out.println("GAME OVER!");
            gameOver = true;
        }
        Cell[][] result = field.getField();
        for (int i = 0; i < field.getRows(); i++) {
            System.out.println();
            if (i == 0) {
                System.out.print("    ");
                for (int m = 1; m <= field.getRows(); m++) {    // цикл для рисования "шапки из цифр"
                    System.out.printf("%d  ", m);
                }

                System.out.println();
                System.out.print("    ");
                for (int k = 1; k <= field.getRows(); k++) {    //цикл для рисования "шапки из ---"
                    System.out.printf("%s  ", "-");
                }
                System.out.println();
            }
            System.out.printf("%d  |", i + 1);
            for (int j = 0; j < field.getColumns(); j++) {
                if (result[i][j].isOpen() && !result[i][j].isMined()) {
                    System.out.printf("%d  ", result[i][j].getMineCounter());
                } else if (result[i][j].isOpen() && result[i][j].isMined()) {
                    System.out.printf("%s  ", result[i][j].getBombLabel());
                } else {
                    System.out.printf("%s  ", "C");
                }
            }
        }
        System.out.println();
    }
}
