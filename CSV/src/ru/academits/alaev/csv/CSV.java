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
                    if (string.charAt(i) == '"') {      // внутри ячейки, заключенной в кавычки
                        int j = i + 1;
                        int m = j + 1;
                        while (j <= string.length() - 2 && string.charAt(j) != '"') { //пока не встретится кавычка печатаем всё!
                            char temp = string.charAt(j);
                            writer.print(string.charAt(j));
                            ++j;
                            i = j;
                            m = j + 1;
                        }
                        //если встречаются 2 кавычки подряд, то это обычная кавычка.
                        if (string.charAt(m) == '"') {
                            writer.print(string.charAt(m));
                            i = m + 1;
                            while (string.charAt(i) != '"' && i <= string.length() - 2) {
                                char temp = string.charAt(i);
                                writer.print(temp);
                                i++;
                            }
                            writer.print(string.charAt(i));
                            if (string.charAt(i + 2) == '"' && i <= string.length() - 2) {
                                i = i + 2;
                            }
                        } else {
                            writer.print("</td> <td>");
                            // i = i + 1;
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

