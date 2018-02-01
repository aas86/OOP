package ru.academITschool.alaev.interfaces;

public interface View {
    // Запуск View
    void startApplication();
    void addViewListener(ViewListeners listener);
    //Метод вызывается, когда контроллер получит от модели отрисованное поле после хода.
    void showMove(int[][] field);

}
