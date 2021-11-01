package com.company.Water;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Submarine extends vehicleSea {
    private String submarineClass;
    private double submergedDisplacement;
    private int endurance;
    private boolean airIndependentPropulsion = false;
    private boolean permanentMagnetMotor = false;

    public Submarine() {
        super();
        setSubmarineClass("");
        setSubmergedDisplacement(0);
        setEndurance(0);
        setAirIndependentPropulsion(false);
        setPermanentMagnetMotor(false);
    }

    private JTextField aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
    private JTextField aSubmarineClassField = new JTextField(getSubmarineClass());
    private JTextField aSubmergedDisplacementField = new JTextField(getSubmergedDisplacement());
    private JTextField aEnduranceField = new JTextField(getEndurance());
    private JCheckBox aAirIndependentPropulsionField = new JCheckBox("", airIndependentPropulsion);
    private JCheckBox aPermanentMagnetMotorField = new JCheckBox("", permanentMagnetMotor);

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6, 2));

        JLabel aTypeOfWaterTransport = new JLabel("Type Of Water Transport");
        JLabel aSubmarineClass = new JLabel("Submarine Class");
        JLabel aSubmergedDisplacement = new JLabel("Submerged Displacement");
        JLabel aEndurance = new JLabel("Endurance");
        JLabel aAirIndependentPropulsion = new JLabel("Air Independent Propulsion");
        JLabel aPermanentMagnetMotor = new JLabel("Permanent Magnet Motor");

//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfWaterTransport);
        holder.add(aTypeOfWaterTransportField);
        holder.add(aSubmarineClass);
        holder.add(aSubmarineClassField);
        holder.add(aSubmergedDisplacement);
        holder.add(aSubmergedDisplacementField);
        holder.add(aEndurance);
        holder.add(aEnduranceField);
        holder.add(aAirIndependentPropulsion);
        holder.add(aAirIndependentPropulsionField);
        holder.add(aPermanentMagnetMotor);
        holder.add(aPermanentMagnetMotorField);


//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Submarine getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Submarine(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransportField.getText(), aSubmarineClassField.getText(), getDouble(aSubmergedDisplacementField.getText()), getInt(aEnduranceField.getText()), aAirIndependentPropulsionField.isSelected(), aPermanentMagnetMotorField.isSelected());
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

    @Override
    public String getInformation() {
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
                super.getTypeOfWaterTransport()+"\n"+
                getSubmarineClass()+"\n"+
                getSubmergedDisplacement()+"\n"+
                getEndurance()+"\n"+
                getAirIndependentPropulsion()+"\n"+
                getPermanentMagnetMotor();
    }

    public Submarine(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfWaterTransport, String aSubmarineClass, double aSubmergedDisplacement, int aEndurance, boolean aAirIndependentPropulsion, boolean aPermanentMagnetMotor) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setSubmarineClass(aSubmarineClass);
        setSubmergedDisplacement(aSubmergedDisplacement);
        setEndurance(aEndurance);
        setAirIndependentPropulsion(aAirIndependentPropulsion);
        setPermanentMagnetMotor(aPermanentMagnetMotor);
        aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
        aSubmarineClassField = new JTextField(getSubmarineClass());
        aSubmergedDisplacementField = new JTextField(getSubmergedDisplacement());
        aEnduranceField = new JTextField(getEndurance());
        aAirIndependentPropulsionField = new JCheckBox("", airIndependentPropulsion);
        aPermanentMagnetMotorField = new JCheckBox("", permanentMagnetMotor);
    }

    public void setSubmarineClass(String aSubmarineClass) {
        submarineClass = aSubmarineClass;
    }

    public void setSubmergedDisplacement(double aSubmergedDisplacement) {
        submergedDisplacement = aSubmergedDisplacement;
    }

    public void setEndurance(int aEndurance) {
        endurance = aEndurance;
    }

    public void setAirIndependentPropulsion(boolean aAirIndependentPropulsion) {
        airIndependentPropulsion = aAirIndependentPropulsion;
    }

    public void setPermanentMagnetMotor(boolean aPermanentMagnetMotor) {
        permanentMagnetMotor = aPermanentMagnetMotor;
    }

    public String getSubmarineClass() {
        return submarineClass;
    }

    public String getSubmergedDisplacement() {
        return Double.toString(submergedDisplacement);
    }

    public String getEndurance() {
        return Integer.toString(endurance);
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
                super.getTypeOfWaterTransport()+"\n"+
                getSubmarineClass()+"\n"+
                getSubmergedDisplacement()+"\n"+
                getEndurance()+"\n"+
                getAirIndependentPropulsion()+"\n"+
                getPermanentMagnetMotor();
    }

    public String getAirIndependentPropulsion() {
        if (airIndependentPropulsion) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String getPermanentMagnetMotor() {
        if (permanentMagnetMotor) {
            return "Yes";
        } else {
            return "No";
        }
    }
}