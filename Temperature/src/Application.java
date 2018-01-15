import common.TemperatureConverter;
import common.View;
import controller.Controller;
import gui.FrameView;
import model.*;

/**
 * Класс Приложение - Application. Ответственен только за создание модели, представления и контроллера, и запуска представления view
 */
public class Application {
    public static void main(String[] args) {
        // Здесь используем синтаксис try-catch с освобождением ресурсов
        // Интерфейс модели View наследуется от интерфейса AutoCloseable, который позволяет использовать этот синтаксис
        View view = new FrameView();
        // В роли модели выступает интерфейс TemperatureConverter
        // В правой части можно использовать и другую модель (в пакете model есть еще другой пример модели)
        // В этом и суть MVC - за счет использования интерфейсов и разделения кода на 3 части, можно добиться
        // простой заменяемости модели и представления



        TemperatureConverter converterCelsiusToFahrenheit = new CelsiusToFahrenheitConverter();
        TemperatureConverter converterCelsiusToKelvin = new CelsiusToKelvinConverter();
        TemperatureConverter converterFahrenheitToCelsius = new FahrenheitToCelsiusConverter();
        TemperatureConverter converterFahrenheitToKelvin = new FahrenheitToKelvinConverter();
        TemperatureConverter converterKelvinToCelsius = new KelvinToCelsiusConverter();
        TemperatureConverter converterKelvinToFahrenheit = new KelvinToFahrenheitConverter();

        // Контроллер - связующее звено, поэтому он знает и о модели, и о представлении
        Controller controller = new Controller(converterCelsiusToFahrenheit, view, "Celsius to Fahrenheit");
        Controller controller1 = new Controller(converterCelsiusToKelvin, view, "Celsius to Kelvin");
        Controller controller2 = new Controller(converterFahrenheitToCelsius, view, "Fahrenheit to Celsius");
        Controller controller3 = new Controller(converterFahrenheitToKelvin, view, "Fahrenheit to Kelvin");
        Controller controller4 = new Controller(converterKelvinToCelsius, view, "Kelvin to Celsius");
        Controller controller5 = new Controller(converterKelvinToFahrenheit, view, "Kelvin to Fahrenheit");



        // Между view и контроллером должна быть двусторонняя связь
        // Чтобы сделать её слабее, контроллер реализует интерфейс ViewListener - подписчик на события представления
        view.addViewListener(controller);
        view.addViewListener(controller1);
        view.addViewListener(controller2);
        view.addViewListener(controller3);
        view.addViewListener(controller4);
        view.addViewListener(controller5);



        // Запуск view
        view.startApplication();

    }
}
