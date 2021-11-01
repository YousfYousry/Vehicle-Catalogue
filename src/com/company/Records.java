package com.company;

import com.company.Air.Helicopter;
import com.company.Air.Plane;
import com.company.Air.Rocket;
import com.company.Land.Bike;
import com.company.Land.Car;
import com.company.Land.Train;
import com.company.Water.Kayak;
import com.company.Water.ShippingTanker;
import com.company.Water.Submarine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Records {
    private static String fileName = System.getProperty("user.dir") + "\\assets\\Records.txt";

    private static ArrayList<vehicle> currentRecords = getOriginal();

    public static boolean hasChanges() {
        return !diff(currentRecords.toString(), getOriginal().toString()).isEmpty();
    }

    private static String diff(String str1, String str2) {
        int i;
        for (i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) break;
        }
        return str1.substring(i, str1.length());
    }

    public static void addRecord(vehicle vehicle) {
        currentRecords.add(vehicle);
    }

    static void deleteRecord(vehicle vehicle) {
        currentRecords.remove(vehicle);
    }

    public static void deleteAllRecord() {
        currentRecords.clear();
    }

    public static ArrayList<vehicle> getAllRecords() {
        return currentRecords;

//        commented these to avoid styling for easier copying
//        Helicopter a      = new Helicopter("Helicopter", "Sikorsky UH-60 Black Hawk", "Sikorsky", 8,8,2012, "HC123", true, "2 Pilot + 12 Passengers", "35.1 ft", "10.3 ft","579 l", "5300 kg","5600 kg", 5 , 14,"Allison Model 250","280km/h");
//        Helicopter b      = new Helicopter("Helicopter", "Kikorsky UH-20 Black Bird", "Kikorsky",18,8,2010, "HC124", false,"2 Pilot + 5 Passengers",  "25.1 ft", "8.35 ft","389 l", "4200 kg","4500 kg", 4 , 7, "Allison Model 210","220km/h");
//        Helicopter c      = new Helicopter("Helicopter", "Cikorsky UH-20 Black Bat",  "Cikorsky",28,9,2011, "HC125", true, "2 Pilot + 6 Passengers",  "27.5 ft", "9.3 ft", "489 l", "5200 kg","5300 kg", 5 , 14,"Allison Model 220","250km/h");
//        Plane d           = new Plane("Plane","Hawker Hurricane", "MIC Airplane",9,9,2009,"AR456", true, "1 Pilot ", "135.1 ft", "110.3 ft","1579 l", "15300 kg","15600 kg", 2,"rounded nose","Armory AW32403",1);
//        Plane e           = new Plane("Plane","B-52 Stratofortress", "ABB Airplane",19,9,2003,"AR457", true, "2 Pilot ", "134.5 ft", "102.3 ft","1539 l", "14300 kg","14600 kg", 2,"pointed nose","Armory AW31011",2 );
//        Plane f           = new Plane("Plane","MiG-21 fighter", "LLA Airplane",14,9,2005,"AR458", false, "1 Pilot ", "122.6 ft", "105.3 ft","1559 l", "14500 kg","14680 kg", 2,"rounded nose","Armory AW32022",1);
//        Rocket g          = new Rocket("Rocket","Firefly Alpha", "Firefly",2,2,2002,"RK787", true, "1 Pilot ", "1135.1 ft", "1110.3 ft","11579 l", "115300 kg","115600 kg", "Firefly Aerospace","United State","2021",1);
//        Rocket h          = new Rocket("Rocket","Lirefly Beta", "Lirefly",12,2,2012,"RK788", false, "1 Pilot ", "1035.2 ft", "1210.4 ft","12579 l", "125300 kg","117000 kg", "Lirefly Aerospace","Malaysia","2020;",5);
//        Rocket i          = new Rocket("Rocket","Virefly Alpha", "Virefly",2,12,2014,"RK789", true, "1 Pilot ", "1155.4 ft", "1010.5 ft","15579 l", "119300 kg","12000 kg", "Virefly Aerospace","Japan","2019",1);
//        Submarine j       = new Submarine("Submarine","W-Sub3", "Bringe",1,12,2012,"SB012", true, "Ocean water  ", "Ballistic missile submarines", 3400 , 70 , true, true );
//        Submarine k       = new Submarine("Submarine","NOVA Semi-Submarine", "Subvers",12,12,2011,"SB013", true, "Ocean water  ", "Cruise missile submarines", 3500 , 80 , false, true );
//        Submarine l       = new Submarine("Submarine","Seabreacher-Z Model", "Dolphinics",10,12,2010,"SB014", false, "Ocean water  ", "Midget submarines", 2400 , 50 , true, false );
//        ShippingTanker m  = new ShippingTanker ("Shipping Tanker","PACIFIC 08", "ITC CORP",12,10,2012,"TK345", false, "Ocean water ", "Panamax", 205 , 29 , 16, 50000 );
//        ShippingTanker  n = new ShippingTanker("Shipping Tanker","Stena Palva", "Brodosplit",22,12,2002,"TK346", true, "Ocean water ", "Aframax", 245 , 34 , 20, 80000 );
//        ShippingTanker  o = new ShippingTanker("Shipping Tanker","PROSPER PHOENIX", "MITSUI",10,10,2010,"TK347", true, "Ocean water ", "Suezmax", 285 , 45 , 23, 180000 );
//        Kayak p           = new Kayak("Kayak","NuCanoe fishing ", "Dutchland",15,1,2016,"KY678", false, "Inland water ", "Wood Duck", 36 , 200 , 13, 250 );
//        Kayak q           = new Kayak("Kayak","LIFETIME LANCER 100", "Lifetime",15,12,2019,"KY679", false, "Inland water ", "Wood Duck 2", 38 , 202 , 15, 260 );
//        Kayak r           = new Kayak("Kayak","Ventura Inflatable ", "Bestway",25,1,2019,"KY680", true, "Inland water ", "Pax 20", 40 , 212 , 18, 300 );
//        Car s             = new Car("Car","Vios", "Toyota",15,11,2020,"CR901", false,"Road" ,"GX", 300, 5 , 5, "Sedan" );
//        Car t             = new Car("Car","City", "Honda",25,5,2021,"CR902", true,"Road" ,"S+", 320, 5 , 6, "Hatchback" );
//        Car u             = new Car("Car","Mustang", "Ford",15,1,2019,"CR903", true,"Road" ,"A", 250, 4 , 8, "Coupe" );
//        Train v           = new Train("Train","Sirio Florence", "Hitachi",15,11,2010,"TR234", true,"Track" ,300, 12, 35 , 3, "Tram" );
//        Train w           = new Train("Train","Sirio Zhuhai ", "Toshiba",5,10,2011,"TR234", true,"Track" ,298, 11, 45 , 4, "Tram" );
//        Train x           = new Train("Train","Sirio Turin ", "Sonnic",25,1,2012,"TR235", false,"Track" ,292, 10, 55 , 5, "Tram" );
//        Bike y            = new Bike ("Bike","PARALANE 9.8", "Focus",27,11,2017,"BK234", true,"Road" ,"XL", 72.5, 1 , 5, "carbon" );
//        Bike z            = new Bike ("Bike","ATLAS CARBON", "Alchemy ",22,5,2018,"BK235", true,"Road" ,"L", 65.7, 2 , 4, "carbon" );
//        Bike yay          = new Bike ("Bike","PLANET 6.9", "Jorden ",28,5,2020,"BK236", false,"Road" ,"M", 56.4, 2 , 4, "aluminium" );
    }

    public static void reset() {

        currentRecords = getOriginal();

    }

    public static void setHardCoded() {
        currentRecords = getHardCoded();
    }

    private static vehicle getVehicle(ArrayList<String> values) {
        try {
            if (values.get(0).compareTo("Helicopter") == 0) {
                return new Helicopter(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), getInt(values.get(14)), getInt(values.get(15)), values.get(16), values.get(17));
            } else if (values.get(0).compareTo("Plane") == 0) {
                return new Plane(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), getInt(values.get(14)), values.get(15), values.get(16), getInt(values.get(17)));
            } else if (values.get(0).compareTo("Rocket") == 0) {
                return new Rocket(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), values.get(10), values.get(11), values.get(12), values.get(13), values.get(14), values.get(15), values.get(16), getInt(values.get(17)));
            } else if (values.get(0).compareTo("Bike") == 0) {
                return new Bike(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), getDouble(values.get(10)), getInt(values.get(11)), getInt(values.get(12)), values.get(13));
            } else if (values.get(0).compareTo("Car") == 0) {
                return new Car(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), getDouble(values.get(10)), getInt(values.get(11)), getInt(values.get(12)), values.get(13));
            } else if (values.get(0).compareTo("Train") == 0) {
                return new Train(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), getInt(values.get(9)), getInt(values.get(10)), getInt(values.get(11)), getInt(values.get(12)), values.get(13));
            } else if (values.get(0).compareTo("Kayak") == 0) {
                return new Kayak(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), getInt(values.get(10)), getInt(values.get(11)), getInt(values.get(12)), getInt(values.get(13)));
            } else if (values.get(0).compareTo("Shipping Tanker") == 0) {
                return new ShippingTanker(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), getInt(values.get(10)), getInt(values.get(11)), getInt(values.get(12)), getDouble(values.get(13)));
            } else if (values.get(0).compareTo("Submarine") == 0) {
                return new Submarine(values.get(0), values.get(1), values.get(2), getInt(values.get(3)), getInt(values.get(4)) + 1, getInt(values.get(5)), values.get(6), getBool(values.get(7)), values.get(8), values.get(9), getDouble(values.get(10)), getInt(values.get(11)), getBool(values.get(12)), getBool(values.get(13)));
            } else {
                return null;
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    private static int getInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception error) {
            return 0;
        }
    }

    private static boolean getBool(String str) {
        str = str.trim().toLowerCase();
        return str.compareTo("true") == 0 || str.compareTo("yes") == 0;
    }

    private static double getDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception error) {
            return 0;
        }
    }

    private static ArrayList<vehicle> getOriginal() {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            StringBuilder data = new StringBuilder();
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine()).append("\n");
//                System.out.println(data);
            }
            myReader.close();
