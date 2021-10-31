package com.company.Air;

import com.company.vehicle;

abstract class vehicleAir extends vehicle{

    private String Capacity;
    private String Length;
    private String Height;
    private String Volume;
    private String GrossWeight;
//    private String FuelCapacity;
    private String MaxTakeoffWeight;

    vehicleAir(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability);
        setCapacity(capacity);
        setLength(length);
//        setWingspan(wingspan);
        setHeight(height);
        setVolume(volume);
        setGrossWeight(grossWeight);
        setMaxTakeoffWeight(maxTakeoffWeight);
//        setPowerPlant(powerPlant);
    }

    vehicleAir(){
        super();
        setCapacity("");
        setLength("");
//        setWingspan("");
        setHeight("");
        setVolume("");
        setGrossWeight("");
        setMaxTakeoffWeight("");
//        setPowerPlant("");
    }

    String getCapacity() {
        return Capacity;
    }

    String getLength() {
        return Length;
    }

    String getHeight() {
        return Height;
    }

    String getVolume() {
        return Volume;
    }

    String getGrossWeight() {
        return GrossWeight;
    }

//    public String getFuelCapacity() {
//        return FuelCapacity;
//    }

    String getMaxTakeoffWeight() {
        return MaxTakeoffWeight;
    }

    private void setCapacity(String capacity) {
        this.Capacity = capacity;
    }

    private void setLength(String length) {
        this.Length = length;
    }

//    private void setWingspan(String wingspan) {
//        this.Wingspan = wingspan;
//    }

    private void setHeight(String height) {
        this.Height = height;
    }

    private void setVolume(String volume) {
        this.Volume = volume;
    }

    private void setGrossWeight(String grossWeight) {
        this.GrossWeight = grossWeight;
    }

    private void setMaxTakeoffWeight(String maxTakeoffWeight) {
        this.MaxTakeoffWeight = maxTakeoffWeight;
    }


    @Override
    public String getParentType(){
        return "air";
    }
//
//    private void setPowerPlant(String powerPlant) {
//        this.PowerPlant = powerPlant;
//    }
}
