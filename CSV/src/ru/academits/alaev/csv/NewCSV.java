package ru.academits.alaev.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NewCSV {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) {
            System.out.println("Введено некорректное число аргументов");
            System.out.println("Укажите в аргументах входной и выходной файлы");
            return;
        }
        try (PrintWriter writer = new PrintWriter(args[1]);
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset=\"utf-8\">");
            writer.print("<title> Задача CSV </title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" cellspacing=\"0\" align=\"center\">");
            boolean insideQuotes;
            while (scanner.hasNextLine()) {
                writer.print("<tr>");
                writer.print("<td>");
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    char symbol = string.charAt(i);
                    if (symbol == '"') {
                        insideQuotes = true;
                        i++;
                        while (insideQuotes) {
                            if (i == string.length() - 1) {
                                writer.print("</td></tr>");
                                insideQuotes = false;
                            } else if (string.charAt(i) == '"' && string.charAt(i + 1) == '"') {
                                writer.print(string.charAt(i + 1));
                                i = i + 2;
                            } else if (string.charAt(i) != '"') {
                                while (string.charAt(i) != '"') {
                                    switch (string.charAt(i)) {
                                        case '<':
                                            writer.print("&lt;");
                                            break;
                                        case '>':
                                            writer.print("&gt;");
                                            break;
                                        case '&':
                                            writer.print("&amp;");
                                            break;
                                        default:
                                            writer.print(string.charAt(i));
                                    }
                                    i++;
                                    if (i == string.length()) {
                                        writer.print("<br/>");
                                        string = scanner.nextLine();
                                        i = 0;
                                    }
                                }
                            } else {
                                insideQuotes = false;
                            }
                        }
                    } else if (symbol == ',') {
                        writer.print("</td><td>");
                        if (i == string.length() - 1) {
                            writer.print("</td></tr>");
                        }
                    } else {
                        while (string.charAt(i) != ',') {
                            switch (string.charAt(i)) {
                                case '<':
                                    writer.print("&lt;");
                                    break;
                                case '>':
                                    writer.print("&gt;");
                                    break;
                                case '&':
                                    writer.print("&amp;");
                                    break;
                                default:
                                    writer.print(string.charAt(i));
                            }
                            if (i == string.length() - 1) {
                                writer.print("</td></tr>");
                                break;
                            } else if (string.charAt(i + 1) == ',' && i != string.length()) {
                                break;
                            }
                            i++;
                        }
                    }
                }
                System.out.println();
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

        }
    }
}
