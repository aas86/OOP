package ru.academITschool.alaev.gui;


import javax.swing.*;
import java.awt.*;

class GameOverDialog {
    private JLabel smile = new JLabel();
    private JButton newGameButton = new JButton("Новая игра");
    private JButton exitButton = new JButton("Выход");
    private JDialog gameOverDialog = new JDialog();

    GameOverDialog() {
        initGameOverDialog();
        gameOverDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gameOverDialog.setMinimumSize(new Dimension(250, 150));
        gameOverDialog.setLocationRelativeTo(null);

    }

    void makeWinDialog(ImageIcon gladSmile){
        this.smile.setIcon(gladSmile);
        this.gameOverDialog.setTitle("Вы выиграли!");
        this.gameOverDialog.setVisible(true);
    }

    void makeLooseDialog(ImageIcon sadSmile){
        this.smile.setIcon(sadSmile);
        this.gameOverDialog.setTitle("Вы проиграли!");
        this.gameOverDialog.setVisible(true);
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
