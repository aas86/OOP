package ru.academITschool.alaev.model;

import ru.academITschool.alaev.gui.EnterNameDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

public class RecordTable {
    private long timeResult;
    private Scanner scanner;

    public RecordTable(long gameTime, String name) throws IOException {
        this.timeResult = gameTime;
        try (FileWriter writer = new FileWriter("MineSweeper\\recordTable.txt", true)){
            writer.write(name + "|" + timeResult + "| seconds" + "\n");
        }
    }

  /*  public boolean isEmpty() {
        return !this.scanner.hasNextLine();
    }

    public boolean isNeedWriteRecord() {
        int count = 0;
        char[] time = new char[3];
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            char[] tempLine = new char[string.length()];
            for (int i = 0; i < string.length(); i++) {
                char symbol = string.charAt(i);
                if (symbol == '|') {
                    for (int j = i + 1, m = 0; j < string.length(); j++, m++, i++) {
                        char symbolTime = string.charAt(j);
                        if (symbolTime == '|') {
                            tempLine[i] = time[m - 1];
                            i++;
                            break;
                        }
                        time[m] = symbolTime;
                        tempLine[i] = string.charAt(i);
                    }
                }
                tempLine[i] = symbol;
            }
            String t = new String(time);
            int currentLineTime = Integer.parseInt(t.trim());
            System.out.println(currentLineTime);
            if (currentLineTime < timeResult) {
                count++;
            }
        }
        return count < 5;

    }


    public void createRecordTable(EnterNameDialog dialog) {
        dialog.getOkButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String name = dialog.getName().getText();
                try (PrintWriter writer = new PrintWriter("MineSweeper\\recordTable.txt")) {
                    writer.print(name + "|" + timeResult + "| seconds");
                    //   writer.println(timeResult + " сек");
                    dialog.closeDialog();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

  /*  public RecordTable(long gameTime, EnterNameDialog dialog) {
        this.dialog = dialog;
        this.timeResult = gameTime;
        dialog.getOkButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String name = dialog.getName().getText();
                try (PrintWriter writer = new PrintWriter("MineSweeper\\recordTable.txt")) {
                    writer.print(name + "|" + timeResult + "| seconds");
                    //   writer.println(timeResult + " сек");
                    dialog.closeDialog();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }*/

   /* public RecordTable(long timeResult, Scanner scanner) { // timeResult - это время за которое завершилась текущая игра
        // теперь нужно считать все времена из таблицы и поставить
        // timeResult в нужное место.

        dialog.getOkButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                boolean isItTime;
                char[] time = new char[3];
                while (scanner.hasNextLine()) {
                    String string = scanner.nextLine();
                    char[] tempLine = new char[string.length()];
                    for (int i = 0; i < string.length(); i++) {
                        char symbol = string.charAt(i);
                        if (symbol == '|') {
                            for (int j = i + 1, m = 0; j < string.length(); j++, m++, i++) {
                                char symbolTime = string.charAt(j);
                                if (symbolTime == '|') {
                                    tempLine[i] = time[m - 1];
                                    i++;
                                    break;
                                }
                                time[m] = symbolTime;
                                tempLine[i] = string.charAt(i);
                            }
                        }
                        tempLine[i] = symbol;
                    }
                    String t = new String(time);
                    int currentLineTime = Integer.parseInt(t.trim());
                    System.out.println(currentLineTime);
                    if (currentLineTime > timeResult) {
                        try (PrintWriter writer = new PrintWriter("MineSweeper\\recordTable.txt")) {
                            String name = dialog.getName().getText();
                            writer.println(name + "|" + timeResult + "| seconds");
                            writer.print(tempLine);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        try (PrintWriter writer = new PrintWriter("MineSweeper\\recordTable.txt")) {
                            writer.println(tempLine);
                            String name = dialog.getName().getText();
                            writer.println(name + "|" + timeResult + "| seconds");
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }

                }
                dialog.closeDialog();
            }
        });
    }*/

}
