package com.company.Air;

public class Helicopter extends vehicleAir{//Source: https://www.aircharterservice.com/about-us/news-features/blog/top-private-helicopters
    private int distance;
    private int numOfSeats;
    private String engine;
    private String speed;

    public Helicopter() {
        super();
        this.distance = 0;
        this.numOfSeats = 0;
        this.engine = "";
        this.speed = "";
    }

    public Helicopter(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, int distance, int numOfSeats, String engine, String speed) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.distance = distance;
        this.numOfSeats = numOfSeats;
        this.engine = engine;
        this.speed = speed;
    }

    public Helicopter(int distance, int numOfSeats, String engine, String speed) {
        this.distance = distance;
        this.numOfSeats = numOfSeats;
        this.engine = engine;
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getEngine() {
        return engine;
    }

    public String getSpeed() {
        return speed;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
