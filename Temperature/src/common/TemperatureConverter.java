package common;

/**
 * Интерфейс модели преобразования температуры между шкалами
 */
public interface TemperatureConverter {
    /**
     * Преобразует температуру в градусах в некоторую другую шкалу
     * @param t температура в градусах чего-то
     * @return температура в другой шкале
     */
    double convert(double t, Object name);
}
