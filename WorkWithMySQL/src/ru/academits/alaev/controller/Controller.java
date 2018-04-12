package ru.academits.alaev.controller;




import ru.academits.alaev.gui.FrameView;
import ru.academits.alaev.interfaces.ViewListener;
import ru.academits.alaev.model.DataBaseConnector;

import java.sql.SQLException;

public class Controller implements ViewListener {
    private FrameView view;
    private DataBaseConnector dataBaseConnector;

    public Controller(FrameView frameView, DataBaseConnector dataBaseConnector) {
        this.view = frameView;
        this.dataBaseConnector = dataBaseConnector;
    }

    @Override
    public void needAddToDB(String name) throws SQLException, ClassNotFoundException {
        dataBaseConnector.add(name);
    }

    @Override
    public void needSelectFromDB() throws SQLException {
        view.showDB(dataBaseConnector.getData());
    }

    @Override
    public void needFilterDB(int id, String name) throws SQLException {
        view.showDB(dataBaseConnector.filterDB(id, name));
    }

    @Override
    public void needConnect(String login, String password) {
        dataBaseConnector.connect(login, password);
    }


}