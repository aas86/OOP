package controller;

import common.TemperatureConverter;
import common.View;
import common.ViewListener;

/**
 * Контроллер
 */
public class Controller implements ViewListener {
    private final TemperatureConverter temperatureConverter;
    private final View view;


    public Controller(TemperatureConverter temperatureConverter, View view) {
        this.temperatureConverter = temperatureConverter;
        this.view = view;
    }

    @Override
    public void needConvertTemperature(double t, Object name) {
        // Переводит температуру при помощи модели, оповещает View об изменении данных
        // В данном случае, данные передаются в метод
        view.onTemperatureConverted(temperatureConverter.convert(t, name));
    }
}
