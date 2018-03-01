package ru.academITschool.alaev.text;

import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.PlayingField;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI implements View {

    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final static String EXIT_COMMAND = "exit";
    private final static String CHANGE_FIELD = "change field";
    private boolean gameOver = false;
    private int rows = 9;
    private int columns = 9;
    private int x;
    private int y;

    private void coordinateInput() {
        boolean correctData = false;
        while (!correctData) {
            System.out.println("Введите координаты строки и столбца от 1 до 9 или exit");
            String textX = scanner.nextLine();
            if (textX.equals(EXIT_COMMAND)) {

                return;
            } else if (textX.equals("")) {
                System.out.println("Неверно введены координаты");
                continue;
            }
            try {
                x = Integer.parseInt(textX) - 1;
                String textY = scanner.nextLine();
                if (textY.equals(EXIT_COMMAND)) {
                    return;
                } else if (textY.equals("")) {
                    System.out.println("Неверно введены координаты");
                    continue;
                }
                y = Integer.parseInt(textY) - 1;
                if (isCorrectData()) {
                    correctData = true;
                } else {
                    System.out.println("Неверно введены координаты");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода!");
                System.out.println("Сначала введите номер строки, потом нажмите Enter");
                System.out.println("Затем введите номер столбца и нажмите Enter");
            }

        }
    }

    @Override
    public void startApplication() {
        System.out.println("Если нужно изменить размер поля введите команду change field");
        System.out.println("Для выхода введите exit");
        System.out.print("Для начала нажмите Enter");

        while (!gameOver) {
            String text = scanner.nextLine();
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
            printField();
            System.out.println();
            while (!gameOver) {
                boolean flag = false;
                boolean questioned = false;
                boolean wheelClick = false;
                boolean correctCommand = false;

                while (!correctCommand) {
                    System.out.println("Введите команду open, flag, question, wheel click или exit");
                    String textCommand = scanner.nextLine();
                    if (textCommand.equals(EXIT_COMMAND)) {
                        return;
                    } else if (textCommand.equals("")) {
                        System.out.println("Неверно введена команда!");
                    } else if (textCommand.equals("flag")) {
                        flag = true;
                        coordinateInput();
                        correctCommand = true;
                    } else if (textCommand.equals("question")) {
                        questioned = true;
                        coordinateInput();
                        correctCommand = true;
                    } else if (textCommand.equals("open")) {
                        coordinateInput();
                        correctCommand = true;
                    } else if (textCommand.equals("wheel click")) {
                        wheelClick = true;
                        coordinateInput();
                        correctCommand = true;
                    } else {
                        System.out.println("Неверно введена команда");
                        correctCommand = false;
                    }
                }
                for (ViewListener listener : listeners) {
                    int mines = 10;
                    listener.needMakeMove(x, y, rows, columns, mines, flag, questioned, wheelClick);
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
        Cell[][] cells = field.getField();
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
                if (cells[i][j].isOpen() && !cells[i][j].isMined()) {
                    System.out.printf("%d  ", cells[i][j].getMineCounter());
                } else if (cells[i][j].isOpen() && cells[i][j].isMined()) {
                    System.out.printf("%s  ", cells[i][j].getBombLabel());
                } else if (cells[i][j].isFlagged()) {
                    System.out.printf("%s  ", "F");
                } else if (cells[i][j].isQuestioned()) {
                    System.out.printf("%s  ", "?");
                } else {
                    System.out.printf("%s  ", "C");
                }
            }
        }
        System.out.println();
    }

    private boolean isCorrectData() {
        return (x >= 0 && x < rows) && (y >= 0 && y < columns);
    }

    private void printField() {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            if (i == 0) {
                System.out.print("    ");
                for (int m = 1; m <= rows; m++) {    // цикл для рисования "шапки из цифр"
                    System.out.printf("%d  ", m);
                }

                System.out.println();
                System.out.print("    ");
                for (int k = 1; k <= rows; k++) {    //цикл для рисования "шапки из ---"
                    System.out.printf("%s  ", "-");
                }
                System.out.println();
            }
            System.out.printf("%d  |", i + 1);
            for (int j = 0; j < columns; j++) {
                System.out.printf("%s  ", "C");
            }
        }
        System.out.println();
    }
}
