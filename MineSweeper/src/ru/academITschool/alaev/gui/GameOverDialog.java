package ru.academITschool.alaev.gui;


import javax.swing.*;
import java.awt.*;


public class GameOverDialog {
    private JLabel smile = new JLabel();
    private JButton newGameButton = new JButton("New game");
    private JButton exitButton = new JButton("Exit");
    private JDialog gameOverDialog = new JDialog();

    public GameOverDialog() {
        initGameOverDialog();
        gameOverDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gameOverDialog.setMinimumSize(new Dimension(250, 150));
        gameOverDialog.setLocationRelativeTo(null);

    }

    void setVisible() {
        this.gameOverDialog.setVisible(true);
    }

    void setTitle(String title) {
        this.gameOverDialog.setTitle(title);
    }

    JButton getExitButton() {
        return exitButton;
    }

    JButton getNewGameButton() {
        return newGameButton;
    }

    void closeDialog() {
        this.gameOverDialog.dispose();
    }

    void setSmile(ImageIcon smile) {
        this.smile.setIcon(smile);
    }

    private void initGameOverDialog() {
        gameOverDialog.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.NORTH;
        c1.gridx = 1;
        c1.gridy = 0;
        c1.insets = new Insets(0, 0, 15, 0);
        gameOverDialog.add(smile, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 4;
        c2.fill = GridBagConstraints.BOTH;
        c2.anchor = GridBagConstraints.CENTER;
        c2.insets = new Insets(0, 10, 0, 0);
        gameOverDialog.add(newGameButton, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 2;
        c3.gridy = 4;
        c3.weightx = 3;
        c3.fill = GridBagConstraints.BOTH;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 5, 0, 10);
        gameOverDialog.add(exitButton, c3);
    }
}
