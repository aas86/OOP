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
    private String scale;


    public Controller(TemperatureConverter temperatureConverter, View view, String scale) {
        this.temperatureConverter = temperatureConverter;
        this.view = view;
        this.scale = scale;
    }

    public String getScale() {
        return scale;
    }

    @Override
    public void needConvertTemperature(double t, String name) {
        // Переводит температуру при помощи модели, оповещает View об изменении данных
        // В данном случае, данные передаются в метод
        view.onTemperatureConverted(temperatureConverter.convert(t));
    }
}
