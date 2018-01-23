package gui;

import common.Convertible;
import common.View;
import common.ViewListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


import static java.awt.GridBagConstraints.CENTER;

/**
 * View с GUI
 */
public class FrameView implements View {
    /**
     * Для хранения listener'ов используется список, т.к. он позволяет добавлять и удалять элементы
     */
    private final ArrayList<ViewListener> listeners = new ArrayList<>();

    private final JFrame frame = new JFrame("Temperature converter");
    private final JTextField tfTemperature = new JTextField();
    private final JButton okButton = new JButton("OK");
    private final JLabel resultLabel = new JLabel();
    private final JComboBox<String> chooseBoxFrom = new JComboBox<>();
    private final JComboBox<String> chooseBoxTo = new JComboBox<>();
    private final static int HORIZONTAL_INSET = 10;
    private final static int VERTICAL_INSET = 5;
    private HashMap<String, Convertible> scales = new HashMap<>();

    public FrameView(Convertible[] scales) {
        for (Convertible e : scales) {
            this.scales.put(e.getName(), e);
        }
        for (String key : this.scales.keySet()) {
            chooseBoxTo.addItem(key);
            chooseBoxFrom.addItem(key);
        }
    }
    /**
     * Инициализация фрейма
     */
    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 200));

        // заставляет фрейм располагаться по центру экрана при запуске
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Инициализация содержимого фрейма
     */
    private void initContent() {
        JPanel contentPanel = new JPanel(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.gridwidth = 2;
        c1.gridheight = 1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, 0, HORIZONTAL_INSET);
        contentPanel.add(new JLabel("Enter temperature"), c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.gridwidth = 2;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.BOTH;
        c2.weightx = 1.0;
        c2.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(tfTemperature, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 1;
        c3.gridy = 5;
        c3.gridwidth = 10;
        c3.gridheight = 1;
        c3.weighty = 1.0;
        c3.weightx = 1.0;
        c3.anchor = CENTER;
        c3.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(resultLabel, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 5;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.weighty = 1.0;
        c4.anchor = GridBagConstraints.CENTER;
        c4.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(okButton, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridy = 3;
        c5.gridx = 0;
        c5.gridwidth = 2;
        c5.gridheight = 1;
        c5.anchor = GridBagConstraints.WEST;
        c5.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(chooseBoxFrom, c5);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridy = 3;
        c6.gridx = 1;
        c6.gridwidth = 2;
        c6.gridheight = 1;
        c6.anchor = GridBagConstraints.EAST;
        c6.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(chooseBoxTo, c6);

        frame.setContentPane(contentPanel);

    }

    /**
     * Инициализация обработчиков событий
     */
    private void initEvents() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperature = Double.parseDouble(tfTemperature.getText());
                    // Когда прочитали температуру, оповещаем всех подписчиков (в том числе контроллер), что
                    // мы хотим сконвертировать температуру
                    for (ViewListener listener : listeners) {
                        //noinspection SuspiciousMethodCalls
                        listener.needConvertTemperature(temperature, scales.get(chooseBoxFrom.getSelectedItem()),
                                scales.get(chooseBoxTo.getSelectedItem())); // по ключу получаю value
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Temperature must be number");
                }
            }
        });
    }

    /**
     * Запуск View
     */
    @Override
    public void startApplication() {
        // Работа с GUI идет из потока диспетчера событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initContent();
                initFrame();
                initEvents();
            }
        });
    }

    /**
     * Метод вызывается, когда контроллер переведет температуру
     */
    @Override
    public void onTemperatureConverted(double convertedTemperature) {
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setText(Double.toString(convertedTemperature));
    }

    /**
     * Добавление ViewListener'а
     *
     * @param listener listener
     */
    @Override
    public void addViewListener(ViewListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Удаление ViewListener'а
     *
     * @param listener listener
     */
    @Override
    public void removeViewListener(ViewListener listener) {
        listeners.remove(listener);
    }
}