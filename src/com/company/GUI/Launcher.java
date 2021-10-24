package com.company.GUI;
import com.company.GUI.Pages.DashBoardPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Launcher {
    private DashBoardPage dashboard = new DashBoardPage("Vehicle Catalogue");
    public Launcher() {
        //launching dashboard page which is the only page we have so far
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\logo.png");
        SetDashboardMenu();
        dashboard.setIconImage(img.getImage());
        dashboard.setPreferredSize(new Dimension(809, 500));
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.pack();
        dashboard.setVisible(true);
        dashboard.setLocationRelativeTo(null);
    }

    private void SetDashboardMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File"), edit = new JMenu("Edit"), view = new JMenu("View");
        JMenu New = new JMenu("New");

        JCheckBox search = new JCheckBox("Search", true);
        search.addItemListener(e -> dashboard.viewSearch((e.getStateChange() == ItemEvent.SELECTED)));
        JCheckBox filter = new JCheckBox("Filter", false);
        filter.addItemListener(e -> dashboard.viewFilter((e.getStateChange() == ItemEvent.SELECTED)));
        JCheckBox label = new JCheckBox("Label", true);
        label.addItemListener(e -> dashboard.viewLabel((e.getStateChange() == ItemEvent.SELECTED)));
        JMenuItem save = new JMenuItem("Save");
        JMenuItem Import = new JMenuItem("Import");
        JMenuItem Export = new JMenuItem("Export");
        JMenuItem record = new JMenuItem("Record");
        JMenuItem deleteAll = new JMenuItem("Delete All");

        New.add(record);
        file.add(New);
        file.add(save);
        file.add(Import);
        file.add(Export);
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
