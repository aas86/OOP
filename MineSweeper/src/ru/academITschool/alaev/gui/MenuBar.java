package ru.academITschool.alaev.gui;

import ru.academITschool.alaev.interfaces.ViewListener;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class MenuBar {
    private JMenuBar menuBar;
    private JMenuItem exit;
    private JMenuItem recordTable;
    private JMenuItem newGame;
    private JMenuItem settings;

    MenuBar() {
        this.menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        this.newGame = new JMenuItem("New Game");
        this.exit = new JMenuItem("Exit");
        this.recordTable = new JMenuItem("Record Table");
        this.settings = new JMenuItem("Settings");
        menu.add(newGame);
        menu.add(recordTable);
        menu.add(settings);
        menu.add(exit);
        this.menuBar.add(menu);
    }

    JMenuBar getMenuBar() {
        return menuBar;
    }


    void settingsAction(JFrame mainFrame){
    this.settings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
    this.settings.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SettingsDialog settingsDialog = new SettingsDialog();
            settingsDialog.okButtonPressed(mainFrame);
        }
    });
    }

    void exitAction(JFrame mainFrame) {
        this.exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }

    void recordTableAction() {
        this.recordTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        this.recordTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RecordTableDialog recordsDialog = new RecordTableDialog();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    void newGameAction(JButton[][] buttons, int rows, int columns, ArrayList<ViewListener> listeners) {
        this.newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
        newGame.addActionListener(e -> {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    buttons[i][j].setIcon(null);
                    buttons[i][j].setEnabled(true);
                }
            }
            // /*2*/ в модель через метод контроллера передать что первый ход
            for (ViewListener listener : listeners) {
                // FrameView говорит контроллеру, чтобы тот сказал модели, прийти в исходное состояние
                listener.needNewGame(true);
            }
        });
    }

}
