package common;

/**
 * Интерфейс модели преобразования температуры между шкалами
 */
public interface TemperatureConverter {

    /* Преобразует температуру в градусах чего-то в некоторую другую шкалу*/


    double convert(double temperature, Convertible from, Convertible to);
}
