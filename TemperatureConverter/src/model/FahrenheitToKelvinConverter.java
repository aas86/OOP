package model;


import common.TemperatureConverter;

public class FahrenheitToKelvinConverter implements TemperatureConverter{
    @Override
    public double convert(double temperature) {
        return 5 * (temperature - 32) / 9 + 273.15;
    }
}
