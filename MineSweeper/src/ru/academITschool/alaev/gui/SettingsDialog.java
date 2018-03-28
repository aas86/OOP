package ru.academITschool.alaev.gui;

import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.model.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static java.awt.GridBagConstraints.CENTER;

public class SettingsDialog {
    private JDialog settingsDialog = new JDialog();
    private JLabel labelRows = new JLabel("Height");
    private JLabel labelColumns = new JLabel("Width");
    private JLabel labelMines = new JLabel("Mines");
    private JTextField rows = new JTextField();
    private JTextField columns = new JTextField();
    private JTextField mines = new JTextField();
    private JLabel error = new JLabel();
    private JButton okButton = new JButton("OK");

    SettingsDialog() {
        initSettingsDialog();
        settingsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingsDialog.setMinimumSize(new Dimension(200, 200));
        settingsDialog.setTitle("Game settings");
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setVisible(true);
    }

    public void okButtonPressed(JFrame mainFrame) {
        this.okButton.addMouseListener(new MouseAdapter() {
            int height;
            int width;
            int mine;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    height = Integer.parseInt(rows.getText());
                    width = Integer.parseInt(columns.getText());
                    mine = Integer.parseInt(mines.getText());
                    FieldSize fieldSize = new FieldSize(height, width, mine);
                    mainFrame.dispose();
                    settingsDialog.dispose();

                    View frameView = new FrameView(fieldSize.getHeight(), fieldSize.getWidth(), fieldSize.getMines());
                    Minesweeper minesweeper = new Move();
                    Controller controller = new Controller(frameView, minesweeper);
                    frameView.addViewListener(controller);
                    frameView.startApplication();

                } catch (NumberFormatException ex) {
                    error.setForeground(Color.RED);
                    error.setText("Values must be number");
                } /*catch (IOException e1) {
                    e1.printStackTrace();
                }*/ catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }


    private void initSettingsDialog() {
        settingsDialog.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(labelRows, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 2;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.BOTH;
        c2.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(rows, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 2;
        c3.gridy = 0;
        c3.fill = GridBagConstraints.NONE;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(labelColumns, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 2;
        c4.gridy = 1;
        c4.gridwidth = 2;
        c4.gridheight = 1;
        c4.anchor = GridBagConstraints.CENTER;
        c4.fill = GridBagConstraints.BOTH;
        c4.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(columns, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 4;
        c5.gridy = 0;
        c5.fill = GridBagConstraints.NONE;
        c5.anchor = GridBagConstraints.CENTER;
        c5.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(labelMines, c5);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 4;
        c6.gridy = 1;
        c6.gridwidth = 2;
        c6.gridheight = 1;
        c6.anchor = GridBagConstraints.CENTER;
        c6.fill = GridBagConstraints.BOTH;
        c6.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(mines, c6);

        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 2;
        c7.gridy = 4;
        c7.fill = GridBagConstraints.NONE;
        c7.anchor = GridBagConstraints.CENTER;
        c7.insets = new Insets(10, 10, 0, 10);
        settingsDialog.add(okButton, c7);

        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 0;
        c8.gridy = 6;
        c8.gridwidth = 5;
        // c8.gridheight = 1;
        //c8.weighty = 1.0;
        // c8.weightx = 1.0;
        c8.fill = GridBagConstraints.CENTER;
        c8.anchor = CENTER;
        c8.insets = new Insets(10, 10, 0, 10);
        settingsDialog.add(error, c8);
    }
}

