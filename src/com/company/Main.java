package com.company;
import com.company.GUI.Launcher;
import com.company.Water.Kayak;
import com.company.Water.ShippingTanker;
import com.company.Water.Submarine;

import java.util.ArrayList;

public class Main {
   public static ArrayList<Object> vehicles = new ArrayList<>();

    public static void main(String[] args) {
       vehicles.add(new Kayak());
       vehicles.add(new ShippingTanker());
       vehicles.add(new Submarine());
       vehicles.add(new Kayak());
       vehicles.add(new Submarine());

        new Launcher();
    }
}
