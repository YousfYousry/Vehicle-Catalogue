package com.company.GUI.CustomTableCells;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class JTableRenderer implements TableCellRenderer {
    private TableCellRenderer defaultRenderer;

    public JTableRenderer(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Component)

            return (Component) value;
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}