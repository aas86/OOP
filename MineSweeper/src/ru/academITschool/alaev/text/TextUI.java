package ru.academITschool.alaev.text;


import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextUI implements View {
    private final ArrayList<ViewListeners> listeners = new ArrayList();
    private final Scanner commandScan = new Scanner(System.in);
    private final Scanner moveScan = new Scanner(System.in);
    private final static String EXIT_COMMAND = "exit";
    private final static String START_COMMAND = "start";
    private final static String CHANGE_FIELD = "change field";


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
                        System.out.println("Введите координаты");
                        String textX = moveScan.nextLine();
                        String textY = moveScan.nextLine();
                        int x = Integer.parseInt(textX);
                        int y = Integer.parseInt(textY);
                        for (ViewListeners listener : listeners) {
                            listener.needMakeMove(x, y);
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
    public void addViewListener(ViewListeners listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void showMove(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
    }


}
