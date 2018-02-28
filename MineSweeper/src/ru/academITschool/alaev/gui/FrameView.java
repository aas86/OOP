package ru.academITschool.alaev.gui;

import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.PlayingField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrameView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final JFrame mainFrame = new JFrame("Minesweeper");
    private final JFrame gameOverFrame = new JFrame("Game Over");
    private JButton newGameButton = new JButton("New game");
    private JButton exitButton = new JButton("Exit");
    private JLabel smile = new JLabel();
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
                initGameOverFrame();
                initEvents();
                exitButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mouseClicked(e);
                        gameOverFrame.dispose();
                        mainFrame.dispose();
                    }
                });
            }
        });
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
                        gameOver = true;
                        for (ViewListener listener : listeners) {
                            int mines = 10;
                            listener.needMakeMove(x, y, rows, columns, mines, false, false, false);
                        }
                    }
                });
            }
        }
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
            ImageIcon sadSmile = new ImageIcon("images\\SadSmile.png");
            smile.setIcon(sadSmile);
            gameOverFrame.setTitle("YOU LOOSE!");
            gameOverFrame.setVisible(true);
        } else if (field.isVictory()) {
            gameOver = true;
            ImageIcon gladSmile = new ImageIcon("images\\GladSmile.png");
            smile.setIcon(gladSmile);
            gameOverFrame.setTitle("YOU WIN!");
            gameOverFrame.setVisible(true);
        }

        ImageIcon icon = new ImageIcon("images\\bombImage.png");
        ImageIcon bombIcon = new ImageIcon("images\\bombImage.png");
        ImageIcon oneIcon = new ImageIcon("images\\oneImage.png");
        ImageIcon twoIcon = new ImageIcon("images\\twoImage.png");
        ImageIcon threeIcon = new ImageIcon("images\\threeImage.png");
        Cell[][] cell = field.getField();
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (cell[i][j].isOpen() && !cell[i][j].isMined()) {
                    String num = cell[i][j].mineCounterToString();
                    if (num.equals("1")) {
                        buttons[i][j].setIcon(oneIcon);
                        buttons[i][j].setEnabled(false);
                        buttons[i][j].setDisabledIcon(oneIcon);
                    } else if (num.equals("2")) {
                        buttons[i][j].setIcon(twoIcon);
                        buttons[i][j].setEnabled(false);
                        buttons[i][j].setDisabledIcon(twoIcon);
                    } else if (num.equals("3")) {
                        buttons[i][j].setIcon(threeIcon);
                        buttons[i][j].setEnabled(false);
                        buttons[i][j].setDisabledIcon(threeIcon);
                    } else {
                        buttons[i][j].setEnabled(false);
                    }
                } else if (cell[i][j].isOpen() && cell[i][j].isMined()) {
                    // Вот чё к чему???? Сначала просто иконку ставлю на кнопку, потом дизэйблю кнопку, а потом
                    // задизэйблиной ставлю ту же самую иконку, только тогда она цветная становится.
                    // А если задизэйблиной кнопке поставить иконку методом setDisabledIcon(), то вообще ничего не
                    // будет. Бред какой-то.
                    buttons[i][j].setIcon(bombIcon);
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setDisabledIcon(bombIcon);
                }
            }
        }
    }

    private void initFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(500, 500));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        gameOverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameOverFrame.setMinimumSize(new Dimension(250, 150));
        gameOverFrame.setLocationRelativeTo(null);

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

    private void initGameOverFrame() {
        gameOverFrame.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.NORTH;
        c1.gridx = 1;
        c1.gridy = 0;
        c1.insets = new Insets(0, 0, 15, 0);
        gameOverFrame.add(smile, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 4;
        c2.fill = GridBagConstraints.BOTH;
        c2.anchor = GridBagConstraints.CENTER;
        c2.insets = new Insets(0, 0, 0, 5);
        gameOverFrame.add(newGameButton, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 2;
        c3.gridy = 4;
        c3.fill = GridBagConstraints.BOTH;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 5, 0, 0);
        gameOverFrame.add(exitButton, c3);
    }
}
