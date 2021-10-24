package com.company.GUI.OldUnusedPages;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    public HomePage() {
//        JTextField textField = new JTextField("Enter Name");

        JPanel ButtonHolder = new JPanel();
        JButton EditRecords = new JButton("Edit records");
        EditRecords.addActionListener(e -> {
        });
        JButton ViewProducts = new JButton("View records");
        ViewProducts.addActionListener(e -> {
            new SetPage("records");
        });

        ButtonHolder.setLayout(new GridLayout(1, 2));
        ButtonHolder.add(EditRecords);
        ButtonHolder.add(ViewProducts);


        setLayout(new BorderLayout());
        add(ButtonHolder, BorderLayout.CENTER);
    }
}
