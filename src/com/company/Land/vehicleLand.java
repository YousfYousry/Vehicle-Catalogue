package com.company.Land;

import com.company.vehicle;

public class vehicleLand extends vehicle {
    private String typeOfLandTransport;

    vehicleLand(){
        super();
        setTypeOfLandTransport("");
    }
    vehicleLand(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                boolean aAvailability, String aTypeOfLandTransport){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber,aAvailability);
        setTypeOfLandTransport(aTypeOfLandTransport);
    }

    private void setTypeOfLandTransport(String aTypeOfLandTransport){
        typeOfLandTransport=aTypeOfLandTransport;
    }

    String getTypeOfLandTransport(){return typeOfLandTransport;}

}
