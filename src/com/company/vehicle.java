package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.company.GUI.Launcher.dashboard;

public abstract class vehicle {
    private String category;
    private String name;
    private String brand;
    private Calendar dateOfProduction;
    private String IDNumber;
    private JCheckBox availability;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

    public vehicle() {
        setCategory("");
        setName("");
        setBrand("");
        dateOfProduction = Calendar.getInstance();
        setIDNumber("");
        setAvailability(false);
    }

    public vehicle(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        setCategory(aCategory);
        setName(aName);
        setBrand(aBrand);
        dateOfProduction = new GregorianCalendar(aYear, --aMonth, aDay);
        setDateOfProduction(aDay, aMonth, aYear);
        setIDNumber(aIDNumber);
        setAvailability(aAvailability);
    }

    public abstract JPanel getView();
    public abstract String getParentType();

    private void setCategory(String aCategory) {
        this.category = aCategory;
    }

    private void setName(String aName) {
        this.name = aName;
    }

    private void setBrand(String aBrand) {
        this.brand = aBrand;
    }

    private void setDateOfProduction(int aDay, int aMonth, int aYear) {
        dateOfProduction.set(Calendar.YEAR, aYear);
        dateOfProduction.set(Calendar.MONTH, aMonth);
        dateOfProduction.set(Calendar.DAY_OF_MONTH, aDay);
    }

    private void setIDNumber(String aIDNumber) {
        this.IDNumber = aIDNumber;
    }

    private void setAvailability(boolean aAvailability) {
        availability = new JCheckBox("", aAvailability);
        availability.setHorizontalAlignment(SwingConstants.CENTER);
        availability.setOpaque(false);
    }

    protected Date getDateOfProduction() {
        return dateOfProduction.getTime();
    }

    protected String getCategory() {
        return category;
    }

    protected String getName() {
        return name;
    }

    protected String getBrand() {
        return brand;
    }

    protected String getIDNumber() {
        return IDNumber;
    }

    protected boolean getAvailability() {
        return (availability.isSelected());
    }

    public Object[] getObject() {
        return new Object[]{getButtons(), getCategory(), getName(), getBrand(), getDateOfProduction().getTime(), getIDNumber(), getAvailability()};
    }

    private JPanel getButtons(){
        JButton viewButton = new JButton();
        JButton deleteButton = new JButton();
        ImageIcon viewImg = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        ImageIcon deleteImg = new ImageIcon(System.getProperty("user.dir") + "\\assets\\delete.png");
        viewButton.setIcon(new ImageIcon(getScaledImage(viewImg.getImage(), 15, 15)));
        deleteButton.setIcon(new ImageIcon(getScaledImage(deleteImg.getImage(), 10, 10)));
        viewButton.addActionListener(e -> JOptionPane.showOptionDialog(null, getView(), getCategory()+" Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null));
        deleteButton.addActionListener(e -> {
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+getName()+" ("+getCategory()+")?", "Delete "+getName(),
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (n == JOptionPane.YES_OPTION) {
                Records.deleteRecord(this);
                dashboard.updateTable();
            }
        });

        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(1,2));
        holder.add(deleteButton);
        holder.add(viewButton);
        return holder;
    }


    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

//       categoryList.add("Helicopter");
//        categoryList.add("Plane");
//        categoryList.add("Rocket");
//        categoryList.add("Bike");
//        categoryList.add("Car");
//        categoryList.add("Train");
//        categoryList.add("Kayak");
//        categoryList.add("Shipping Tanker");
//        categoryList.add("Submarine");
}