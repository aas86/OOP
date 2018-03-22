package ru.academITschool.alaev.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RecordWriter {
    private final int RECORDS_COUNT = 5;


    public RecordWriter() {
      /*  try {
            this.writer = new FileWriter("MineSweeper\\recordTable.txt", true);
            //    this.scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public boolean isEmpty() throws FileNotFoundException {
        return !new Scanner(new FileInputStream("MineSweeper\\recordTable.txt")).hasNextLine();
    }

    public void writeFirstRecord(long gameTime, String name) throws IOException {
        try (FileWriter writer = new FileWriter("MineSweeper\\recordTable.txt", true)) {
            writer.write(name + "|" + gameTime + "| seconds" + System.lineSeparator());
        }
    }

    public void writeRecord(long gameTime, String name) throws IOException {
        ArrayList<Records> timesList = new ArrayList<>();
        timesList.add(new Records(name, (int) gameTime));
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?)(\\|)(.*?)(\\|.*)");
                Matcher matcher = pattern.matcher(string);
                matcher.find();
                String nameInTable = matcher.group(1);
                int timeInTable = Integer.parseInt(matcher.group(3));
                System.out.println(nameInTable + "           " + timeInTable);
                timesList.add(new Records(nameInTable, timeInTable));
            }
        }
        timesList.stream().sorted(((o1, o2) -> o1.getTime() - o2.getTime()));
        int i = 0;
        //  while (i < timesList.size() && i < RECORDS_COUNT) {
       // String imyaNaZapis = timesList.get(i).getName();
      //  int vremyaNaZapis = timesList.get(i).getTime();
        try (FileWriter writer = new FileWriter("MineSweeper\\recordTable.txt", false)) {
            while (i < timesList.size() && i < RECORDS_COUNT) {
                String imyaNaZapis = timesList.get(i).getName();
                int vremyaNaZapis = timesList.get(i).getTime();
                writer.write(imyaNaZapis + "|" + vremyaNaZapis + "| seconds" + System.lineSeparator());
                i++;
            }

        }
        //}
    }
      /*  try {
            this.writer.write(name + "|" + gameTime + "| seconds" + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    public boolean isLessThenFive() throws FileNotFoundException {
        int stringCount = 0;
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringCount++;
            }
        }
        // scanner.close();
        return stringCount < RECORDS_COUNT;
    }

    public boolean isNeedWrite(long gameTime) throws FileNotFoundException {
        int i = 0;
        int[] records = new int[5];
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?\\|)(.*?)(\\|.*)");
                Matcher matcher = pattern.matcher(string);
                matcher.find();
                String str = matcher.group(2);
                records[i] = Integer.parseInt(str);
                i++;
            }
            Arrays.sort(records); // Получили все пять значений времени в виде массива и отсортировали его
            /*records[4] = (int) gameTime;
            Arrays.sort(records);*/
            return gameTime < records[4];
        }
    }



   /* public RecordTable(long gameTime, String name) throws IOException {
        this.timeResult = gameTime;
        try (FileWriter writer = new FileWriter("MineSweeper\\recordTable.txt", true)) {
            writer.write(name + "|" + timeResult + "| seconds" + "\n");
        }
    }*/



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
