package com.company.GUI;

import com.company.Air.Helicopter;
import com.company.Air.Plane;
import com.company.Air.Rocket;
import com.company.GUI.CustomElements.InsertRecord;
import com.company.GUI.Pages.DashBoardPage;
import com.company.Land.Bike;
import com.company.Land.Car;
import com.company.Land.Train;
import com.company.Records;
import com.company.Water.Kayak;
import com.company.Water.ShippingTanker;
import com.company.Water.Submarine;
import com.company.vehicle;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Launcher {
    public static DashBoardPage dashboard = new DashBoardPage("Vehicle Catalogue");
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
//        JMenuItem saveAs = new JMenuItem("Save As...");
        JMenuItem Import = new JMenuItem("Import");
        JMenuItem record = new JMenuItem("Record");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem deleteAll = new JMenuItem("Delete All");
        reset.addActionListener(e -> {
            Records.reset();
            dashboard.displayAll();
        });
        deleteAll.addActionListener(e -> {
            Records.deleteAllRecord();
            dashboard.displayAll();
        });
        save.addActionListener(e -> {
            try {
                Records.saveNewOriginal(System.getProperty("user.dir") + "\\assets\\test.txt");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
        record.addActionListener(e -> {
            Choice categoryList = new Choice();
            categoryList.add("Helicopter");
            categoryList.add("Plane");
            categoryList.add("Rocket");
            categoryList.add("Bike");
            categoryList.add("Car");
            categoryList.add("Train");
            categoryList.add("Kayak");
            categoryList.add("Shipping Tanker");
            categoryList.add("Submarine");


            JXDatePicker productionDate = new JXDatePicker();
            productionDate.setDate(Calendar.getInstance().getTime());
            productionDate.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

            InsertRecord insertRecord = new InsertRecord();
            insertRecord.setLayout(new GridLayout(2, 1));
            JPanel child1 = new JPanel();
            child1.setLayout(new GridLayout(6, 2));


            JLabel category = new JLabel("Category");
            JLabel name = new JLabel("Name");
            JTextField nameField = new JTextField("");
            JLabel brand = new JLabel("Brand");
            JTextField brandField = new JTextField("");

            JLabel production = new JLabel("Date Of Production");
            JLabel Id = new JLabel("ID Number");
            JTextField idField = new JTextField("");
            JLabel available = new JLabel("Availability");
            JCheckBox availabilityField = new JCheckBox("", true);

            child1.add(available);
            child1.add(availabilityField);

            child1.add(production);
            child1.add(productionDate);

            child1.add(category);
            child1.add(categoryList);

            child1.add(name);
            child1.add(nameField);

            child1.add(brand);
            child1.add(brandField);

            child1.add(Id);
            child1.add(idField);

            insertRecord.add(child1);
            insertRecord.add(insertRecord.getView());

            categoryList.addItemListener(s -> insertRecord.listener(s.getItem().toString()));


            int result = JOptionPane.showOptionDialog(null, insertRecord, "Insert new Record",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, new Object[]{"Enter", "Cancel"}, null);
            if (result == 0) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(productionDate.getDate());
                Records.addRecord(getVehicle(insertRecord.getVehicle(),categoryList.getSelectedItem(), nameField.getText(), brandField.getText(), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR), idField.getText(), availabilityField.isSelected()));
                dashboard.displayAll();
            }

        });


        New.add(record);
        file.add(New);
        file.add(save);
//        file.add(saveAs);
        file.add(Import);
        edit.add(reset);
        edit.add(deleteAll);
        view.add(search);
        view.add(filter);
        view.add(label);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        dashboard.setJMenuBar(menuBar);
    }

    private vehicle getVehicle(vehicle vehicle, String selectedType, String name, String brand, int day, int month, int year, String id, boolean available) {
        if (selectedType.compareTo("Helicopter") == 0) {
            return ((Helicopter) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);
        } else if (selectedType.compareTo("Plane") == 0) {
            return ((Plane) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Rocket") == 0) {
            return ((Rocket) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Bike") == 0) {
            return ((Bike) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Car") == 0) {
            return ((Car) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Train") == 0) {
            return ((Train) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Kayak") == 0) {
            return ((Kayak) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Shipping Tanker") == 0) {
            return ((ShippingTanker) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);

        } else if (selectedType.compareTo("Submarine") == 0) {
            return ((Submarine) vehicle).getFields(selectedType, name, brand, day, month, year, id, available);
        } else {
            return new Helicopter();
        }
    }

}


