package ru.academITschool.alaev.interfaces;

import ru.academITschool.alaev.model.PlayingField;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface View {
    // Запуск View
    void startApplication() throws IOException;

    void addViewListener(ViewListener listener);

    //Метод вызывается, когда контроллер получит от модели отрисованное поле после хода.
    void showMove(PlayingField field) throws IOException;


}
