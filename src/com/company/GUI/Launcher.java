package com.company.GUI;

import com.company.GUI.Pages.DashBoardPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Launcher {
    private DashBoardPage dashboard = new DashBoardPage("Vehicle Catalogue");
    private static JCheckBox search = new JCheckBox("Search", true);
    public static JCheckBox filter = new JCheckBox("Filter", false);
    private static JCheckBox label = new JCheckBox("Label", true);

    public Launcher() {
        //launching dashboard page which is the only page we have so far
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\logo.png");
        SetDashboardMenu();
        dashboard.setIconImage(img.getImage());
        dashboard.setPreferredSize(new Dimension(809, 500));//500 x 1.618 = 809 (1.618 the golden number, number of beauty)
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.pack();
        dashboard.setVisible(true);
        dashboard.setLocationRelativeTo(null);
    }

    private void SetDashboardMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File"), edit = new JMenu("Edit"), view = new JMenu("View");
        JMenu New = new JMenu("New");

        search.addItemListener(e -> dashboard.viewSearch((e.getStateChange() == ItemEvent.SELECTED)));
        filter.addItemListener(e -> dashboard.viewFilter((e.getStateChange() == ItemEvent.SELECTED)));
        label.addItemListener(e -> dashboard.viewLabel((e.getStateChange() == ItemEvent.SELECTED)));
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As...");
        JMenuItem Import = new JMenuItem("Import");
        JMenuItem record = new JMenuItem("Record");
        JMenuItem deleteAll = new JMenuItem("Delete All");

        New.add(record);
        file.add(New);
        file.add(save);
        file.add(saveAs);
        file.add(Import);
        edit.add(deleteAll);
        view.add(search);
        view.add(filter);
        view.add(label);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        dashboard.setJMenuBar(menuBar);
    }
}
