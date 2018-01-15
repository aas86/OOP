package model;

import common.TemperatureConverter;


public class KelvinToCelsiusConverter implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        return temperature - 273.15;
    }
}
