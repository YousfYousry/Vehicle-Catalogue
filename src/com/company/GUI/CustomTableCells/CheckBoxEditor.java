package com.company.GUI.CustomTableCells;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class CheckBoxEditor extends AbstractCellEditor implements TableCellEditor {
    private JCheckBox checkBox;

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // in your case e.g. a JButton
        checkBox = (JCheckBox) value;
        return checkBox;
    }

    /**
     * This method returns the value showing after the editing of the table!
     * Here  you can return every object you want ... the cell renderer should
     * handle the object you return ...
     *
     * @return Object
     */
    public Object getCellEditorValue() {
        return checkBox;
    }

    // Methods should not be overriden
    public void cancelCellEditing() {
        super.cancelCellEditing();
    }

    // like above
    public boolean stopCellEditing() {
        super.stopCellEditing();
        return true;
    }
}

