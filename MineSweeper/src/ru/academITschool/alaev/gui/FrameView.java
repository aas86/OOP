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
    private final JFrame frame = new JFrame("Minesweeper");
    private final int rows = 9;
    private final int columns = 9;
    private final JPanel field = new JPanel();
    private JButton[][] buttons = new JButton[rows][columns];
    private boolean gameOver = false;
    private int x;
    private int y;

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();
                initFrameContent();
                // initEvents();
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
            frame.setBackground(Color.red);
            gameOver = true;
        }
        Cell[][] cell = field.getField();
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (cell[i][j].isOpen() && !cell[i][j].isMined()) {
                    String num = cell[i][j].mineCounterToString();
                    buttons[i][j].setText(num);

                    // Не понимаю, как добраться до кнопки с координатой i, j
                } else if (cell[i][j].isOpen() && cell[i][j].isMined()) {

                }
            }
        }

    }

    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrameContent() {
        field.setLayout(new GridLayout(rows, columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int x = i;
                final int y = j;
                JButton cell = new JButton();
                buttons[i][j] = cell;
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        for (ViewListener listener : listeners) {
                            int mines = 10;
                            listener.needMakeMove(x, y, rows, columns, mines, false, false, false);
                        }

                    }
                });
                field.add(cell);
            }
        }

        frame.setContentPane(field);

    }
}
