package model;

import common.Convertible;

public class Kelvin implements Convertible {
    private final String name = "Kelvin";

    @Override
    public double thisToCelsius(double receivedTemperature) {
        return receivedTemperature - 273.15;
    }

    @Override
    public double celsiusToThis(double receivedTemperature) {
        return receivedTemperature + 273.15;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

}
