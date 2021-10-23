package com.company.Water;

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
    public Kayak(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                 boolean aAvailability, String aTypeOfWaterTransport,String aKayakModel, int aHullSpecs,
                 int aMaxPaddlerWeight, int aMaxShoeSize, int aMaxPayload){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setKayakModel(aKayakModel);
        setHullSpecs(aHullSpecs);
        setMaxPaddlerWeight(aMaxPaddlerWeight);
        setMaxShoeSize(aMaxShoeSize);
        setMaxPayload(aMaxPayload);
    }

    public void setKayakModel(String aKayakModel){kayakModel=aKayakModel;}
    public void setHullSpecs(int aHullSpecs){hullSpecs=aHullSpecs;}
    public void setMaxPaddlerWeight(int aMaxPaddlerWeight){maxPaddlerWeight=aMaxPaddlerWeight;}
    public void setMaxShoeSize(int aMaxShoeSize){maxShoeSize=aMaxShoeSize;}
    public void setMaxPayload(int aMaxPayload){maxPayload=aMaxPayload;}

    public String getKayakModel(){return kayakModel;}
    public int getHullSpecs(){return hullSpecs;}
    public int getMaxPaddlerWeight(){return maxPaddlerWeight;}
    public int getMaxShoeSize(){return maxShoeSize;}
    public int getMaxPayload(){return maxPayload;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Water Transport: "+super.getTypeOfWaterTransport()+
                "\nKayak Model: "+getKayakModel()+"\nHull Specs: "+getHullSpecs()+"\nMaximum Paddler Weight: "+getMaxPaddlerWeight()+"\nMaximum Shoe Size: "+
                getMaxShoeSize()+"\nMaximum Payload: "+getMaxPayload();
    }
}