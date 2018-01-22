package model;

import common.Convertible;

public class Kelvin implements Convertible {

    @Override
    public double thisToCelsius(double receivedTemperature) {
        return receivedTemperature - 273.15;
    }

    @Override
    public double celsiusToThis(double receivedTemperature) {
        return receivedTemperature + 273.15;
    }

    public String toString() {
        return "Kelvin";
    }

}
