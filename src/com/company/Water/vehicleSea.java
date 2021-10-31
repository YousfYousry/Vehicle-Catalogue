package com.company.Water;

import com.company.vehicle;

abstract class vehicleSea extends vehicle {
    private String typeOfWaterTransport;

    vehicleSea(){
        super();
        setTypeOfWaterTransport("");
    }

    vehicleSea(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                      boolean aAvailability, String aTypeOfWaterTransport){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber,aAvailability);
        setTypeOfWaterTransport(aTypeOfWaterTransport);
    }

    private void setTypeOfWaterTransport(String aTypeOfWaterTransport){
        typeOfWaterTransport=aTypeOfWaterTransport;
    }

    String getTypeOfWaterTransport(){return typeOfWaterTransport;}

    @Override
    public String getParentType(){
        return "water";
    }

}