//            System.out.println(data);
            ArrayList<vehicle> vehicles = new ArrayList<>();
            String orig = data.substring(1, data.length() - 1);
            ArrayList<String> myList = new ArrayList<>(Arrays.asList(orig.split(",")));
            for (String recordStr : myList) {
                ArrayList<String> values = new ArrayList<>();
                for (String value : recordStr.split("\n", -1)) {
                    values.add(value.trim());
                }
                vehicle vehicle = getVehicle(values);
                if (vehicle != null) vehicles.add(vehicle);
            }
            return vehicles;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return getHardCoded();
        }

    }

    private static ArrayList<vehicle> getHardCoded() {
        ArrayList<vehicle> records = new ArrayList<>();
        records.add(new Helicopter("Helicopter", "Sikorsky UH-60 Black Hawk", "Sikorsky", 8, 8, 2012, "HC123", true, "2 Pilot + 12 Passengers", "35.1 ft", "10.3 ft", "579 l", "5300 kg", "5600 kg", 5, 14, "Allison Model 250", "280km/h"));
        records.add(new Helicopter("Helicopter", "Kikorsky UH-20 Black Bird", "Kikorsky", 18, 8, 2010, "HC124", false, "2 Pilot + 5 Passengers", "25.1 ft", "8.35 ft", "389 l", "4200 kg", "4500 kg", 4, 7, "Allison Model 210", "220km/h"));
        records.add(new Helicopter("Helicopter", "Cikorsky UH-20 Black Bat", "Cikorsky", 28, 9, 2011, "HC125", true, "2 Pilot + 6 Passengers", "27.5 ft", "9.3 ft", "489 l", "5200 kg", "5300 kg", 5, 14, "Allison Model 220", "250km/h"));
        records.add(new Plane("Plane", "Hawker Hurricane", "MIC Airplane", 9, 9, 2009, "AR456", true, "1 Pilot", "135.1 ft", "110.3 ft", "1579 l", "15300 kg", "15600 kg", 2, "rounded nose", "Armory AW32403", 1));
        records.add(new Plane("Plane", "B-52 Stratofortress", "ABB Airplane", 19, 9, 2003, "AR457", true, "2 Pilot", "134.5 ft", "102.3 ft", "1539 l", "14300 kg", "14600 kg", 2, "pointed nose", "Armory AW31011", 2));
        records.add(new Plane("Plane", "MiG-21 fighter", "LLA Airplane", 14, 9, 2005, "AR458", false, "1 Pilot", "122.6 ft", "105.3 ft", "1559 l", "14500 kg", "14680 kg", 2, "rounded nose", "Armory AW32022", 1));
        records.add(new Rocket("Rocket", "Firefly Alpha", "Firefly", 2, 2, 2002, "RK787", true, "1 Pilot", "1135.1 ft", "1110.3 ft", "11579 l", "115300 kg", "115600 kg", "Firefly Aerospace", "United State", "2021", 1));
        records.add(new Rocket("Rocket", "Lirefly Beta", "Lirefly", 12, 2, 2012, "RK788", false, "1 Pilot", "1035.2 ft", "1210.4 ft", "12579 l", "125300 kg", "117000 kg", "Lirefly Aerospace", "Malaysia", "2020", 5));
        records.add(new Rocket("Rocket", "Virefly Alpha", "Virefly", 2, 12, 2014, "RK789", true, "1 Pilot", "1155.4 ft", "1010.5 ft", "15579 l", "119300 kg", "12000 kg", "Virefly Aerospace", "Japan", "2019", 1));
        records.add(new Submarine("Submarine", "W-Sub3", "Bringe", 1, 12, 2012, "SB012", true, "Ocean water", "Ballistic missile submarines", 3400, 70, true, true));
        records.add(new Submarine("Submarine", "NOVA Semi-Submarine", "Subvers", 12, 12, 2011, "SB013", true, "Ocean water", "Cruise missile submarines", 3500, 80, false, true));
        records.add(new Submarine("Submarine", "Seabreacher-Z Model", "Dolphinics", 10, 12, 2010, "SB014", false, "Ocean water", "Midget submarines", 2400, 50, true, false));
        records.add(new ShippingTanker("Shipping Tanker", "PACIFIC 08", "ITC CORP", 12, 10, 2012, "TK345", false, "Ocean water", "Panamax", 205, 29, 16, 50000));
        records.add(new ShippingTanker("Shipping Tanker", "Stena Palva", "Brodosplit", 22, 12, 2002, "TK346", true, "Ocean water", "Aframax", 245, 34, 20, 80000));
        records.add(new ShippingTanker("Shipping Tanker", "PROSPER PHOENIX", "MITSUI", 10, 10, 2010, "TK347", true, "Ocean water", "Suezmax", 285, 45, 23, 180000));
        records.add(new Kayak("Kayak", "NuCanoe fishing", "Dutchland", 15, 1, 2016, "KY678", false, "Inland water", "Wood Duck", 36, 200, 13, 250));
        records.add(new Kayak("Kayak", "LIFETIME LANCER 100", "Lifetime", 15, 12, 2019, "KY679", false, "Inland water", "Wood Duck 2", 38, 202, 15, 260));
        records.add(new Kayak("Kayak", "Ventura Inflatable", "Bestway", 25, 1, 2019, "KY680", true, "Inland water", "Pax 20", 40, 212, 18, 300));
        records.add(new Car("Car", "Vios", "Toyota", 15, 11, 2020, "CR901", false, "Road", "GX", 300, 5, 5, "Sedan"));
        records.add(new Car("Car", "City", "Honda", 25, 5, 2021, "CR902", true, "Road", "S+", 320, 5, 6, "Hatchback"));
        records.add(new Car("Car", "Mustang", "Ford", 15, 1, 2019, "CR903", true, "Road", "A", 250, 4, 8, "Coupe"));
        records.add(new Train("Train", "Sirio Florence", "Hitachi", 15, 11, 2010, "TR234", true, "Track", 300, 12, 35, 3, "Tram"));
        records.add(new Train("Train", "Sirio Zhuhai", "Toshiba", 5, 10, 2011, "TR234", true, "Track", 298, 11, 45, 4, "Tram"));
        records.add(new Train("Train", "Sirio Turin", "Sonnic", 25, 1, 2012, "TR235", false, "Track", 292, 10, 55, 5, "Tram"));
        records.add(new Bike("Bike", "PARALANE 9.8", "Focus", 27, 11, 2017, "BK234", true, "Road", "XL", 72.5, 1, 5, "carbon"));
        records.add(new Bike("Bike", "ATLAS CARBON", "Alchemy", 22, 5, 2018, "BK235", true, "Road", "L", 65.7, 2, 4, "carbon"));
        records.add(new Bike("Bike", "PLANET 6.9", "Jorden", 28, 5, 2020, "BK236", false, "Road", "M", 56.4, 2, 4, "aluminium"));
        return records;
    }

    public static void saveNewOriginal() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.println(currentRecords.toString());
        pw.close();
    }

    public static ArrayList<vehicle> filterRecords(String type, String availability, Date from, Date to) {
        ArrayList<vehicle> records = new ArrayList<>();
        for (vehicle vehicle : getAllRecords()) {
            if ((vehicle.getParentType().contains(type) || type.contains("all")) && (vehicle.getAvailability() == (availability.compareTo("available") == 0) || availability.contains("all")) && (vehicle.getDateOfProduction().compareTo(from) > 0 && vehicle.getDateOfProduction().compareTo(to) < 0)) {
                records.add(vehicle);
            }
        }
        return records;
    }
}
