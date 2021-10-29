package com.company.Air;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rocket extends vehicleAir {//Source: https://en.wikipedia.org/wiki/Comparison_of_orbital_launch_systems
    private String manufacturer;
    private String origin;
    private String firstDateOfFlight;
    private int numOfFailures;

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
            JTextField grossWeightField = new JTextField(getGrossWeight());
            JLabel maxTakeoffWeight = new JLabel("Max Take off Weight");
            JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
            JLabel manufacturer = new JLabel("Manufacturer");
            JTextField manufacturerField = new JTextField(getManufacturer());
            JLabel origin = new JLabel("Origin");
            JTextField originField = new JTextField(getOrigin());
            JLabel firstDateOfFlight = new JLabel("First Date Of Flight");
            JTextField firstDateOfFlightField = new JTextField(getFirstDateOfFlight());
            JLabel numOfFailures = new JLabel("Num Of Failures");
            JTextField numOfFailuresField = new JTextField(getNumOfFailures());
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
            holder.add(manufacturer);
            holder.add(manufacturerField);
            holder.add(origin);
            holder.add(originField);
            holder.add(firstDateOfFlight);
            holder.add(firstDateOfFlightField);
            holder.add(numOfFailures);
            holder.add(numOfFailuresField);
            holder.add(delete);
            holder.add(update);

            JOptionPane.showOptionDialog(null, holder, getCategory() + " Details", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });
        return view;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

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

    public String getNumOfFailures() {
        return Integer.toString(numOfFailures);
    }

    public void setNumOfFailures(int numOfFailures) {
        this.numOfFailures = numOfFailures;
    }
}
