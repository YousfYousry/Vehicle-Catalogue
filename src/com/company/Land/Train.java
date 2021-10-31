package com.company.Land;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Train extends vehicleLand {
    private int maxSpeed;
    private int longOfTrain;
    private int passenger;
    private int body;
    private String typeOfTrain;

    public Train() {
        super();
        setMaxSpeed(0);
        setLong(0);
        setPassenger(0);
        setBody(0);
        setTypeOfTrain("");
    }

    private JTextField aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
    private JTextField aMaxSpeedField = new JTextField(getMaxSpeed());
    private JTextField aLongOfTrainField = new JTextField(getLong());
    private JTextField aPassengerField = new JTextField(getPassenger());
    private JTextField aBodyField = new JTextField(getBody());
    private JTextField atypeOfTrainField = new JTextField(getTypeOfTrain());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6, 2));

        JLabel aTypeOfLandTransport = new JLabel("Type Of Land Transport");
        JLabel aMaxSpeed = new JLabel("Max Speed");
        JLabel aLongOfTrain = new JLabel("Long Of Train");
        JLabel aPassenger = new JLabel("Passenger");
        JLabel aBody = new JLabel("Body");
        JLabel atypeOfTrain = new JLabel("Type Of Train");

//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfLandTransport);
        holder.add(aTypeOfLandTransportField);
        holder.add(aMaxSpeed);
        holder.add(aMaxSpeedField);
        holder.add(aLongOfTrain);
        holder.add(aLongOfTrainField);
        holder.add(aPassenger);
        holder.add(aPassengerField);
        holder.add(aBody);
        holder.add(aBodyField);
        holder.add(atypeOfTrain);
        holder.add(atypeOfTrainField);

//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Train getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Train(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransportField.getText(), getInt(aMaxSpeedField.getText()), getInt(aLongOfTrainField.getText()), getInt(aPassengerField.getText()), getInt(aBodyField.getText()), atypeOfTrainField.getText());
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception error) {
            return 0;
        }
    }


    public Train(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfLandTransport, int aMaxSpeed, int aLongOfTrain, int aPassenger, int aBody, String atypeOfTrain) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setMaxSpeed(aMaxSpeed);
        setLong(aLongOfTrain);
        setPassenger(aPassenger);
        setBody(aBody);
        setTypeOfTrain(atypeOfTrain);
        aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
        aMaxSpeedField = new JTextField(getMaxSpeed());
        aLongOfTrainField = new JTextField(getLong());
        aPassengerField = new JTextField(getPassenger());
        aBodyField = new JTextField(getBody());
        atypeOfTrainField = new JTextField(getTypeOfTrain());
    }

    private void setMaxSpeed(int aMaxSpeed) {
        maxSpeed = aMaxSpeed;
    }

    private void setLong(int aLongOfTrain) {
        longOfTrain = aLongOfTrain;
    }

    private void setPassenger(int aPassenger) {
        passenger = aPassenger;
    }

    private void setBody(int aBody) {
        body = aBody;
    }

    private void setTypeOfTrain(String atypeOfTrain) {
        typeOfTrain = atypeOfTrain;
    }

    private String getMaxSpeed() {
        return Integer.toString(maxSpeed);
    }

    private String getLong() {
        return Integer.toString(longOfTrain);
    }

    private String getPassenger() {
        return Integer.toString(passenger);
    }

    private String getBody() {
        return Integer.toString(body);
    }

    private String getTypeOfTrain() {
        return typeOfTrain;
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
                getMaxSpeed()+"\n"+
                getLong()+"\n"+
                getPassenger()+"\n"+
                getBody()+"\n"+
                getTypeOfTrain();
    }

//    public String toString() {
//        return "\nCategory: " + super.getCategory() + "\nName: " + super.getName() + "\nBrand: " + super.getBrand() + "\nDate Of Production: " + super.getDateOfProduction() +
//                "\nID Number: " + super.getIDNumber() + "\nAvailability: " + super.getAvailability() + "\nType of Land Transport: " + super.getTypeOfLandTransport() +
//                "\nMaximum speed: " + getMaxSpeed() + "mph" + "\nLong : " + getLong() + "meter" + "\nNumber of passenger: " + getPassenger() + "\nNumber of body: " +
//                getBody() + "\nType of Train: " + getTypeOfTrain();
//    }
}