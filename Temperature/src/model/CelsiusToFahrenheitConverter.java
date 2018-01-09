package model;

import common.TemperatureConverter;

/**
 * Модель, переводящая из шкалы Цельсия в шкалу Фаренгейта
 */
public class CelsiusToFahrenheitConverter implements TemperatureConverter {
    @Override
    public double convert(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }
}
