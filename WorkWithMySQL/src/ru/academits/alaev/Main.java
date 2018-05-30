package ru.academits.alaev;

import ru.academits.alaev.controller.Controller;
import ru.academits.alaev.gui.FrameView;
import ru.academits.alaev.model.DataBaseConnector;

public class Main {
    public static void main(String[] args) {
        FrameView frameView = new FrameView();
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        Controller controller = new Controller(frameView, dataBaseConnector);
        frameView.addNewListener(controller);
        frameView.startApplication();
    }
}
