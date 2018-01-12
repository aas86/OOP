import common.TemperatureConverter;
import common.View;
import controller.Controller;
import gui.FrameView;

import model.ModelConverter;
import textui.ConsoleView;

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



        TemperatureConverter conv = new ModelConverter();

        // Контроллер - связующее звено, поэтому он знает и о модели, и о представлении
        //  Controller controller = new Controller(converter, view);
        //   Controller controller1 = new Controller(converter1, view);
          Controller controller = new Controller(conv, view);

        // Между view и контроллером должна быть двусторонняя связь
        // Чтобы сделать её слабее, контроллер реализует интерфейс ViewListener - подписчик на события представления

        view.addViewListener(controller);
        //     view.addViewListener(controller1);

        // Запуск view
        view.startApplication();

    }
}
