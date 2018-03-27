package ru.academITschool.alaev.model;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class RecordWriter {
    private final int RECORDS_COUNT = 5;
    private final String path = "MineSweeper\\recordTable.txt";


    RecordWriter() {
    }

    boolean isEmpty() throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            return !scanner.hasNextLine();
        }
    }

    void writeFirstRecord(long gameTime, String name) throws IOException {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(name + "|" + gameTime + "| seconds" + System.lineSeparator());
        }
    }

    void writeRecord(long gameTime, String name) throws IOException {
        ArrayList<Record> timesList = new ArrayList<>();
        timesList.add(new Record(name, (int) gameTime));
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?)(\\|)(.*?)(\\|.*)");
                Matcher matcher = pattern.matcher(string);
                matcher.find();
                String nameInTable = matcher.group(1);
                int timeInTable = Integer.parseInt(matcher.group(3));
                timesList.add(new Record(nameInTable, timeInTable));
            }
        }
        List<Record> sortedList = timesList.stream()
                .sorted((o1, o2) -> o1.getTime() - o2.getTime())
                .collect(Collectors.toList());
        int i = 0;
        try (FileWriter writer = new FileWriter(path, false)) {
            while (i < timesList.size() && i < RECORDS_COUNT) {
                String writeName = sortedList.get(i).getName();
                int timeWrite = sortedList.get(i).getTime();
                writer.write(writeName + "|" + timeWrite + "| seconds" + System.lineSeparator());
                i++;
            }
        }
    }

    boolean isRecord(long gameTime) throws IOException {
        int i = 0;
        int[] records = new int[5];
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?\\|)(.*?)(\\|.*)");
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    String str = matcher.group(2);
                    records[i] = Integer.parseInt(str);
                    i++;
                }
            }
            return i < RECORDS_COUNT || (int) gameTime < records[i - 1];
        } catch (FileNotFoundException e) {
            FileWriter file = new FileWriter(path);
            file.close();
            return true;
        }
    }
}
