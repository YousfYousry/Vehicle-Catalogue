package com.company.Air;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Rocket extends vehicleAir {//Source: https://en.wikipedia.org/wiki/Comparison_of_orbital_launch_systems
    private String manufacturer;
    private String origin;
    private String firstDateOfFlight;
    private int numOfFailures;


    public Rocket() {
        super();
        this.manufacturer = "";
        this.origin = "";
        this.firstDateOfFlight = "";
        this.numOfFailures = 0;
    }

    private JTextField capacityField = new JTextField(getCapacity());
    private JTextField lengthField = new JTextField(getLength());
    private JTextField heightField = new JTextField(getHeight());
    private JTextField volumeField = new JTextField(getVolume());
    private JTextField grossWeightField = new JTextField(getGrossWeight());
    private JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
    private JTextField manufacturerField = new JTextField(getManufacturer());
    private JTextField originField = new JTextField(getOrigin());
    private JTextField firstDateOfFlightField = new JTextField(getFirstDateOfFlight());
    private JTextField numOfFailuresField = new JTextField(getNumOfFailures());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(10, 2));
        JLabel capacity = new JLabel("Capacity");
        JLabel length = new JLabel("Length");
        JLabel height = new JLabel("Height");
        JLabel volume = new JLabel("Volume");
        JLabel grossWeight = new JLabel("Gross Weight");
        JLabel maxTakeoffWeight = new JLabel("Max Take off Weight");
        JLabel manufacturer = new JLabel("Manufacturer");
        JLabel origin = new JLabel("Origin");
        JLabel firstDateOfFlight = new JLabel("First Date Of Flight");
        JLabel numOfFailures = new JLabel("Num Of Failures");
//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(capacity);
        holder.add(capacityField);
        holder.add(length);
        holder.add(lengthField);
        holder.add(height);
        holder.add(heightField);
        holder.add(volume);
        holder.add(volumeField);
        holder.add(grossWeight);
        holder.add(grossWeightField);
        holder.add(maxTakeoffWeight);
        holder.add(maxTakeoffWeightField);
        holder.add(manufacturer);
        holder.add(manufacturerField);
        holder.add(origin);
        holder.add(originField);
        holder.add(firstDateOfFlight);
        holder.add(firstDateOfFlightField);
        holder.add(numOfFailures);
        holder.add(numOfFailuresField);
//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Rocket getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Rocket(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacityField.getText(), lengthField.getText(), heightField.getText(), volumeField.getText(), grossWeightField.getText(), maxTakeoffWeightField.getText(), manufacturerField.getText(), originField.getText(), firstDateOfFlightField.getText(), getInt(numOfFailuresField.getText()));
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception error) {
            return 0;
        }
    }

    public Rocket(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, String manufacturer, String origin, String firstDateOfFlight, int numOfFailures) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.firstDateOfFlight = firstDateOfFlight;
        this.numOfFailures = numOfFailures;

        capacityField = new JTextField(getCapacity());
        lengthField = new JTextField(getLength());
        heightField = new JTextField(getHeight());
        volumeField = new JTextField(getVolume());
        grossWeightField = new JTextField(getGrossWeight());
        maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
        manufacturerField = new JTextField(getManufacturer());
        originField = new JTextField(getOrigin());
        firstDateOfFlightField = new JTextField(getFirstDateOfFlight());
        numOfFailuresField = new JTextField(getNumOfFailures());
    }

    public Rocket(String manufacturer, String origin, String firstDateOfFlight, int numOfFailures) {
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.firstDateOfFlight = firstDateOfFlight;
        this.numOfFailures = numOfFailures;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFirstDateOfFlight() {
        return firstDateOfFlight;
    }

    public void setFirstDateOfFlight(String firstDateOfFlight) {
        this.firstDateOfFlight = firstDateOfFlight;
    }

    public String getNumOfFailures() {
        return Integer.toString(numOfFailures);
    }

    public void setNumOfFailures(int numOfFailures) {
        this.numOfFailures = numOfFailures;
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
                super.getCapacity()+"\n"+
                super.getLength()+"\n"+
                super.getHeight()+"\n"+
                super.getVolume()+"\n"+
                super.getGrossWeight()+"\n"+
                super.getMaxTakeoffWeight()+"\n"+
                getManufacturer()+"\n"+
                getOrigin()+"\n"+
                getFirstDateOfFlight()+"\n"+
                getNumOfFailures();
    }
}
