package ru.academITschool.alaev.interfaces;

import ru.academITschool.alaev.model.PlayingField;

public interface View {
    // Запуск View
    void startApplication();
    void addViewListener(ViewListener listener);
    //Метод вызывается, когда контроллер получит от модели отрисованное поле после хода.
    void showMove(PlayingField field);

}
