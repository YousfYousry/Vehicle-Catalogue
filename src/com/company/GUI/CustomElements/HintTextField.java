package com.company.GUI.CustomElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HintTextField extends JTextField {

    private Font gainFont = new Font("Tahoma", Font.PLAIN, 14);
    private Font lostFont = new Font("Tahoma", Font.ITALIC, 14);

    public HintTextField(final String hint,final JTable jTable) {//
        RowSorter<? extends TableModel> rs = jTable.getRowSorter();
        if (rs == null) {
            jTable.setAutoCreateRowSorter(true);
            rs = jTable.getRowSorter();
        }

        TableRowSorter<? extends TableModel> rowSorter =
                (rs instanceof TableRowSorter) ? (TableRowSorter<? extends TableModel>) rs : null;

        if (rowSorter == null) {
            throw new RuntimeException("Cannot find appropriate rowSorter: " + rs);
        }

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            private void update() {
                String text = getText();
                if (text.trim().length() == 0||text.equals(hint)) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1, 2, 3, 4, 5));
                }
            }
        });


        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
//        titledBorder = BorderFactory.createTitledBorder(
//                loweredbevel, title);
//        titledBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
        setBorder(loweredbevel);
//        setBackground(Color.gray);
//
        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint)|| getText().length()==0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }
}