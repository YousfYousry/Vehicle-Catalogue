package com.company.GUI.Menus;

import javax.swing.*;

import static com.company.GUI.Launcher.jframe;

public class SetDashboardMenu extends JMenuBar {

    public SetDashboardMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file  = new JMenu("File"), edit  = new JMenu("Edit"), sort = new JMenu("Sort"), filter = new JMenu("Filter"), view = new JMenu("View");
        JMenu i10 = new JMenu("New");

       JMenuItem i1 = new JMenuItem("Add Vehicle");
       JMenuItem i2 = new JMenuItem("Name");
       JMenuItem i3 = new JMenuItem("Price");
       JMenuItem i4 = new JMenuItem("Large Icons");
       JMenuItem i5 = new JMenuItem("Small Icons");
       JMenuItem i6 = new JMenuItem("Filter");
       JMenuItem i7 = new JMenuItem("Import");
       JMenuItem i8 = new JMenuItem("Export");
       JMenuItem i9 = new JMenuItem("Save");
       JMenuItem i11 = new JMenuItem("Record");
       JMenuItem i12 = new JMenuItem("Delete All");
//       JMenuItem i13 = new JMenuItem("Auto Save");

        i1.addActionListener(e -> {});
        i10.add(i11);
        file.add(i10);
        file.add(i9);
        file.add(i7);
        file.add(i8);
        edit.add(i12);
//        edit.add(i13);
        sort.add(i2);
        sort.add(i3);
        view.add(i4);
        view.add(i5);

        menuBar.add(file);
        menuBar.add(edit);
//        menuBar.add(sort);
        menuBar.add(filter);
        menuBar.add(view);
        jframe.setJMenuBar(menuBar);

    }

    public static void removeMenu(){
        jframe.setJMenuBar(null);
    }
}
