package common;

/**
 * Интерфейс модели преобразования температуры между шкалами
 */
public interface TemperatureConverter {
    /**
     * Преобразует температуру в градусах в некоторую другую шкалу
     * @param temperature температура в градусах чего-то
     * @return температура в другой шкале
     */
    double convert(double temperature);
}
