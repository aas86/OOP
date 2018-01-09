package model;

import common.TemperatureConverter;

/**
 * Модель, переводящая из шкалы Цельсия в шкалу Кельвина
 */
public class CelsiusToKelvinConverter implements TemperatureConverter {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}
