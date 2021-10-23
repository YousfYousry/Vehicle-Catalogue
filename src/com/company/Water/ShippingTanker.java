package com.company.Water;

public class ShippingTanker extends vehicleSea{
    private String shippingTankerClass;
    private int length;
    private int beam;
    private int draft;
    private double deadWeightTons;

    public ShippingTanker(){
        super();
        setShippingTankerClass("");
        setLength(0);
        setBeam(0);
        setDraft(0);
        setDeadWeightTons(0);
    }

    public ShippingTanker(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                          boolean aAvailability, String aTypeOfWaterTransport,String aShippingTankerClass, int aLength,
                          int aBeam, int aDraft, double aDeadWeightTons){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setShippingTankerClass(aShippingTankerClass);
        setLength(aLength);
        setBeam(aBeam);
        setDraft(aDraft);
        setDeadWeightTons(aDeadWeightTons);
    }

    public void setShippingTankerClass(String aShippingTankerClass){shippingTankerClass=aShippingTankerClass;}
    public void setLength(int aLength){length=aLength;}
    public void setBeam(int aBeam){beam=aBeam;}
    public void setDraft(int aDraft){draft=aDraft;}
    public void setDeadWeightTons(double aDeadWeightTons){deadWeightTons=aDeadWeightTons;}

    public String getShippingTankerClass(){return shippingTankerClass;}
    public int getLength(){return length;}
    public int getBeam(){return beam;}
    public int getDraft(){return draft;}
    public double getDeadWeightTons(){return deadWeightTons;}

}