import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    private JFrame window;

    public void create() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

         /*   try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {

            }*/

                JTextField field = new JTextField(10); // сюда вводят температуру
                JLabel labelCelsius = new JLabel("Градусов по цельсию", JLabel.CENTER);  // метка с надписью Цельсий
                JLabel labelFahrenheit = new JLabel("Градусов по Фаренгейту", JLabel.CENTER);    // метка с надписью Фаренгейт
                JLabel labelKelvin = new JLabel("Градусов по Кельвину", JLabel.CENTER);        // метка с надписью Кельвин
                JButton convertButton = new JButton(); // кнопка конвертирования

                convertButton.setText("Конвертировать");
                //convertButton.setSize(10,15);
                JFrame window = new JFrame("Перевод температур");
                window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                window.setSize(320, 150);
                window.setVisible(true);
                window.setLayout(new GridLayout());
                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel(new GridLayout(3,1));
                panel1.add(field);
                panel1.add(convertButton);

                panel2.add(labelCelsius);
                panel2.add(labelFahrenheit);
                panel2.add(labelKelvin);
                window.add(panel1, BorderLayout.WEST);
                window.add(panel2, BorderLayout.SOUTH);

                field.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = field.getText();
                        Double temperature = Double.parseDouble(temp);
                    }
                });
            }
        });
    }

}
