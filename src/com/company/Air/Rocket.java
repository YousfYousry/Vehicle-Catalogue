package com.company.Air;

public class Rocket extends vehicleAir {//Source: https://en.wikipedia.org/wiki/Comparison_of_orbital_launch_systems
    private String manufacturer;
    private String origin;
    private String firstDateOfFlight;
    private int numOfFailures;

    public Rocket() {
        super();
        this.manufacturer = "";
        this.origin = "";
        this.firstDateOfFlight = "";
        this.numOfFailures = 0;
    }

    public Rocket(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, String manufacturer, String origin, String firstDateOfFlight, int numOfFailures) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.firstDateOfFlight = firstDateOfFlight;
        this.numOfFailures = numOfFailures;
    }

    public Rocket(String manufacturer, String origin, String firstDateOfFlight, int numOfFailures) {
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.firstDateOfFlight = firstDateOfFlight;
        this.numOfFailures = numOfFailures;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFirstDateOfFlight() {
        return firstDateOfFlight;
    }

    public void setFirstDateOfFlight(String firstDateOfFlight) {
        this.firstDateOfFlight = firstDateOfFlight;
    }

    public int getNumOfFailures() {
        return numOfFailures;
    }

    public void setNumOfFailures(int numOfFailures) {
        this.numOfFailures = numOfFailures;
    }
}
