package model;

import common.TemperatureConverter;

/**
 * Модель, переводящая из шкалы Цельсия в шкалу Фаренгейта
 */
public class CelsiusToFahrenheitConverter implements TemperatureConverter {
    public String scale;

    @Override
    public double convert(double temperature) {
        return temperature * 9.0 / 5.0 + 32.0;
    }
}
