package com.company.Air;

import javax.swing.*;
import java.awt.*;

public class Plane extends vehicleAir {//Source: https://millionmilesecrets.com/guides/difference-between-planes/
    private int numOfDoors;
    private String nose;
    private String wheels;
    private int numOfEngines;

    public Plane() {
        super();
        this.numOfDoors = 0;
        this.nose = "";
        this.wheels = "";
        this.numOfEngines = 0;
    }
   private JTextField capacityField = new JTextField(getCapacity());
   private JTextField lengthField = new JTextField(getLength());
   private JTextField heightField = new JTextField(getHeight());
   private JTextField volumeField = new JTextField(getVolume());
   private JTextField grossWeightField = new JTextField(getGrossWeight());
   private JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
   private JTextField numOfDoorsField = new JTextField(getNumOfDoors());
   private JTextField noseField = new JTextField(getNose());
   private JTextField wheelsField = new JTextField(getWheels());
   private JTextField numOfEnginesField = new JTextField(getNumOfEngines());

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
        JLabel numOfDoors = new JLabel("Num Of Doors");
        JLabel nose = new JLabel("Nose");
        JLabel wheels = new JLabel("Wheels");
        JLabel numOfEngines = new JLabel("Num Of Engines");
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
        holder.add(numOfDoors);
        holder.add(numOfDoorsField);
        holder.add(nose);
        holder.add(noseField);
        holder.add(wheels);
        holder.add(wheelsField);
        holder.add(numOfEngines);
        holder.add(numOfEnginesField);
//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Plane getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability){
        return new Plane(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacityField.getText(), lengthField.getText(), heightField.getText(), volumeField.getText(), grossWeightField.getText(), maxTakeoffWeightField.getText(),getInt(numOfDoorsField.getText()),noseField.getText(),wheelsField.getText(),getInt(numOfEnginesField.getText()));
    }

    private int getInt(String str){
        try {
            return Integer.parseInt(str);
        }catch (Exception error){
            return 0;
        }
    }


    public Plane(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, int numOfDoors, String nose, String wheels, int numOfEngines) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
        capacityField = new JTextField(getCapacity());
        lengthField = new JTextField(getLength());
        heightField = new JTextField(getHeight());
        volumeField = new JTextField(getVolume());
        grossWeightField = new JTextField(getGrossWeight());
        maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
        numOfDoorsField = new JTextField(getNumOfDoors());
        noseField = new JTextField(getNose());
        wheelsField = new JTextField(getWheels());
        numOfEnginesField = new JTextField(getNumOfEngines());
    }

    public Plane(int numOfDoors, String nose, String wheels, int numOfEngines) {
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
    }


    public String getNumOfDoors() {
        return Integer.toString(numOfDoors);
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getNumOfEngines() {
        return Integer.toString(numOfEngines);
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }
}
