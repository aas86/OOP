package ru.academits.alaev.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("c:\\Users\\437-5\\IdeaProjects\\Repository\\CSV\\src\\ru\\academits\\alaev\\csv\\CSV.txt"))) {
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); ++i) {
                    char c = string.charAt(i);
                    System.out.println(c);
                }
            }
        }
    }
}
