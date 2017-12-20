package ru.academits.alaev.csv;

import sun.plugin.dom.css.CSSValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NewCSV {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("CSV\\src\\ru\\academits\\alaev\\csv\\output.html");
             Scanner scanner = new Scanner(new FileInputStream("CSV\\src\\ru\\academits\\alaev\\csv\\input_task.txt"))) {
            writer.println("<!doctype HTML public\"-//W3C//Dtd HTML 4.0 Frameset // EN\"");
            writer.println("<html>");
            writer.println("<head>");
            writer.print("<title>");
            writer.print("Задача CSV");
            writer.println("</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" cellspacing = \"0\" align = \"center\"");
            boolean isInside = false;
            while (scanner.hasNextLine()) {
                writer.print("<tr>");
                writer.print("<td>");
                String string = scanner.nextLine(); // получили первую строку
            //    System.out.println(string.length());
                for (int i = 0; i < string.length(); i++) {//цикл прохода по строке
                    char symbol = string.charAt(i);
                    if (symbol == '"') {// в строке есть ',' или перевод строки, или просто ", или пустая ячейка в кавычках
                        isInside = true;
                        i++;
                        while (isInside) { // пока внутри ячейки, заключенной в кавычки, то если встречаются 2 кавычки подряд, то это обычная кавычка.
                            // Если встречается 1 кавычка - то это закрывающая кавычка для ячейки.
                            if (string.charAt(i) == '"' && string.charAt(i + 1) == '"'){
                       //         System.out.print(string.charAt(i));
                                writer.print(string.charAt(i + 1));
                                i = i + 2;
                            } else {
                                while (string.charAt(i) != '"') {
                               //     System.out.print(string.charAt(i));
                                    writer.print(string.charAt(i));
                                    i++;
                                    if (i == string.length()) {
                                        writer.print("</br>");
                                        string = scanner.nextLine();
                                        i = 0;
                                    }
                                }
                                if (string.charAt(i) == '"' && string.charAt(i + 1) == '"'){
                                    writer.print(string.charAt(i + 1));
                                }
                            }
                            isInside = false;
                        }
                    } else if (symbol == ',') {
                        writer.print("</td><td>");
                    } else {
                        while (string.charAt(i) != ',') {
                 //           System.out.print(string.charAt(i));
                            writer.print(string.charAt(i));
                            if (i == string.length() - 1) {
                                writer.print("</tr>");
                                break;
                            } else if (string.charAt(i + 1) == ',' && i != string.length()) {
                                break;
                            }
                            i++;
                        }
                        //writer.print("</td>");
                    }
                }
                System.out.println();
            }
            writer.println("<table>");
            writer.println("</body>");
            writer.println("</html>");

        }
    }
}
