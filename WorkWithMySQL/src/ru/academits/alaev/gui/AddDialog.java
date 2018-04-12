package ru.academits.alaev.gui;

import javax.swing.*;
import java.awt.*;

class AddDialog {
    private JDialog dialog = new JDialog();
    private final JTextField name = new JTextField();
    private JButton addButton = new JButton("Добавить имя");
    //  private JDialog queryDialog = new JDialog();

    AddDialog() {
        initAddDialog();
        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(250, 150));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    JButton getAddButton() {
        return addButton;
    }

    JTextField getName() {
        return name;
    }

    void close() {
        dialog.dispose();
    }

    private void initAddDialog() {
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 5;
        c1.gridheight = 1;
        c1.fill = GridBagConstraints.BOTH;
        c1.insets = new Insets(0, 0, 10, 10);
        dialog.add(name, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.NONE;
        c2.gridx = 0;
        c2.gridy = 2;
        c2.insets = new Insets(10, 0, 0, 10);
        dialog.add(addButton, c2);


    }

}
