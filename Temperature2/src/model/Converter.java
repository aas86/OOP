package model;


import common.Convertible;
import common.TemperatureConverter;

public class Converter implements TemperatureConverter {

    @Override
    public double convert(double temperature, Convertible from, Convertible to) {
       return to.celsiusToThis(from.thisToCelsius(temperature));
    }
}
