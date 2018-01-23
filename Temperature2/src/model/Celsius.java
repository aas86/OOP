package model;


import common.Convertible;

public class Celsius implements Convertible {

    @Override
    public double thisToCelsius(double receivedTemperature) {
        return receivedTemperature;
    }

    @Override
    public double celsiusToThis(double receivedTemperature) {
        return receivedTemperature;
    }

}
