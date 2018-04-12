package ru.academits.alaev.gui;

import javax.swing.*;
import java.awt.*;

class ConnectionFrame {
    private final JFrame connectFrame = new JFrame("Connection to DB");
    private JButton connect = new JButton("Connect");
    private JTextField login = new JTextField();
    private JTextField password = new JTextField();
    private JLabel loginLabel = new JLabel("Login");
    private JLabel passwordLabel = new JLabel("Password");

    ConnectionFrame() {
        initConnectionFrame();
        connectFrame.setResizable(false);
        connectFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        connectFrame.setMinimumSize(new Dimension(250, 150));
        connectFrame.setLocationRelativeTo(null);
        connectFrame.setVisible(true);
    }

    ConnectionFrame(String label) {
        initConnectionFrame();
        connectFrame.setResizable(false);
        connectFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        connectFrame.setMinimumSize(new Dimension(250, 150));
        connectFrame.setLocationRelativeTo(null);
        connectFrame.setTitle(label);
        connectFrame.setVisible(true);
    }

    JButton getConnect() {
        return connect;
    }

    JTextField getLogin() {
        return login;
    }

    JTextField getPassword() {
        return password;
    }

    void close() {
        connectFrame.dispose();
    }

    private void initConnectionFrame() {
        connectFrame.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.fill = GridBagConstraints.BOTH;
        c1.insets = new Insets(0, 0, 10, 15);
        connectFrame.add(loginLabel, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 1;
        c2.gridy = 1;
        c2.gridwidth = 3;
        c2.gridheight = 1;
        c2.fill = GridBagConstraints.BOTH;
        c2.insets = new Insets(0, 0, 10, 0);
        connectFrame.add(login, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 2;
        c3.gridwidth = 1;
        c3.gridheight = 1;
        c3.fill = GridBagConstraints.BOTH;
        c3.insets = new Insets(0, 0, 10, 15);
        connectFrame.add(passwordLabel, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 1;
        c4.gridy = 2;
        c4.gridwidth = 3;
        c4.gridheight = 1;
        c4.fill = GridBagConstraints.BOTH;
        c4.insets = new Insets(0, 0, 10, 0);
        connectFrame.add(password, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 1;
        c5.gridy = 3;
        c5.gridwidth = 3;
        c5.gridheight = 1;
        c5.fill = GridBagConstraints.BOTH;
        c5.insets = new Insets(10, 0, 10, 0);
        connectFrame.add(connect, c5);
    }
}
