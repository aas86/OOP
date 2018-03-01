package ru.academITschool.alaev.gui;


import ru.academITschool.alaev.controller.Controller;
import ru.academITschool.alaev.interfaces.Minesweeper;
import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.Move;
import ru.academITschool.alaev.model.PlayingField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrameView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final JFrame mainFrame = new JFrame("Minesweeper");
    private final JDialog gameOverDialog = new JDialog(mainFrame);
    private JButton newGameButton = new JButton("New game");
    private JButton exitButton = new JButton("Exit");
    private JLabel smile = new JLabel();
    private final ImageIcon bombIcon = new ImageIcon("MineSweeper\\images\\bombImage.png");
    private final ImageIcon oneIcon = new ImageIcon("MineSweeper\\images\\oneImage.png");
    private final ImageIcon twoIcon = new ImageIcon("MineSweeper\\images\\twoImage.png");
    private final ImageIcon threeIcon = new ImageIcon("MineSweeper\\images\\threeImage.png");
    private final ImageIcon sadSmile = new ImageIcon("MineSweeper\\images\\SadSmile.png");
    private final ImageIcon gladSmile = new ImageIcon("MineSweeper\\images\\GladSmile.png");
    private final int rows = 9;
    private final int columns = 9;
    private final JPanel field = new JPanel();
    private JButton[][] buttons = new JButton[rows][columns];
    private boolean gameOver = false;

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();
                initMainFrameContent();
                initGameOverDialog();
                initEvents();
                exitButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mouseClicked(e);
                        gameOverDialog.dispose();
                        mainFrame.dispose();
                    }
                });
            }
        });

    }

    @Override
    public void addViewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void showMove(PlayingField field) {
        if (field.isGameOver()) {
            gameOver = true;
            smile.setIcon(sadSmile);
            gameOverDialog.setTitle("YOU LOOSE!");
            gameOverDialog.setVisible(true);
            newGameButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    //Это момент нажатия кнопки New Game
                 //Тут нужно:
                 //  /*1*/ раздизэйблить кнопки и убрать иконки
                    for (int i = 0; i < field.getRows(); i++) {
                        for (int j = 0; j < field.getColumns(); j++) {
                            buttons[i][j].setIcon(null);
                            buttons[i][j].setEnabled(true);
                        }
                 // /*2*/ в модель передать что ход не первый
                    }
                    ViewListener controller = listeners.get(0);
                    // Почему нельзя вызвать метод getMinesweeper()?
                    // Minesweeper a = controller.getMinesweeper();


                }
            });
        } else if (field.isVictory()) {
            gameOver = true;
            smile.setIcon(gladSmile);
            gameOverDialog.setTitle("YOU WIN!");
            gameOverDialog.setVisible(true);
            newGameButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
              /*  for (int i = 0; i < field.getRows(); i++) {
                    for (int j = 0; j < field.getColumns(); j++) {
                        buttons[i][j].setIcon(null);
                        buttons[i][j].setEnabled(true);
                    }

                }*/
                    gameOver = true;
                }
            });
        }
        Cell[][] cell = field.getField();
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (cell[i][j].isOpen() && !cell[i][j].isMined()) {
                    String num = cell[i][j].mineCounterToString();
                    if (num.equals("1")) {
                        buttons[i][j].setIcon(oneIcon);
                        buttons[i][j].setDisabledIcon(oneIcon);
                        buttons[i][j].setEnabled(false);
                    } else if (num.equals("2")) {
                        buttons[i][j].setIcon(twoIcon);
                        buttons[i][j].setDisabledIcon(twoIcon);
                        buttons[i][j].setEnabled(false);
                    } else if (num.equals("3")) {
                        buttons[i][j].setIcon(threeIcon);
                        buttons[i][j].setDisabledIcon(threeIcon);
                        buttons[i][j].setEnabled(false);
                    } else {
                        buttons[i][j].setEnabled(false);
                    }
                } else if (cell[i][j].isOpen() && cell[i][j].isMined()) {
                    buttons[i][j].setIcon(bombIcon);
                    buttons[i][j].setDisabledIcon(bombIcon);
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    private void initFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(500, 500));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        gameOverDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gameOverDialog.setMinimumSize(new Dimension(250, 150));
        gameOverDialog.setLocationRelativeTo(null);

    }

    private void initMainFrameContent() {
        field.setLayout(new GridLayout(rows, columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton cell = new JButton();
                buttons[i][j] = cell;
                field.add(cell);
            }
        }
        mainFrame.setContentPane(field);
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

    private void initEvents() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int x = i;
                final int y = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        // gameOver = true;
                        for (ViewListener listener : listeners) {
                            int mines = 10;
                            listener.needMakeMove(x, y, rows, columns, mines, false, false, false);
                        }
                    }
                });
            }
        }
    }
}
