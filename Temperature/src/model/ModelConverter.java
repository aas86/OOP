package model;


import common.TemperatureConverter;

public class ModelConverter implements TemperatureConverter {

    @Override
    public double convert(double t, Object name) {
        if (name.equals("Celsius to Fahrenheit")) {
            return t * 1.8 + 32.0;
        } else if (name.equals("Celsius to Kelvin")){
            return t + 273.15;
        } else if (name.equals("Fahrenheit to Celsius")){
            return 5 * (t - 32) / 9;
        } else if (name.equals("Fahrenheit to Kelvin")){
            return 5 * (t - 32) / 9 + 273.15;
        } else if (name.equals("Kelvin to Fahrenheit")){
            return 9 * (t - 273.15) / 5 + 32;
        } else if (name.equals("Kelvin to Celsius")) {
            return t - 273.15;
        } else{
            return 0;
        }
    }
}
