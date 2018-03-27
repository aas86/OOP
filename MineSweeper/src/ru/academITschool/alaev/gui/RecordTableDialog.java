package ru.academITschool.alaev.gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RecordTableDialog {
    private JDialog recordsDialog = new JDialog();
    // private final JButton okButton = new JButton("OK");
    private JLabel firstPlace = new JLabel();
    private JLabel secondPlace = new JLabel();
    private JLabel thirdPlace = new JLabel();
    private JLabel fourthPlace = new JLabel();
    private JLabel fifthPlace = new JLabel();
    private String[] string = new String[5];


    RecordTableDialog() throws FileNotFoundException {
        initRecordTableDialog();
        getResultsFromFile();
        recordsDialog.setTitle("Record Table");
        addRecords();
        recordsDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        recordsDialog.setMinimumSize(new Dimension(250, 250));
        recordsDialog.setLocationRelativeTo(null);
        recordsDialog.setVisible(true);

    }

    private void addRecords() {
        if (!(string[0] == null)) {
            firstPlace.setText("1.  " + string[0]);
        }
        if (!(string[1] == null)) {
            secondPlace.setText("2.  " + string[1]);
        }
        if (!(string[2] == null)) {
            thirdPlace.setText("3.  " + string[2]);
        }
        if (!(string[3] == null)) {
            fourthPlace.setText("4.  " + string[3]);
        }
        if (!(string[4] == null)) {
            fifthPlace.setText("5.  " + string[4]);
        }
    }

    private void getResultsFromFile() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("MineSweeper\\recordTable.txt"))) {
            int i = 0;
            String[] tempString = new String[5];
            while (scanner.hasNextLine()) {
                tempString[i] = scanner.nextLine();
                Pattern pattern = Pattern.compile("^(.*?)(\\|)(.*?)(\\|)(.*)");
                Matcher matcher = pattern.matcher(tempString[i]);
                matcher.find();
                string[i] = matcher.group(1) + " " + matcher.group(3) + "" + matcher.group(5);
                i++;
            }
        }
    }

    private void initRecordTableDialog() {
        recordsDialog.setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.NONE;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(0, 0, 20, 0);
        recordsDialog.add(firstPlace, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        c2.fill = GridBagConstraints.NONE;
        c2.anchor = GridBagConstraints.CENTER;
        c2.insets = new Insets(0, 0, 20, 0);
        recordsDialog.add(secondPlace, c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 4;
        c3.fill = GridBagConstraints.NONE;
        c3.anchor = GridBagConstraints.CENTER;
        c3.insets = new Insets(0, 0, 20, 0);
        recordsDialog.add(thirdPlace, c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 0;
        c4.gridy = 6;
        c4.fill = GridBagConstraints.NONE;
        c4.anchor = GridBagConstraints.CENTER;
        c4.insets = new Insets(0, 0, 20, 0);
        recordsDialog.add(fourthPlace, c4);

        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 0;
        c5.gridy = 8;
        c5.fill = GridBagConstraints.NONE;
        c5.anchor = GridBagConstraints.CENTER;
        c5.insets = new Insets(0, 0, 20, 0);
        recordsDialog.add(fifthPlace, c5);
    }
}
