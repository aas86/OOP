package ru.academits.alaev.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("output.html");
             Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\ru\\academits\\alaev\\csv\\CSV.txt"))) {
            writer.println("<!doctype HTML public\"-//W3C//Dtd HTML 4.0 Frameset // EN\"");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("</head>");
            writer.println("<body>");
            while (scanner.hasNextLine()) {
                writer.print("<tr><td>");
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); ++i) {
                    char symbol = string.charAt(i);
                    if (symbol == ',') {
                        writer.print("</td> <td>");
                    } else if (symbol == '"') {      // если " => началась ячейка
                        i++;                         // переходим к след. символу
                        symbol = string.charAt(i);
                        char nextSymbol = string.charAt(i + 1);
                        if (symbol == '"' && nextSymbol == ',') { // если сразу же " и , => пустая ячейка
                            writer.print("</td> <td>");
                        } else if (symbol == '"' && nextSymbol == '"') { // надпись в кавычках
                            writer.print(nextSymbol);       // пишем открывающие кавычки
                            i = i + 2;      // переходим на символ за кавычками
                            while (string.charAt(i) != '"') { //пока не дойдём до закрывающих кавычек
                                symbol = string.charAt(i);
                                writer.print(symbol);         //пишем то, что между кавычками
                                i++;
                            }
                            writer.print(string.charAt(i)); // дошли до закрывающих кавычек и написали их. После них дублируются "
                            i = i + 2; //перешли к следующему символу, если он опять кавычки
                            if (string.charAt(i) == '"') {
                                ++i;
                            }
                            if (string.charAt(i) == '"' && string.charAt(i + 1) == '"') {
                                ++i;
                            }
                        } else {
                            while (string.charAt(i) != '"') {
                                symbol = string.charAt(i);
                                writer.print(symbol);         //пишем то, что между кавычками
                                i++;
                            }
                            if (string.charAt(i) == '"' && string.charAt(i + 1) == '"') {
                                writer.print(string.charAt(i));
                                i++;
                            }
                        }
                    } else {
                        writer.print(string.charAt(i));
                    }
                }
                writer.print("</td></tr><br/>");
            }
            writer.println("</body>");
            writer.println("</html>");
        }
    }


}

