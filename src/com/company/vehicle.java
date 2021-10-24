package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class vehicle {
    private String category;
    private String name;
    private String brand;
    private Calendar dateOfProduction;
    private String IDNumber;
    private JButton viewButton;
    private JCheckBox availability;

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
        setButton();
    }

    private void setButton(){
        viewButton =new JButton("");
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        viewButton.setIcon(new ImageIcon(getScaledImage(img.getImage(), 15, 15)));
    }

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
        availability = new JCheckBox("",aAvailability);
        availability.setHorizontalAlignment(SwingConstants.CENTER);
        availability.setBackground(Color.WHITE);
    }

    protected String getDateOfProduction() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(dateOfProduction.getTime());
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

    protected String getAvailability() {
        return (availability.isSelected()) ? "Yes" : "No";
    }

    public Object[] getObject(){
        return new Object[]{viewButton, getCategory(), getName(), getBrand(), getDateOfProduction(), getIDNumber(), availability};
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}