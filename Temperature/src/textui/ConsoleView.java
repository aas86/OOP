package textui;

import common.View;
import common.ViewListener;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Консольное представление
 * Просит ввести температуру и переводит ее в нужную шкалу
 * Программа завершается, если ввести exit
 */

public class ConsoleView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private final static String EXIT_COMMAND = "exit";
    private Object item;
    @Override
    public void startApplication() {
        while (true) {
            try {
                System.out.println("Enter temperature:");

                String text = scanner.nextLine();
                if (text.toLowerCase().equals(EXIT_COMMAND)) {
                    break;
                }

                double temperature = Double.parseDouble(text);

                // Когда прочитали температуру, оповещаем всех подписчиков (в том числе контроллер), что
                // мы хотим сконвертировать температуру
                for (ViewListener listener : listeners) {
                    listener.needConvertTemperature(temperature, item);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature: it must be number");
            }
        }
    }

    @Override
    public void onTemperatureConverted(double convertedTemperature) {
        System.out.println("Result = " + convertedTemperature);
    }

    @Override
    public void addViewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeViewListener(ViewListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void close() throws Exception {
        listeners.clear();
        scanner.close();
    }
}
