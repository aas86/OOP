package ru.academits.alaev.interfaces;



import ru.academits.alaev.model.Data;

import java.sql.SQLException;
import java.util.ArrayList;

public interface View {
    void addNewListener(ViewListener listener);
    void startApplication();
    void showDB(ArrayList<Data> resultSet) throws SQLException;
}

