package com.company.GUI.CustomElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class HintTextField extends JTextField {

    Font gainFont = new Font("Tahoma", Font.PLAIN, 14);
    Font lostFont = new Font("Tahoma", Font.ITALIC, 14);
//    TitledBorder titledBorder;
    Border loweredbevel;

    public HintTextField(final String hint) {//
        loweredbevel = BorderFactory.createLoweredBevelBorder();
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