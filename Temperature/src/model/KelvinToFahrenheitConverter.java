package model;

import common.TemperatureConverter;

public class KelvinToFahrenheitConverter implements TemperatureConverter{
    @Override
    public double convert(double temperature) {
        return 9 * (temperature - 273.15) / 5 + 32;
    }
}
