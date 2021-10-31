package com.company;

//import com.company.Water.vehicle;

import java.util.*;

public class vehicleStorage {
    private ArrayList<vehicle> allVehicles;

    public vehicleStorage(){
        allVehicles=new ArrayList<vehicle>();
    }

    public void addToVehicleStorage(vehicle aVehicle) {
        allVehicles.add(aVehicle);
    }

    public Iterator getVehicleStorage(){
        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehicles.size();
            }
            public vehicle next(){
                return allVehicles.get(current++);
            }
        };
    }
    public Iterator getVehicleStorageByCategory(String aCategory){
        ArrayList<vehicle> allVehiclesByCategory= new ArrayList<vehicle>();
        for(vehicle v: allVehicles){
            if(v.getCategory().equalsIgnoreCase(aCategory)){
                allVehiclesByCategory.add(v);
            }
        }

        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehiclesByCategory.size();
            }
            public vehicle next(){
                return allVehiclesByCategory.get(current++);
            }
        };
    }
    public Iterator getVehicleStorageByName(String aName){
        ArrayList<vehicle> allVehiclesByName= new ArrayList<vehicle>();
        for(vehicle v: allVehicles){
            if(v.getName().equalsIgnoreCase(aName)){
                allVehiclesByName.add(v);
            }
        }

        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehiclesByName.size();
            }
            public vehicle next(){
                return allVehiclesByName.get(current++);
            }
        };
    }
    public Iterator getVehicleStorageByBrand(String aBrand){
        ArrayList<vehicle> allVehiclesByBrand= new ArrayList<vehicle>();
        for(vehicle v: allVehicles){
            if(v.getName().equalsIgnoreCase(aBrand)){
                allVehiclesByBrand.add(v);
            }
        }

        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehiclesByBrand.size();
            }
            public vehicle next(){
                return allVehiclesByBrand.get(current++);
            }
        };
    }
    public Iterator getVehicleStorageByDateOfProduction(int aDay, int aMonth, int aYear){
        Date targetDate=new Date(aYear,aMonth,aDay);
        ArrayList<vehicle> allVehiclesByDateOfProduction= new ArrayList<vehicle>();
        String targetDateString=targetDate.getDay()+"-"+targetDate.getMonth()+"-"+targetDate.getYear();
        for(vehicle v: allVehicles){
//            if(v.getDateOfProduction().equalsIgnoreCase(targetDateString)){
//                allVehiclesByDateOfProduction.add(v);
//            }
        }

        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehiclesByDateOfProduction.size();
            }
            public vehicle next(){
                return allVehiclesByDateOfProduction.get(current++);
            }
        };
    }
    public Iterator getVehicleStorageByIDNumber(String aIDNumber){
        ArrayList<vehicle> allVehiclesByIDNumber= new ArrayList<vehicle>();
        for(vehicle v: allVehicles){
            if(v.getName().equalsIgnoreCase(aIDNumber)){
                allVehiclesByIDNumber.add(v);
            }
        }

        return new Iterator<vehicle>(){
            private int current= 0;
            public boolean hasNext(){
                return current < allVehiclesByIDNumber.size();
            }
            public vehicle next(){
                return allVehiclesByIDNumber.get(current++);
            }
        };
    }
}