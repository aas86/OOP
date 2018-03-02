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
                initEvents();
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
        GameOverDialog gameOverDialog = new GameOverDialog();
        if (field.isGameOver()) { // Отрисовка, если проиграли
            gameOver = true;
            gameOverDialog.setSmile(sadSmile);
            gameOverDialog.setTitle("You Loose!");
            gameOverDialog.setVisible();
        } else if (field.isVictory()) { // Отрисовка, если выиграли
            gameOver = true;
            gameOverDialog.setSmile(gladSmile);
            gameOverDialog.setTitle("You Win!");
            gameOverDialog.setVisible();
        }
        if (gameOver) {
            gameOverDialog.getExitButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    mainFrame.dispose();
                    gameOverDialog.closeDialog();
                }
            });
            gameOverDialog.getNewGameButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    //Это момент нажатия кнопки New Game
                    //Тут нужно:
                    //  /*1*/ раздизэйблить все кнопки и убрать иконки
                    for (int i = 0; i < field.getRows(); i++) {
                        for (int j = 0; j < field.getColumns(); j++) {
                            buttons[i][j].setIcon(null);
                            buttons[i][j].setEnabled(true);
                        }
                    }
                    // /*2*/ в модель через метод контроллера передать что первый ход
                    for (ViewListener listener : listeners) {
                        // FrameView говорит контроллеру, чтобы тот сказал модели, прийти в исходное состояние
                        listener.needNewGame(true);
                    }
                    gameOverDialog.closeDialog();
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

    private void initEvents() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int x = i;
                final int y = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
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
