package com.company.GUI;

import com.company.GUI.Menus.SetDashboardMenu;
import com.company.GUI.Pages.DashBoardPage;
import javax.swing.*;
import java.awt.*;

public class Launcher {
//    static AnimatingCardLayout animation;
//    static JPanel mainPanel;
    public static JFrame jframe;
    public Launcher() {
//        mainPanel = new JPanel();
//        animation = new AnimatingCardLayout(new RadialAnimation());
//        mainPanel.setLayout(animation);
//        //setPages
//        mainPanel.add(new ViewRecordsPage(), "records");
//        mainPanel.add(new ViewRecordsPage(), "records");

        ImageIcon img = new ImageIcon(System.getProperty("user.dir")+"\\assets\\logo.png");
        jframe = new DashBoardPage("Vehicle Catalogue");
        new SetDashboardMenu();
        jframe.setIconImage(img.getImage());
//        jframe.setLayout(new BorderLayout());
//        jframe.add(new DashBoardPage(), BorderLayout.NORTH);
        jframe.setPreferredSize(new Dimension(500, 500));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
    }
}
