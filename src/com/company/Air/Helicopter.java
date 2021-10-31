package com.company.Air;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Helicopter extends vehicleAir {//Source: https://www.aircharterservice.com/about-us/news-features/blog/top-private-helicopters
    private int distance;
    private int numOfSeats;
    private String engine;
    private String speed;


    public Helicopter() {
        super();
        this.distance = 0;
        this.numOfSeats = 0;
        this.engine = "";
        this.speed = "";
    }
    private JTextField capacityField = new JTextField(getCapacity());
    private JTextField lengthField = new JTextField(getLength());
    private JTextField heightField = new JTextField(getHeight());
    private JTextField volumeField = new JTextField(getVolume());
    private JTextField grossWeightField = new JTextField(getHeight());
    private JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
    private JTextField distanceField = new JTextField(getDistance());
    private JTextField numOfSeatsField = new JTextField(getNumOfSeats());
    private JTextField engineField = new JTextField(getEngine());
    private JTextField speedField = new JTextField(getSpeed());

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
        JLabel distance = new JLabel("Distance");
        JLabel numOfSeats = new JLabel("Num Of Seats");
        JLabel engine = new JLabel("Engine");
        JLabel speed = new JLabel("Speed");
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
        holder.add(distance);
        holder.add(distanceField);
        holder.add(numOfSeats);
        holder.add(numOfSeatsField);
        holder.add(engine);
        holder.add(engineField);
        holder.add(speed);
        holder.add(speedField);
//        holder.add(delete);
//        holder.add(update);
        return holder;
    }
    public Helicopter getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability){
        return new Helicopter(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacityField.getText(), lengthField.getText(), heightField.getText(), volumeField.getText(), grossWeightField.getText(), maxTakeoffWeightField.getText(),getInt(distanceField.getText()),getInt(numOfSeatsField.getText()),engineField.getText(),speedField.getText());
    }

    private int getInt(String str){
        try {
            return Integer.parseInt(str);
        }catch (Exception error){
            return 0;
        }
    }


    public Helicopter(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, int distance, int numOfSeats, String engine, String speed) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.distance = distance;
        this.numOfSeats = numOfSeats;
        this.engine = engine;
        this.speed = speed;
        capacityField = new JTextField(getCapacity());
        lengthField = new JTextField(getLength());
        heightField = new JTextField(getHeight());
        volumeField = new JTextField(getVolume());
        grossWeightField = new JTextField(getHeight());
        maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
        distanceField = new JTextField(getDistance());
        numOfSeatsField = new JTextField(getNumOfSeats());
        engineField = new JTextField(getEngine());
        speedField = new JTextField(getSpeed());
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
                getDistance()+"\n"+
                getNumOfSeats()+"\n"+
                getEngine()+"\n"+
                getSpeed();
    }

    public Helicopter(int distance, int numOfSeats, String engine, String speed) {
        this.distance = distance;
        this.numOfSeats = numOfSeats;
        this.engine = engine;
        this.speed = speed;
    }

    private String getDistance() {
        return Integer.toString(distance);
    }

    private String getNumOfSeats() {
        return Integer.toString(numOfSeats);
    }

    private String getEngine() {
        return engine;
    }

    private String getSpeed() {
        return speed;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }



}
