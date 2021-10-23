package com.company.Air;

public class Plane extends vehicleAir{//Source: https://millionmilesecrets.com/guides/difference-between-planes/
    private int numOfDoors;
    private String nose;
    private String wheels;
    private int numOfEngines;

    public Plane() {
        super();
        this.numOfDoors = 0;
        this.nose = "";
        this.wheels = "";
        this.numOfEngines = 0;
    }

    public Plane(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, int numOfDoors, String nose, String wheels, int numOfEngines) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
    }

    public Plane(int numOfDoors, String nose, String wheels, int numOfEngines) {
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public int getNumOfEngines() {
        return numOfEngines;
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }
}
