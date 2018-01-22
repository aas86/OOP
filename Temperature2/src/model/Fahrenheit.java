package model;

import common.Convertible;

public class Fahrenheit implements Convertible {

    @Override
    public double thisToCelsius(double receivedTemperature) {
        return 5 * (receivedTemperature - 32) / 9;
    }

    @Override
    public double celsiusToThis(double receivedTemperature) {
        return receivedTemperature * 9.0 / 5.0 + 32.0;
    }


    public String toString() {
        return "Fahrenheit";
    }
}