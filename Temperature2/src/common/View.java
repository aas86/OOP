package common;

import java.util.HashMap;

/**
 * Интерфейс представления View
 * Содержит методы для управления слушателями ViewListener.
 * Также содержит методы, которые будут вызываться контроллером, например onTemperatureConverted
 */
public interface View /*extends AutoCloseable*/ {
    /**
     * Запуск View
     */
    void startApplication();

    /**
     * Метод вызывается, когда контроллер переведет температуру
     */
    void onTemperatureConverted(double convertedTemperature);

    /**
     * Добавление ViewListener'а
     * @param listener listener
     */
    void addViewListener(ViewListener listener);

    /**
     * Удаление ViewListener'а
     * @param listener listener
     */
    void removeViewListener(ViewListener listener);
}
