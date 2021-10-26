package com.company.GUI.Pages;

import com.company.GUI.CustomElements.HintTextField;
import com.company.GUI.CustomTableCells.ButtonEditor;
import com.company.GUI.CustomTableCells.CheckBoxEditor;
import com.company.GUI.CustomTableCells.JTableRenderer;
import com.company.Records;
import com.company.vehicle;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;

public class DashBoardPage extends JFrame {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel searchLabel = new JLabel("Search: ");
    private HintTextField searchField = new HintTextField("Enter Name Or ...");// a custom class used to show the hint when the jtext field is empty

    public DashBoardPage(String title) {
        setTitle(title);
        setLayout(new GridBagLayout());
        addSearch();
        addTable();
    }

    public void viewSearch(boolean view) {
        if (view) {
            addSearch();
        } else {
            removeSearch();
        }
    }

    public void viewLabel(boolean view) {
        if (view) {
            addLabel();
        } else {
            removeLabel();
        }
    }

    public void viewFilter(boolean view) {
        if (view) {
            addFilter();
        } else {
            removeFilter();
        }
    }

    private void addSearch() {
        SwingUtilities.invokeLater(() -> {
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 0, 0);
            add(searchLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 5, 5, 5);
            add(searchField, gbc);

            invalidate();
            validate();
        });

    }

    private void removeSearch() {
        SwingUtilities.invokeLater(() -> {
            remove(searchLabel);
            remove(searchField);
            invalidate();
            validate();
        });
    }

    private void addTable() {
        ArrayList<vehicle> records = Records.getRecords();
        Object data[][] = new Object[records.size()][7];
        for (int i = 0; i < records.size(); i++) {
            data[i] = records.get(i).getObject();
        }

        String columnTitle[] = {"View", "Category", "Name", "Brand", "Date Of Production", "ID Number", "Availability"};
        JTable jt = new JTable(data, columnTitle) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                if (column == 0) {
                    tableColumn.setPreferredWidth(20);
                } else {
                    tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                }
                return component;
            }
        };
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnTitle.length; i++) {
            jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jt.getColumn("View").setCellEditor(new ButtonEditor());
        jt.getColumn("View").setCellRenderer(new JTableRenderer(jt.getDefaultRenderer(JButton.class)));
        jt.getColumn("Availability").setCellEditor(new CheckBoxEditor());
        jt.getColumn("Availability").setCellRenderer(new JTableRenderer(jt.getDefaultRenderer(JCheckBox.class)));
        jt.setUpdateSelectionOnSort(true);
        jt.setRowSelectionAllowed(true);
//        jt.setColumnSelectionAllowed(false);
        jt.setAutoCreateRowSorter(true);
        jt.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(jt);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(contentPane, gbc);
    }

    private void addFilter() {

    }

    private void removeFilter() {

    }

    private void addLabel() {

    }

    private void removeLabel() {

    }

}
