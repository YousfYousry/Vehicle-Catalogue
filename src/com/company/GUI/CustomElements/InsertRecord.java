package com.company.GUI.CustomElements;

import com.company.Air.Helicopter;
import com.company.Air.Plane;
import com.company.Air.Rocket;
import com.company.Land.Bike;
import com.company.Land.Car;
import com.company.Land.Train;
import com.company.Water.Kayak;
import com.company.Water.ShippingTanker;
import com.company.Water.Submarine;
import com.company.vehicle;

import javax.swing.*;

public class InsertRecord extends JPanel {
    private vehicle vehicle = new Helicopter();
    private JPanel currentView;
    public JPanel getView(){
        return currentView;
    }

    public vehicle getVehicle() {
        return vehicle;
    }

    public InsertRecord() {
        this.currentView = vehicle.getView();
    }

//    public void addView(JPanel child1){
//        add(child1);
////        add(view);
//    }

    public void listener(String selectedType) {
        SwingUtilities.invokeLater(() -> {
            remove(currentView);

            this.vehicle=getType(selectedType);
            currentView=vehicle.getView();
            add(currentView);
            invalidate();
            validate();
        });
    }

    private vehicle getType(String selectedType){
        if(selectedType.compareTo("Helicopter")==0){
            return new Helicopter();
        }else if(selectedType.compareTo("Plane")==0){
            return new Plane();

        }else if(selectedType.compareTo("Rocket")==0){
            return new Rocket();

        }else if(selectedType.compareTo("Bike")==0){
            return new Bike();

        }else if(selectedType.compareTo("Car")==0){
            return new Car();

        }else if(selectedType.compareTo("Train")==0){
            return new Train();

        }else if(selectedType.compareTo("Kayak")==0){
            return new Kayak();

        }else if(selectedType.compareTo("Shipping Tanker")==0){
            return new ShippingTanker();

        }else if(selectedType.compareTo("Submarine")==0){
            return new Submarine();
        }else {
            return new Helicopter();
        }
    }
}
