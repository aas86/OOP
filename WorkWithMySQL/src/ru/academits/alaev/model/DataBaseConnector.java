package ru.academits.alaev.model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import ru.academits.alaev.interfaces.Connector;


import java.sql.*;
import java.util.ArrayList;

public class DataBaseConnector implements Connector {
    private final String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String user /*= "root"*/;
    private String password /*= "repmvf"*/;


    @Override
    public void add(String name) throws ClassNotFoundException, SQLException {
        name = checkName(name);
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // Подключаюсь к существующей БД (предварительно создал её в MySQL WorkBench)
            statement.executeUpdate("USE test;");
            String query = "INSERT INTO test(name) VALUES('" + name + "');";
            try {
                statement.executeUpdate(query);
            } catch (MySQLSyntaxErrorException e) {
                statement.executeUpdate("CREATE TABLE test (id INT AUTO_INCREMENT primary KEY, name VARCHAR(255) NOT NULL );");
                statement.executeUpdate(query);
            }
        }
    }

    @Override
    public ArrayList<Data> getData() throws SQLException {
        ArrayList<Data> data = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("USE test;");
            try {
                resultSet = statement.executeQuery("SELECT * FROM test;");
            } catch (MySQLSyntaxErrorException e) {
                statement.executeUpdate("CREATE TABLE test (id INT AUTO_INCREMENT primary KEY, name VARCHAR(255) NOT NULL );");
                resultSet = statement.executeQuery("SELECT * FROM test;");
            }
            //  String[] result = new String[resultSet.getRow()];
            //  int i = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String string = resultSet.getString("name");
                Data object = new Data(id, string);
                data.add(object);

               /* System.out.printf(" %d %s", resultSet.getInt("id"), resultSet.getString("name")
                        + System.lineSeparator());*/
            }
        }
        return data;
    }

    @Override
    public ArrayList<Data> filterDB(int id, String name) throws SQLException {
        name = checkName(name);
        ArrayList<Data> data = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            if (id == 0 && name.length() != 0) {
                String query = "SELECT name , id FROM test WHERE name = '" + name + "';";
                resultSet = statement.executeQuery(query);
            } else if (id != 0 && name.length() == 0) {
                String query = "SELECT name , id FROM test WHERE id = '" + id + "';";
                resultSet = statement.executeQuery(query);
            } else {
                resultSet = statement.executeQuery("SELECT * FROM test;");
            }

            while (resultSet.next()) {
                int idResult = resultSet.getInt("id");
                String string = resultSet.getString("name");
                Data object = new Data(idResult, string);
                data.add(object);
            }
        }
        return data;
    }

    @Override
    public void connect(String login, String password) {
        this.user = login;
        this.password = password;
    }

    private String checkName(String name) {
        if (name.contains("'")) {
            name = name.replace("'", "\\'");
        }
        return name;
    }
}

