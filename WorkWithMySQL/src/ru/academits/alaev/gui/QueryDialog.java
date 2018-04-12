package ru.academits.alaev.gui;

import ru.academits.alaev.model.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

class QueryDialog {
    private JDialog dialog = new JDialog();
    private JScrollPane scrollPane;
    private JTable table;
    private JButton filter = new JButton("Фильтр");


    QueryDialog(ArrayList<Data> result) {
        initTable(result);
        initQueryDialog();
        dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(300, 200));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    JButton getFilterButton() {
        return filter;
    }

    public void close() {
        this.dialog.dispose();
    }

    private void initTable(ArrayList<Data> result) {
        scrollPane = new JScrollPane(table);
        String[] columnNames = {"id", "Names"};
        Object[][] data = new Object[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            Data element = result.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    data[i][j] = element.getId();
                } else {
                    data[i][j] = element.getName();
                }
            }
        }

        TableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
    }

    private void initQueryDialog() {
        dialog.setLayout(new BorderLayout());
        /*dialog.setLayout(new GridBagLayout());
mainFrame.add(field, BorderLayout.CENTER);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.NONE;
        c1.gridx = 0;
        c1.gridy = 1;
        c1.gridwidth = 5;
        c1.gridheight = 5;
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = new Insets(10, 0, 10, 10);
        dialog.add(scrollPane, c1);*/

        GridBagConstraints c2 = new GridBagConstraints();

        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(10, 0, 10, 10);
        dialog.add(filter, BorderLayout.PAGE_START);
        dialog.add(scrollPane, BorderLayout.CENTER);
    }
}

