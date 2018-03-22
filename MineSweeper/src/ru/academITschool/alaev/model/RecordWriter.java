package ru.academITschool.alaev.model;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RecordWriter {
    private final int RECORDS_COUNT = 5;


    public RecordWriter() {
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
                // System.out.println(nameInTable + "           " + timeInTable);
                timesList.add(new Records(nameInTable, timeInTable));
            }
        }
        List<Records> sortedList = timesList.stream()
                .sorted((o1, o2) -> o1.getTime() - o2.getTime())
                .collect(Collectors.toList());
        int i = 0;
        try (FileWriter writer = new FileWriter("MineSweeper\\recordTable.txt", false)) {
            while (i < timesList.size() && i < RECORDS_COUNT) {
                String imyaNaZapis = sortedList.get(i).getName();
                int vremyaNaZapis = sortedList.get(i).getTime();
                writer.write(imyaNaZapis + "|" + vremyaNaZapis + "| seconds" + System.lineSeparator());
                i++;
            }
        }
    }

    public boolean isRecord(long gameTime) throws FileNotFoundException {
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
         //   Arrays.sort(records); // Получили все пять значений времени в виде массива и отсортировали его
            return i < RECORDS_COUNT || (int) gameTime < records[i - 1];
        }

    }


   /* public boolean isLessThenFive() throws FileNotFoundException {
        int stringCount = 0;
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                stringCount++;
            }
        }
        // scanner.close();
        return stringCount < RECORDS_COUNT;
    }*/

   /* public boolean isNeedWrite(long gameTime) throws FileNotFoundException {
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
            Arrays.sort(records);
            return gameTime < records[4];
        }
    }








   /* public void createRecordTable(EnterNameDialog dialog) {
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



}
