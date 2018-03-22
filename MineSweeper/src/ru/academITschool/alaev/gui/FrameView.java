package ru.academITschool.alaev.gui;

import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.Cell;
import ru.academITschool.alaev.model.PlayingField;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class FrameView implements View {
    private final ArrayList<ViewListener> listeners = new ArrayList<>();
    private final JFrame mainFrame = new JFrame("Minesweeper");
    private final ImageIcon bombIcon = new ImageIcon("MineSweeper\\images\\bombImage.png");
    private final ImageIcon oneIcon = new ImageIcon("MineSweeper\\images\\oneImage.png");
    private final ImageIcon twoIcon = new ImageIcon("MineSweeper\\images\\twoImage.png");
    private final ImageIcon threeIcon = new ImageIcon("MineSweeper\\images\\threeImage.png");
    private final ImageIcon fourIcon = new ImageIcon("MineSweeper\\images\\fourImage.png");
    private final ImageIcon fiveIcon = new ImageIcon("MineSweeper\\images\\fiveImage.png");
    private final ImageIcon sadSmile = new ImageIcon("MineSweeper\\images\\SadSmile.png");
    private final ImageIcon gladSmile = new ImageIcon("MineSweeper\\images\\GladSmile.png");
    private final ImageIcon flagIcon = new ImageIcon("MineSweeper\\images\\flag.png");
    private final ImageIcon questionIcon = new ImageIcon("MineSweeper\\images\\questionImage.png");
    private final int rows = 9;
    private final int columns = 9;
    private final JPanel field = new JPanel();
    private JButton[][] buttons = new JButton[rows][columns];
    //private boolean gameOver = false;

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
        boolean gameOver = false;
        if (field.isGameOver()) { // Отрисовка диалогового окна, если проиграли
            gameOver = true;
            gameOverDialog.setSmile(sadSmile);
            gameOverDialog.setTitle("You Loose!");
            gameOverDialog.setVisible();
        } else if (field.isVictory()) { // Отрисовка диалогового окна, если выиграли
            gameOver = true;
            // Это момент выигрыша. Тут нужно проверить, стоит ли вызывать диалоговое окно для ввода
            // имени или нет. Для этого вызвать через конструктор метод checkNeedWriteRecord и если true, то записать
            // в нужное место в файл рекорд.
            EnterNameDialog enterNameDialog = new EnterNameDialog(field.getGameTime());
            enterNameDialog.getOkButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    String name = enterNameDialog.getName().getText();
                    for (ViewListener listener : listeners) {
                        try {
                            listener.needWriteRecord(field.getGameTime(),name);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        enterNameDialog.closeDialog();
                    }
                }
            });
            gameOverDialog.setSmile(gladSmile);
            gameOverDialog.setTitle("You Win!");
            gameOverDialog.setVisible();
        }
        if (gameOver) { // Обработка нажатия кнопок "New Game" и "Exit"
            gameOverDialog.getExitButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    //Это момент нажатия кнопки "Exit"
                    mainFrame.dispose();
                    gameOverDialog.closeDialog();

                }
            });
            gameOverDialog.getNewGameButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    //Это момент нажатия кнопки "New Game"
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
                    switch (num) {
                        case "1":
                            buttons[i][j].setIcon(oneIcon);
                            buttons[i][j].setDisabledIcon(oneIcon);
                            buttons[i][j].setEnabled(false);
                            break;
                        case "2":
                            buttons[i][j].setIcon(twoIcon);
                            buttons[i][j].setDisabledIcon(twoIcon);
                            buttons[i][j].setEnabled(false);
                            break;
                        case "3":
                            buttons[i][j].setIcon(threeIcon);
                            buttons[i][j].setDisabledIcon(threeIcon);
                            buttons[i][j].setEnabled(false);
                            break;
                        case "4":
                            buttons[i][j].setIcon(fourIcon);
                            buttons[i][j].setDisabledIcon(fourIcon);
                            buttons[i][j].setEnabled(false);
                            break;
                        case "5":
                            buttons[i][j].setIcon(fiveIcon);
                            buttons[i][j].setDisabledIcon(fiveIcon);
                            buttons[i][j].setEnabled(false);
                        default:
                            buttons[i][j].setEnabled(false);
                            break;
                    }
                } else if (cell[i][j].isOpen() && cell[i][j].isMined()) {
                    buttons[i][j].setIcon(bombIcon);
                    buttons[i][j].setDisabledIcon(bombIcon);
                    buttons[i][j].setEnabled(false);
                } else if (cell[i][j].isFlagged()) {
                    buttons[i][j].setIcon(flagIcon);
                } else if (cell[i][j].isQuestioned()) {
                    buttons[i][j].setIcon(questionIcon);
                } else {
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].setIcon(null);
                }
            }
        }
    }

   /* private void recordTable(long gameTime) throws FileNotFoundException {
       // RecordTable dialog = new RecordTable(gameTime);
       // EnterNameDialog enterNameDialog = new EnterNameDialog(gameTime);
       // Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"));
            if (!scanner.hasNextLine()) { // Если таблица рекордов пустая
                RecordTable recordTable = new RecordTable(gameTime, enterNameDialog);
            }  else if (scanner.hasNextLine()){ // Если таблица рекордов не пустая и нужно куда-то вставить результат

            }
        }*/


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
                       // boolean isFlagged = false;
                        boolean rightButtonClick = false;
                        boolean wheelClick = false;
                        //   System.out.println(e.getClickCount());
                        super.mousePressed(e);
                        // System.out.println("Время начала игры " + start);
                        System.out.println("Нажата кнопка № " + e.getButton());
                        //   System.out.println(MouseInfo.getNumberOfButtons());
                        System.out.println("Координата x " + x);
                        System.out.println("Координата y " + y);
                        if (e.getButton() == 3) { // Если нажали правой кнопкой мыши
                            rightButtonClick = true;
                        } else if (e.getButton() == 2) { // Если нажали колёсиком мыши
                            wheelClick = true;
                        }
                        for (ViewListener listener : listeners) {
                            int mines = 10;
                            listener.needMakeMove(x, y, rows, columns, mines, rightButtonClick, wheelClick);
                        }

                    }
                });
            }
        }
    }
}
