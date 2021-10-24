package com.company.Land;

public class Car extends vehicleLand{
    private String carModel;
    private double bootSize;
    private int seat;
    private int airBag;
    private String typeOfCar;

    public Car(){
        super();
        setCarModel("");
        setBootSize(0);
        setSeat(0);
        setAirBag(0);
        setTypeOfCar("");
    }
    public Car(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
               boolean aAvailability, String aTypeOfLandTransport,String acarModel, double abootSize,
               int aseat, int aAirBag, String atypeOfCar){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setCarModel(acarModel);
        setBootSize(abootSize);
        setSeat(aseat);
        setAirBag(aAirBag);
        setTypeOfCar(atypeOfCar);
    }

    private void setCarModel(String acarModel){carModel=acarModel;}
    private void setBootSize(double abootSize){bootSize=abootSize;}
    private void setSeat(int aseat){seat=aseat;}
    private void setAirBag(int aAirBag){airBag=aAirBag;}
    private void setTypeOfCar(String atypeOfCar){typeOfCar=atypeOfCar;}

    private String getCarModel(){return carModel;}
    private double getBootSize(){return bootSize;}
    private int getSeat(){return seat;}
    private int getAirBag(){return airBag;}
    private String getTypeOfCar(){return typeOfCar;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nCar Model: "+getCarModel()+"\nBoot size: "+getBootSize()+"\nNumber of seat: "+getSeat()+"\nNumber of airbag: "+
                getAirBag()+"\nType of car: "+getTypeOfCar();
    }
}