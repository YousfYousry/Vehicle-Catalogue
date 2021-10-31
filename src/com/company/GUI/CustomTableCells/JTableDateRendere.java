package com.company.GUI.CustomTableCells;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.SimpleDateFormat;

public class JTableDateRendere  extends JLabel implements TableCellRenderer {
    private SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int col) {
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, col);

        String s = "";
        if (col == 4) {
            s = dFormat.format(value);
            c = renderer.getTableCellRendererComponent(table, s,
                    isSelected, hasFocus, row, col);
            ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
        }
        return c;
    }
}
