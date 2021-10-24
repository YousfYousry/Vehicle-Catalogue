package com.company.Land;

public class Train extends vehicleLand{
    private int maxSpeed;
    private int longOfTrain;
    private int passenger;
    private int body;
    private String typeOfTrain;

    public Train(){
        super();
        setMaxSpeed(0);
        setLong(0);
        setPassenger(0);
        setBody(0);
        setTypeOfTrain("");
    }
    public Train(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                 boolean aAvailability, String aTypeOfLandTransport,int aMaxSpeed, int aLongOfTrain,
                 int aPassenger, int aBody, String atypeOfTrain){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setMaxSpeed(aMaxSpeed);
        setLong(aLongOfTrain);
        setPassenger(aPassenger);
        setBody(aBody);
        setTypeOfTrain(atypeOfTrain);
    }

    private void setMaxSpeed(int aMaxSpeed){maxSpeed=aMaxSpeed;}
    private void setLong(int aLongOfTrain){longOfTrain=aLongOfTrain;}
    private void setPassenger(int aPassenger){passenger=aPassenger;}
    private void setBody(int aBody){body=aBody;}
    private void setTypeOfTrain(String atypeOfTrain){typeOfTrain=atypeOfTrain;}

    private int getMaxSpeed(){return maxSpeed;}
    private int getLong(){return longOfTrain;}
    private int getPassenger(){return passenger;}
    private int getBody(){return body;}
    private String getTypeOfTrain(){return typeOfTrain;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nMaximum speed: "+getMaxSpeed()+"mph" +"\nLong : "+getLong()+"meter"+"\nNumber of passenger: "+getPassenger()+"\nNumber of body: "+
                getBody()+"\nType of Train: "+getTypeOfTrain();
    }
}