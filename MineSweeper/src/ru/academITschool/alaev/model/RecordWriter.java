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

    public boolean isEmpty() throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            return !scanner.hasNextLine();
        }
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

    public boolean isRecord(long gameTime) throws IOException {
        int i = 0;
        int[] records = new int[5];
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?\\|)(.*?)(\\|.*)");
                Matcher matcher = pattern.matcher(string);
                if (!matcher.find()) {

                } else {
                    String str = matcher.group(2);
                    records[i] = Integer.parseInt(str);
                    i++;
                }
            }
            //   Arrays.sort(records); // Получили все пять значений времени в виде массива и отсортировали его
            return i < RECORDS_COUNT || (int) gameTime < records[i - 1];
        } catch (FileNotFoundException e) {
            new FileWriter("MineSweeper\\recordTable.txt");
            return true;
        }
    }
}
