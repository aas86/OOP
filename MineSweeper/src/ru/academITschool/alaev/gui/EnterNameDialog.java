package ru.academITschool.alaev.gui;

import javax.swing.*;
import java.awt.*;

public class EnterNameDialog {
    private final JTextField name = new JTextField();
    private final JLabel label = new JLabel("Введите своё имя");
    private JDialog enterNameDialog = new JDialog();
    private final JButton okButton = new JButton("OK");
    EnterNameDialog(){
        initEnterNameDialog();
        enterNameDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        enterNameDialog.setMinimumSize(new Dimension(250, 150));
        enterNameDialog.setLocationRelativeTo(null);
        enterNameDialog.setVisible(true);
    }

    public JButton getOkButton() {
        return okButton;
    }
    public JTextField getName() {
        return name;
    }
    public void closeDialog(){
        this.enterNameDialog.dispose();
    }
    private void initEnterNameDialog(){
        enterNameDialog.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(0, 0, 20, 0);
        enterNameDialog.add(label, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.BOTH;
        enterNameDialog.add(name, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 4;
        c3.insets = new Insets(20, 0, 0, 0);
        c3.fill = GridBagConstraints.CENTER;
        c3.anchor = GridBagConstraints.CENTER;
        enterNameDialog.add(okButton, c3);


    }
}
