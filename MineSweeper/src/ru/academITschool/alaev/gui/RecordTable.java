package ru.academITschool.alaev.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecordTable {
    private EnterNameDialog dialog;
    private long timeResult;

    public RecordTable(long gameTime) {
        this.timeResult = gameTime;
      //  this.dialog = new EnterNameDialog(timeResult);
    }

    public void createRecordTable() {
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

    public void addRecord(long timeResult, Scanner scanner) { // timeResult - это время за которое завершилась текущая игра
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
    }
}
