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
                    char c = string.charAt(i);
                    if (string.charAt(i) == '"') {
                        int j = i + 1;
                        if (string.charAt(j) == '"') {     //если после кавычек ещё кавычки, то печатаем их
                            writer.print(string.charAt(j));
                            i = j;
                        } else { // если нет, => вся ячейка в кавычках, а значит есть запятая или перевод строки. До конца ячейки печатаем всё
                                 // но как определить, где именно перевод строки??????
                            while (string.charAt(j) != '"' && string.charAt(j + 1) != ',') { // условие конца ячейки, заключённой в кавычки - ",
                                // но оно не верное, если в ячейке есть подряд символы ",. Их нужно напечатать, а алгоритм решает, что конец.
                                // Какое должно быть условие конца ячейки?
                                if (string.charAt(j) == ',') {  // если попалась , печатаем её
                                    writer.print(string.charAt(j));
                                    j++;
                                    i = j;
                                } else {
                                    writer.print(string.charAt(j));
                                    j++;
                                    i = j;
                                }
                            }
                        }
                    } else if (string.charAt(i) == ',') {
                        writer.print("</td> <td>");
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

