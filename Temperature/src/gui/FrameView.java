package gui;

import common.View;
import common.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private final JLabel resultLabel = new JLabel("Result");
    private final JComboBox<String> chooseBox = new JComboBox<>();
    private Object item;

    private final static int HORIZONTAL_INSET = 10;
    private final static int VERTICAL_INSET = 5;

    /**
     * Инициализация фрейма
     */
    private void initFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 200));

        // заставляет фрейм располагаться по центру экрана при запуске
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    /**
     * Инициализация содержимого фрейма
     */
    private void initContent() {
        JPanel contentPanel = new JPanel(new GridBagLayout());

        Insets insets = new Insets(0, HORIZONTAL_INSET, 0, HORIZONTAL_INSET);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        c1.gridwidth = 2;
        c1.gridheight = 1;
        c1.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        c1.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, 5, HORIZONTAL_INSET);
        contentPanel.add(new JLabel("Enter temperature"), c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        c2.gridwidth = 2;
        c2.gridheight = 1;
        c2.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 1.0;
        c2.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET);
        contentPanel.add(tfTemperature, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 3;
        c3.gridwidth = 1;
        c3.gridheight = 1;
        c3.weighty = 1.0;
        c3.weightx = 1.0;
        c3.anchor = GridBagConstraints.NORTHWEST;
        c3.insets = insets;

        contentPanel.add(resultLabel, c3);


        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 1;
        c4.gridy = 7;
        c4.gridwidth = 1;
        c4.gridheight = 1;
        c4.weighty = 1.0;
        c4.anchor = GridBagConstraints.NORTHEAST;
        c4.insets = insets;
        contentPanel.add(okButton, c4);

        frame.setContentPane(contentPanel);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = c6.gridy = 0;
        c6.gridwidth = 20;
        c6.gridheight = 2;
        c6.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        c6.insets = new Insets(VERTICAL_INSET, HORIZONTAL_INSET, 0, HORIZONTAL_INSET);
        String[] items = {
                "Choose Scales To Convert",
                "Celsius to Fahrenheit",
                "Celsius to Kelvin",
                "Fahrenheit to Celsius",
                "Fahrenheit to Kelvin",
                "Kelvin to Celsius",
                "Kelvin to Fahrenheit"
        };
        for (String item : items) {
            chooseBox.addItem(item);
        }
        contentPanel.add(chooseBox);
    }


    /**
     * Инициализация обработчиков событий
     */


    private void initEvents() {
        chooseBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item = chooseBox.getSelectedItem();
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperature = Double.parseDouble(tfTemperature.getText());
                    // Когда прочитали температуру, оповещаем всех подписчиков (в том числе контроллер), что
                    // мы хотим сконвертировать температуру
                    for (ViewListener listener : listeners) {
                        listener.needConvertTemperature(temperature, item);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Temperature must be number");
                } catch (NullPointerException ex) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Choose scale to convert");
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

    /**
     * Очистка ресурсов View
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        frame.setVisible(false);
    }
}