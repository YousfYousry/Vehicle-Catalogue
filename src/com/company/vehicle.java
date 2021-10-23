package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class vehicle {
    private String category;
    private String name;
    private String brand;
    private Calendar dateOfProduction;
    private String IDNumber;
    private boolean availability;

    public vehicle() {
        setCategory("");
        setName("");
        setBrand("");
        dateOfProduction = Calendar.getInstance();
        setIDNumber("");
        setAvailability(false);
    }

    public vehicle(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        setCategory(aCategory);
        setName(aName);
        setBrand(aBrand);
        dateOfProduction = new GregorianCalendar(aYear, --aMonth, aDay);
        setDateOfProduction(aDay, aMonth, aYear);
        setIDNumber(aIDNumber);
        setAvailability(aAvailability);
    }

    private void setCategory(String aCategory) {
        this.category = aCategory;
    }

    private void setName(String aName) {
        this.name = aName;
    }

    private void setBrand(String aBrand) {
        this.brand = aBrand;
    }

    private void setDateOfProduction(int aDay, int aMonth, int aYear) {
        dateOfProduction.set(Calendar.YEAR, aYear);
        dateOfProduction.set(Calendar.MONTH, aMonth);
        dateOfProduction.set(Calendar.DAY_OF_MONTH, aDay);
    }

    private void setIDNumber(String aIDNumber) {
        this.IDNumber = aIDNumber;
    }

    private void setAvailability(boolean aAvailability) {
        this.availability = aAvailability;
    }

    protected String getDateOfProduction() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(dateOfProduction.getTime());
    }

    protected String getCategory() {
        return category;
    }

    protected String getName() {
        return name;
    }

    protected String getBrand() {
        return brand;
    }

    protected String getIDNumber() {
        return IDNumber;
    }

    protected String getAvailability() {
        return (availability) ? "Yes" : "No";
    }
}