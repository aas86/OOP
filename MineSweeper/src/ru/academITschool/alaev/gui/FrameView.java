package ru.academITschool.alaev.gui;

import ru.academITschool.alaev.interfaces.View;
import ru.academITschool.alaev.interfaces.ViewListener;
import ru.academITschool.alaev.model.PlayingField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameView implements View {
    private final JFrame frame = new JFrame("Minesweeper");
    private final int rows = 9;
    private final int columns = 9;
    private final JPanel field = new JPanel(new GridLayout(rows, columns));
    private int x;
    private int y;

    @Override
    public void startApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFrame();
                initFrameContent();
                initEvents();
            }
        });
    }

    @Override
    public void addViewListener(ViewListener listener) {

    }

    @Override
    public void showMove(PlayingField field) {

    }

    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initFrameContent() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field.add(new JButton());
            }
        }
        frame.setContentPane(field);
    }

    private void initEvents() {

        field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field.setBackground(new Color(77227722));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                field.setName("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
