package model;

import common.TemperatureConverter;

/**
 * Created by 437-5 on 15.01.2018.
 */
public class KelvinToCelsiusConverter implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        return temperature - 273.15;
    }
}
