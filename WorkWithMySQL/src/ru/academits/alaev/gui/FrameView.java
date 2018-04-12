package ru.academits.alaev.gui;

import ru.academits.alaev.interfaces.View;
import ru.academits.alaev.interfaces.ViewListener;
import ru.academits.alaev.model.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrameView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final JFrame mainFrame = new JFrame("MainFrame");
    private JButton addButton = new JButton("Добавить в БД");
    private JButton queryButton = new JButton("Запрос к БД");


    @Override
    public void addNewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();
                initMainFrameContent();
                initEvents();
            }
        });
    }

    @Override
    public void showDB(ArrayList<Data> result) throws SQLException {
        QueryDialog queryDialog = new QueryDialog(result);
        queryDialog.getFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FilterDialog filterDialog = new FilterDialog();
                queryDialog.close();
                filterDialog.getOkButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id;
                        String name;
                        filterDialog.close();
                        try {
                            id = Integer.parseInt(filterDialog.getId().getText());
                            // System.out.println(id);

                        } catch (IllegalArgumentException e1) {
                            // filterDialog.getIdLabel().setForeground(Color.RED);
                            // filterDialog.getIdLabel().setText("Неверно введены данные");
                            id = 0;

                        }
                        try {
                            name = filterDialog.getName().getText();
                            // System.out.println(name);
                        } catch (IllegalArgumentException e2) {
                            name = null;
                        }

                        for (ViewListener listener : listeners) {
                            try {
                                listener.needFilterDB(id, name);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    private void initFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(350, 150));
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }


    private void initMainFrameContent() {
        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        //   c1.anchor = GridBagConstraints.WEST;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(0, 0, 0, 10);
        mainFrame.add(addButton, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.NONE;
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(0, 10, 0, 0);
        mainFrame.add(queryButton, c2);

    }

    private void initEvents() {
        boolean connected = false;
        ConnectionFrame connectionFrame = new ConnectionFrame();
        connectionFrame.getConnect().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = connectionFrame.getLogin().getText();
                String password = connectionFrame.getPassword().getText();
                connectionFrame.close();
                for (ViewListener listener : listeners) {
                    listener.needConnect(login, password);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDialog addDialog = new AddDialog();
                addDialog.getAddButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = addDialog.getName().getText();
                        addDialog.close();
                        for (ViewListener listener : listeners) {
                            try {
                                listener.needAddToDB(name);
                            } catch (SQLException | ClassNotFoundException e1) {
                                //   e1.printStackTrace();
                                ConnectionFrame connectionFrame1 = new ConnectionFrame("Wrong login or password");
                                connectionFrame1.getConnect().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String login = connectionFrame1.getLogin().getText();
                                        String password = connectionFrame1.getPassword().getText();
                                        connectionFrame1.close();
                                        for (ViewListener listener : listeners) {
                                            listener.needConnect(login, password);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ViewListener listener : listeners) {
                    try {
                        listener.needSelectFromDB();
                    } catch (SQLException e1) {
                        //e1.printStackTrace();
                        ConnectionFrame connectionFrame1 = new ConnectionFrame("Wrong login or password");
                        connectionFrame1.getConnect().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String login = connectionFrame1.getLogin().getText();
                                String password = connectionFrame1.getPassword().getText();
                                connectionFrame1.close();
                                for (ViewListener listener : listeners) {
                                    listener.needConnect(login, password);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

}

