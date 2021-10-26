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
    private HintTextField searchField;// a custom class used to show the hint when the jtext field is empty

    public DashBoardPage(String title) {
        setTitle(title);
        setLayout(new GridBagLayout());
        searchField = new HintTextField("Enter Name Or ...", addTable());
        addSearch();
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

    private JTable addTable() {
        ArrayList<vehicle> records = Records.getRecords();
        Object data[][] = new Object[records.size()][7];
        for (int i = 0; i < records.size(); i++) {
            data[i] = records.get(i).getObject();
        }

        String columnTitle[] = {"View", "Category", "Name", "Brand", "Date Of Production", "ID Number", "Availability"};
        JTable jTable = new JTable(data, columnTitle) {
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
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnTitle.length; i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jTable.getColumn("View").setCellEditor(new ButtonEditor());
        jTable.getColumn("View").setCellRenderer(new JTableRenderer(jTable.getDefaultRenderer(JButton.class)));
        jTable.getColumn("Availability").setCellEditor(new CheckBoxEditor());
        jTable.getColumn("Availability").setCellRenderer(new JTableRenderer(jTable.getDefaultRenderer(JCheckBox.class)));
        jTable.setUpdateSelectionOnSort(true);
        jTable.setRowSelectionAllowed(true);
        jTable.setColumnSelectionAllowed(false);
        jTable.setAutoCreateRowSorter(true);
        jTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(jTable);
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
        return jTable;
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
