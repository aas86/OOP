package model;

import common.TemperatureConverter;

/**
 * Модель, переводящая из шкалы Цельсия в шкалу Кельвина
 */
public class CelsiusToKelvinConverter implements TemperatureConverter {

    @Override
    public double convert(double temperature) {
        return temperature + 273.15;
    }
}
