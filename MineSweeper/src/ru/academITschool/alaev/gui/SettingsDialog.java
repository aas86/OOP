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
        settingsDialog.setMinimumSize(new Dimension(300, 300));
        settingsDialog.setTitle("Game settings");
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setResizable(false);
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
                    if (isCorrectData(height, width, mine)) {
                        FieldSize fieldSize = new FieldSize(height, width, mine);
                        mainFrame.dispose();
                        settingsDialog.dispose();
                        View frameView = new FrameView(fieldSize.getHeight(), fieldSize.getWidth(), fieldSize.getMines());
                        Minesweeper minesweeper = new Move();
                        Controller controller = new Controller(frameView, minesweeper);
                        frameView.addViewListener(controller);
                        frameView.startApplication();
                    } else {
                        rows.setForeground(Color.BLUE);
                        columns.setForeground(Color.BLUE);
                        mines.setForeground(Color.BLUE);
                        rows.setText("9 - 24");
                        columns.setText("9 - 30");
                        mines.setText("10 - " + (height * width * 90) / 100);
                    }

                } catch (NumberFormatException ex) {
                    error.setForeground(Color.RED);
                    error.setText("Values  must be number");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    private boolean isCorrectData(int height, int width, int mine) {
        if (height < 9 || height > 24) {
            return false;
        } else if (width < 9 || width > 30) {
            return false;
        } else if (mine < 10 || mine > (height * width * 90) / 100) {
            return false;
        }else{
            return true;
        }
    }


    private void initSettingsDialog() {
        settingsDialog.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(5, 125, 5, 100);

        settingsDialog.add(labelRows, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        c2.gridwidth = 5;
        c2.gridheight = 1;
        c2.fill = GridBagConstraints.BOTH;
        c2.anchor = GridBagConstraints.CENTER;
        c2.insets = new Insets(5, 100, 5, 100);
        c2.weightx = 1;
        settingsDialog.add(rows, c2);


        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 4;
        c3.fill = GridBagConstraints.BOTH;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(5, 125, 5, 100);
        settingsDialog.add(labelColumns, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 5;
        c4.gridwidth = 2;
        c4.gridheight = 1;
        c4.fill = GridBagConstraints.BOTH;
        c4.anchor = GridBagConstraints.CENTER;
        c4.insets = new Insets(5, 100, 5, 100);
        c4.weightx = 1;
        settingsDialog.add(columns, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 0;
        c5.gridy = 8;
        c5.fill = GridBagConstraints.BOTH;
        c5.anchor = GridBagConstraints.CENTER;
        c5.insets = new Insets(0, 125, 0, 100);
        settingsDialog.add(labelMines, c5);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 0;
        c6.gridy = 9;
        c6.gridwidth = 2;
        c6.gridheight = 1;
        c6.fill = GridBagConstraints.BOTH;
        c6.anchor = GridBagConstraints.CENTER;
        c6.insets = new Insets(5, 100, 5, 100);
        c6.weightx = 1;
        settingsDialog.add(mines, c6);

        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 0;
        c7.gridy = 10;
        c7.fill = GridBagConstraints.NONE;
        c7.anchor = GridBagConstraints.CENTER;
        c7.insets = new Insets(15, 100, 0, 100);
        c7.weightx = 1;
        settingsDialog.add(okButton, c7);

        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 0;
        c8.gridy = 11;
        c8.gridwidth = 10;
        c8.gridheight = 1;
        c8.weighty = 1.0;
        c8.weightx = 1.0;
        c8.anchor = CENTER;
        c8.insets = new Insets(0, 10, 0, 10);
        settingsDialog.add(error, c8);
    }
}

