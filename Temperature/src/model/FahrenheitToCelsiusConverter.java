package model;

import common.TemperatureConverter;

public class FahrenheitToCelsiusConverter implements TemperatureConverter {

    @Override
    public double convert(double temperature) {
       return  5 * (temperature - 32) / 9;
    }
}
