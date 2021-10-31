package com.company.Land;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Bike extends vehicleLand {
    private String frameSize;
    private double handlebarWidth;
    private int seat;
    private int gear;
    private String material;

    public Bike() {
        super();
        setFrameSize("");
        setHandlebarWidth(0);
        setSeat(0);
        setGear(0);
        setMaterial("");
    }

    private JTextField aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
    private JTextField aFrameSizeField = new JTextField(getFrameSize());
    private JTextField aHandlebarWidthField = new JTextField(getHandlebarWidth());
    private JTextField aseatField = new JTextField(getSeat());
    private JTextField aGearField = new JTextField(getGear());
    private JTextField aMaterialField = new JTextField(getMaterial());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6, 2));

        JLabel aTypeOfLandTransport = new JLabel("Type Of Land Transport");
        JLabel aFrameSize = new JLabel("Frame Size");
        JLabel aHandlebarWidth = new JLabel("Handlebar Width");
        JLabel aseat = new JLabel("Seat");
        JLabel aGear = new JLabel("Gear");
        JLabel aMaterial = new JLabel("Material");
//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfLandTransport);
        holder.add(aTypeOfLandTransportField);
        holder.add(aFrameSize);
        holder.add(aFrameSizeField);
        holder.add(aHandlebarWidth);
        holder.add(aHandlebarWidthField);
        holder.add(aseat);
        holder.add(aseatField);
        holder.add(aGear);
        holder.add(aGearField);
        holder.add(aMaterial);
        holder.add(aMaterialField);
//        holder.add(delete);
//        holder.add(update);

        return holder;
    }

    public Bike getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Bike(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransportField.getText(), aFrameSizeField.getText(), getDouble(aHandlebarWidthField.getText()), getInt(aseatField.getText()), getInt(aGearField.getText()), aMaterialField.getText());
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception error) {
            return 0;
        }
    }

    private double getDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception error) {
            return 0;
        }
    }

    public Bike(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfLandTransport, String aFrameSize, double aHandlebarWidth, int aseat, int aGear, String aMaterial) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setFrameSize(aFrameSize);
        setHandlebarWidth(aHandlebarWidth);
        setSeat(aseat);
        setGear(aGear);
        setMaterial(aMaterial);
        aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
        aFrameSizeField = new JTextField(getFrameSize());
        aHandlebarWidthField = new JTextField(getHandlebarWidth());
        aseatField = new JTextField(getSeat());
        aGearField = new JTextField(getGear());
        aMaterialField = new JTextField(getMaterial());
    }

    private void setFrameSize(String aFrameSize) {
        frameSize = aFrameSize;
    }

    private void setHandlebarWidth(double aHandlebarWidth) {
        handlebarWidth = aHandlebarWidth;
    }

    private void setSeat(int aseat) {
        seat = aseat;
    }

    private void setGear(int aGear) {
        gear = aGear;
    }

    private void setMaterial(String aMaterial) {
        material = aMaterial;
    }

    private String getFrameSize() {
        return frameSize;
    }

    private String getHandlebarWidth() {
        return Double.toString(handlebarWidth);
    }

    private String getSeat() {
        return Integer.toString(seat);
    }

    private String getGear() {
        return Integer.toString(gear);
    }

    private String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(super.getDateOfProduction());

        return super.getCategory()+"\n"+
                super.getName()+"\n"+
                super.getBrand()+"\n"+
                cal.get(Calendar.DAY_OF_MONTH)+"\n"+
                cal.get(Calendar.MONTH)+"\n"+
                cal.get(Calendar.YEAR)+"\n"+
                super.getIDNumber()+"\n"+
                super.getAvailability()+"\n"+
                super.getTypeOfLandTransport()+"\n"+
                getFrameSize()+"\n"+
                getHandlebarWidth()+"\n"+
                getSeat()+"\n"+
                getGear()+"\n"+
                getMaterial();
    }

//    public String toString() {
//        return "\nCategory: " + super.getCategory() + "\nName: " + super.getName() + "\nBrand: " + super.getBrand() + "\nDate Of Production: " + super.getDateOfProduction() +
//                "\nID Number: " + super.getIDNumber() + "\nAvailability: " + super.getAvailability() + "\nType of Land Transport: " + super.getTypeOfLandTransport() +
//                "\nFrame size: " + getFrameSize() + "\nHandlebar Width: " + getHandlebarWidth() + "cm" + "\nNumber of seat: " + getSeat() + "\nNumber of gear: " +
//                getGear() + "\nFrame material: " + getMaterial();
//    }
}