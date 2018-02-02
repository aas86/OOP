package ru.academITschool.alaev.text;


import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.PlayingField;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList();
    private final Scanner commandScan = new Scanner(System.in);
    private final Scanner moveScan = new Scanner(System.in);
    private final static String EXIT_COMMAND = "exit";
    private final static String START_COMMAND = "start";
    private final static String CHANGE_FIELD = "change field";
    private int rows;
    private int columns;


    @Override
    public void startApplication() {
        System.out.println("Если нужно изменить размер поля введите команду change field");
        System.out.println("Для выхода введите exit");
        System.out.println("Для начала введите start");

        while (true) {
            try {

                String text = commandScan.nextLine();
                if (text.toLowerCase().equals(EXIT_COMMAND)) {
                    break;
                } else if (text.toLowerCase().equals(CHANGE_FIELD)) {
                    //TODO другие размеры игрового поля
                } else if (text.toLowerCase().equals(START_COMMAND)) {

                    while (true) {
                        this.rows = this.columns = 9;
                        System.out.println("Введите координаты от 1 до 9");
                        String textX = moveScan.nextLine();
                        String textY = moveScan.nextLine();
                        int x = Integer.parseInt(textX);
                        int y = Integer.parseInt(textY);
                        for (ViewListener listener : listeners) {
                            listener.needMakeMove(x, y, this.rows, this.columns);
                        }
                    }
                } else {
                    throw new NotCommandException("Нет такой команды");
                }
            } catch (NotCommandException exception) {
                System.out.println("Нет такой команды! Введите ещё раз!");
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
       /* Cell[][] result = field.getField();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(result[i][j]);
            }
        }*/
       field.print();
    }


}
