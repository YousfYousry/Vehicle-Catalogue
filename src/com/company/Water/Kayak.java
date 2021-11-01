package com.company.Water;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Kayak extends vehicleSea{
    private String kayakModel;
    private int hullSpecs;
    private int maxPaddlerWeight;
    private int maxShoeSize;
    private int maxPayload;

    public Kayak(){
        super();
        setKayakModel("");
        setHullSpecs(0);
        setMaxPaddlerWeight(0);
        setMaxShoeSize(0);
        setMaxPayload(0);
    }
    private JTextField aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
    private JTextField aKayakModelField = new JTextField(getKayakModel());
    private JTextField aHullSpecsField = new JTextField(getHullSpecs());
    private JTextField aMaxPaddlerWeightField = new JTextField(getMaxPaddlerWeight());
    private JTextField aMaxShoeSizeField = new JTextField(getMaxShoeSize());
    private JTextField aMaxPayloadField = new JTextField(getMaxPayload());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6,2));


        JLabel aTypeOfWaterTransport = new JLabel("Type Of Water Transport");
        JLabel aKayakModel = new JLabel("Kayak Model");
        JLabel aHullSpecs = new JLabel("Hull Specs");
        JLabel aMaxPaddlerWeight = new JLabel("Max Paddler Weight");
        JLabel aMaxShoeSize = new JLabel("Max Shoe Size");
        JLabel aMaxPayload = new JLabel("Max Pay load");

//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfWaterTransport);
        holder.add(aTypeOfWaterTransportField);
        holder.add(aKayakModel);
        holder.add(aKayakModelField);
        holder.add(aHullSpecs);
        holder.add(aHullSpecsField);
        holder.add(aMaxPaddlerWeight);
        holder.add(aMaxPaddlerWeightField);
        holder.add(aMaxShoeSize);
        holder.add(aMaxShoeSizeField);
        holder.add(aMaxPayload);
        holder.add(aMaxPayloadField);


//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public Kayak getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new Kayak(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransportField.getText(), aKayakModelField.getText(), getInt(aHullSpecsField.getText()), getInt(aMaxPaddlerWeightField.getText()), getInt(aMaxShoeSizeField.getText()), getInt(aMaxPayloadField.getText()));
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str);
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
                getKayakModel()+"\n"+
                getHullSpecs()+"\n"+
                getMaxPaddlerWeight()+"\n"+
                getMaxShoeSize()+"\n"+
                getMaxPayload();
    }

    public Kayak(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfWaterTransport,String aKayakModel, int aHullSpecs, int aMaxPaddlerWeight, int aMaxShoeSize, int aMaxPayload){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setKayakModel(aKayakModel);
        setHullSpecs(aHullSpecs);
        setMaxPaddlerWeight(aMaxPaddlerWeight);
        setMaxShoeSize(aMaxShoeSize);
        setMaxPayload(aMaxPayload);
        aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
        aKayakModelField = new JTextField(getKayakModel());
        aHullSpecsField = new JTextField(getHullSpecs());
        aMaxPaddlerWeightField = new JTextField(getMaxPaddlerWeight());
        aMaxShoeSizeField = new JTextField(getMaxShoeSize());
        aMaxPayloadField = new JTextField(getMaxPayload());
    }

    public void setKayakModel(String aKayakModel){kayakModel=aKayakModel;}
    public void setHullSpecs(int aHullSpecs){hullSpecs=aHullSpecs;}
    public void setMaxPaddlerWeight(int aMaxPaddlerWeight){maxPaddlerWeight=aMaxPaddlerWeight;}
    public void setMaxShoeSize(int aMaxShoeSize){maxShoeSize=aMaxShoeSize;}
    public void setMaxPayload(int aMaxPayload){maxPayload=aMaxPayload;}

    public String getKayakModel(){return kayakModel;}
    public String getHullSpecs(){return        Integer.toString(hullSpecs);}
    public String getMaxPaddlerWeight(){return Integer.toString(maxPaddlerWeight);}
    public String getMaxShoeSize(){return      Integer.toString(maxShoeSize);}
    public String getMaxPayload(){return       Integer.toString(maxPayload);}

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
                getKayakModel()+"\n"+
                getHullSpecs()+"\n"+
                getMaxPaddlerWeight()+"\n"+
                getMaxShoeSize()+"\n"+
                getMaxPayload();
    }

//    public String toString(){
//        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
//                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Water Transport: "+super.getTypeOfWaterTransport()+
//                "\nKayak Model: "+getKayakModel()+"\nHull Specs: "+getHullSpecs()+"\nMaximum Paddler Weight: "+getMaxPaddlerWeight()+"\nMaximum Shoe Size: "+
//                getMaxShoeSize()+"\nMaximum Payload: "+getMaxPayload();
//    }
}