package com.company.Land;

import javax.swing.*;
import java.awt.*;

public class Car extends vehicleLand {
    private String carModel;
    private double bootSize;
    private int seat;
    private int airBag;
    private String typeOfCar;

    public Car() {
        super();
        setCarModel("");
        setBootSize(0);
        setSeat(0);
        setAirBag(0);
        setTypeOfCar("");
    }

    private JTextField aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
    private JTextField acarModelField = new JTextField(getCarModel());
    private JTextField abootSizeField = new JTextField(getBootSize());
    private JTextField aseatField = new JTextField(getSeat());
    private JTextField aAirBagField = new JTextField(getAirBag());
    private JTextField atypeOfCarField = new JTextField(getTypeOfCar());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6, 2));


        JLabel aTypeOfLandTransport = new JLabel("Type Of Land Transport");
        JLabel acarModel = new JLabel("Car Model");
        JLabel abootSize = new JLabel("Boot Size");
        JLabel aseat = new JLabel("Seat");
        JLabel aAirBag = new JLabel("Air Bag");
        JLabel atypeOfCar = new JLabel("Type Of Car");

//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfLandTransport);
        holder.add(aTypeOfLandTransportField);
        holder.add(acarModel);
        holder.add(acarModelField);
        holder.add(abootSize);
        holder.add(abootSizeField);
        holder.add(aseat);
        holder.add(aseatField);
        holder.add(aAirBag);
        holder.add(aAirBagField);
        holder.add(atypeOfCar);
        holder.add(atypeOfCarField);

//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Car getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Car(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransportField.getText(), acarModelField.getText(), getDouble(abootSizeField.getText()), getInt(aseatField.getText()), getInt(aAirBagField.getText()), atypeOfCarField.getText());
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

    public Car(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfLandTransport, String acarModel, double abootSize, int aseat, int aAirBag, String atypeOfCar) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setCarModel(acarModel);
        setBootSize(abootSize);
        setSeat(aseat);
        setAirBag(aAirBag);
        setTypeOfCar(atypeOfCar);
        aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
        acarModelField = new JTextField(getCarModel());
        abootSizeField = new JTextField(getBootSize());
        aseatField = new JTextField(getSeat());
        aAirBagField = new JTextField(getAirBag());
        atypeOfCarField = new JTextField(getTypeOfCar());
    }

    private void setCarModel(String acarModel) {
        carModel = acarModel;
    }

    private void setBootSize(double abootSize) {
        bootSize = abootSize;
    }

    private void setSeat(int aseat) {
        seat = aseat;
    }

    private void setAirBag(int aAirBag) {
        airBag = aAirBag;
    }

    private void setTypeOfCar(String atypeOfCar) {
        typeOfCar = atypeOfCar;
    }

    private String getCarModel() {
        return carModel;
    }

    private String getBootSize() {
        return Double.toString(bootSize);
    }

    private String getSeat() {
        return Integer.toString(seat);
    }

    private String getAirBag() {
        return Integer.toString(airBag);
    }

    private String getTypeOfCar() {
        return typeOfCar;
    }

    public String toString() {
        return "\nCategory: " + super.getCategory() + "\nName: " + super.getName() + "\nBrand: " + super.getBrand() + "\nDate Of Production: " + super.getDateOfProduction() +
                "\nID Number: " + super.getIDNumber() + "\nAvailability: " + super.getAvailability() + "\nType of Land Transport: " + super.getTypeOfLandTransport() +
                "\nCar Model: " + getCarModel() + "\nBoot size: " + getBootSize() + "\nNumber of seat: " + getSeat() + "\nNumber of airbag: " +
                getAirBag() + "\nType of car: " + getTypeOfCar();
    }
}