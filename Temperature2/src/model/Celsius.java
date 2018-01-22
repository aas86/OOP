package model;


import common.Convertible;

public class Celsius implements Convertible {
private final String name = "Celsius";

    @Override
    public double thisToCelsius(double receivedTemperature) {
        return receivedTemperature;
    }

    @Override
    public double celsiusToThis(double receivedTemperature) {
        return receivedTemperature;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
