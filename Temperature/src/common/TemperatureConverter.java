package common;

/**
 * Интерфейс модели преобразования температуры между шкалами
 */
public interface TemperatureConverter {
    /**
     * Преобразует температуру в градусах Цельсия в некоторую другую шкалу
     * @param celsius температура в градусах Цельсия
     * @return температура в другой шкале
     */
    double convert(double celsius);
}
