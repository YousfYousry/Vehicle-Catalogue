package com.company.Air;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Helicopter extends vehicleAir {//Source: https://www.aircharterservice.com/about-us/news-features/blog/top-private-helicopters
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

    @Override
    public JButton getButton() {
        JButton view = new JButton("");
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        view.setIcon(new ImageIcon(getScaledImage(img.getImage(), 15, 15)));
        view.addActionListener(e -> {
            JPanel holder = new JPanel();
            holder.setLayout(new GridLayout(11, 2));

            JLabel capacity = new JLabel("Capacity");
            JTextField capacityField = new JTextField(getCapacity());
            JLabel length = new JLabel("Length");
            JTextField lengthField = new JTextField(getLength());
            JLabel height = new JLabel("Height");
            JTextField heightField = new JTextField(getHeight());
            JLabel volume = new JLabel("Volume");
            JTextField volumeField = new JTextField(getVolume());
            JLabel grossWeight = new JLabel("Gross Weight");
            JTextField grossWeightField = new JTextField(getHeight());
            JLabel maxTakeoffWeight = new JLabel("Max Take off Weight");
            JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
            JLabel distance = new JLabel("Distance");
            JTextField distanceField = new JTextField(getDistance());
            JLabel numOfSeats = new JLabel("Num Of Seats");
            JTextField numOfSeatsField = new JTextField(getNumOfSeats());
            JLabel engine = new JLabel("Engine");
            JTextField engineField = new JTextField(getEngine());
            JLabel speed = new JLabel("Speed");
            JTextField speedField = new JTextField(getSpeed());
            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(capacity);
            holder.add(capacityField);
            holder.add(length);
            holder.add(lengthField);
            holder.add(height);
            holder.add(heightField);
            holder.add(volume);
            holder.add(volumeField);
            holder.add(grossWeight);
            holder.add(grossWeightField);
            holder.add(maxTakeoffWeight);
            holder.add(maxTakeoffWeightField);
            holder.add(distance);
            holder.add(distanceField);
            holder.add(numOfSeats);
            holder.add(numOfSeatsField);
            holder.add(engine);
            holder.add(engineField);
            holder.add(speed);
            holder.add(speedField);
            holder.add(delete);
            holder.add(update);
            JOptionPane.showOptionDialog(null, holder, getCategory()+" Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });
        return view;
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

    public String getDistance() {
        return Integer.toString(distance);
    }

    public String getNumOfSeats() {
        return Integer.toString(numOfSeats);
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


    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
