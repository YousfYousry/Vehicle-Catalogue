package com.company.Land;

public class Bike extends vehicleLand{
    private String frameSize;
    private double handlebarWidth;
    private int seat;
    private int gear;
    private String material;

    public Bike(){
        super();
        setFrameSize("");
        setHandlebarWidth(0);
        setSeat(0);
        setGear(0);
        setMaterial("");
    }
    public Bike(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                boolean aAvailability, String aTypeOfLandTransport,String aFrameSize, double aHandlebarWidth,
                int aseat, int aGear, String aMaterial){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setFrameSize(aFrameSize);
        setHandlebarWidth(aHandlebarWidth);
        setSeat(aseat);
        setGear(aGear);
        setMaterial(aMaterial);
    }

    private void setFrameSize(String aFrameSize){frameSize=aFrameSize;}
    private void setHandlebarWidth(double aHandlebarWidth){handlebarWidth=aHandlebarWidth;}
    private void setSeat(int aseat){seat=aseat;}
    private void setGear(int aGear){gear=aGear;}
    private void setMaterial(String aMaterial){material=aMaterial;}

    private String getFrameSize(){return frameSize;}
    private double getHandlebarWidth(){return handlebarWidth;}
    private int getSeat(){return seat;}
    private int getGear(){return gear;}
    private String getMaterial(){return material;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nFrame size: "+getFrameSize()+"\nHandlebar Width: "+getHandlebarWidth()+"cm"+"\nNumber of seat: "+getSeat()+"\nNumber of gear: "+
                getGear()+"\nFrame material: "+getMaterial();
    }
}