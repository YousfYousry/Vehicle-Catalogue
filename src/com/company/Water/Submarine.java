package com.company.Water;

public class Submarine extends vehicleSea{
    private String submarineClass;
    private double submergedDisplacement;
    private int endurance;
    private boolean airIndependentPropulsion;
    private boolean permanentMagnetMotor;

    public Submarine(){
        super();
        setSubmarineClass("");
        setSubmergedDisplacement(0);
        setEndurance(0);
        setAirIndependentPropulsion(false);
        setPermanentMagnetMotor(false);
    }
    public Submarine(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                     boolean aAvailability, String aTypeOfWaterTransport,String aSubmarineClass, double aSubmergedDisplacement,
                     int aEndurance, boolean aAirIndependentPropulsion, boolean aPermanentMagnetMotor){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setSubmarineClass(aSubmarineClass);
        setSubmergedDisplacement(aSubmergedDisplacement);
        setEndurance(aEndurance);
        setAirIndependentPropulsion(aAirIndependentPropulsion);
        setPermanentMagnetMotor(aPermanentMagnetMotor);
    }

    public void setSubmarineClass(String aSubmarineClass){submarineClass=aSubmarineClass;}
    public void setSubmergedDisplacement(double aSubmergedDisplacement){submergedDisplacement=aSubmergedDisplacement;}
    public void setEndurance(int aEndurance){endurance=aEndurance;}
    public void setAirIndependentPropulsion(boolean aAirIndependentPropulsion){airIndependentPropulsion=aAirIndependentPropulsion;}
    public void setPermanentMagnetMotor(boolean aPermanentMagnetMotor){permanentMagnetMotor=aPermanentMagnetMotor;}

    public String getSubmarineClass(){return submarineClass;}
    public double getSubmergedDisplacement(){return submergedDisplacement;}
    public int getEndurance(){return endurance;}
    public String getAirIndependentPropulsion(){
        if(airIndependentPropulsion){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    public String getPermanentMagnetMotor(){
        if(permanentMagnetMotor){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}