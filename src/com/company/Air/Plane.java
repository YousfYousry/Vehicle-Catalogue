package com.company.Air;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Plane extends vehicleAir {//Source: https://millionmilesecrets.com/guides/difference-between-planes/
    private int numOfDoors;
    private String nose;
    private String wheels;
    private int numOfEngines;

    public Plane() {
        super();
        this.numOfDoors = 0;
        this.nose = "";
        this.wheels = "";
        this.numOfEngines = 0;
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
            JTextField grossWeightField = new JTextField(getGrossWeight());
            JLabel maxTakeoffWeight = new JLabel("Max Take off Weight");
            JTextField maxTakeoffWeightField = new JTextField(getMaxTakeoffWeight());
            JLabel numOfDoors = new JLabel("Num Of Doors");
            JTextField numOfDoorsField = new JTextField(getNumOfDoors());
            JLabel nose = new JLabel("Nose");
            JTextField noseField = new JTextField(getNose());
            JLabel wheels = new JLabel("Wheels");
            JTextField wheelsField = new JTextField(getWheels());
            JLabel numOfEngines = new JLabel("Num Of Engines");
            JTextField numOfEnginesField = new JTextField(getNumOfEngines());
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
            holder.add(numOfDoors);
            holder.add(numOfDoorsField);
            holder.add(nose);
            holder.add(noseField);
            holder.add(wheels);
            holder.add(wheelsField);
            holder.add(numOfEngines);
            holder.add(numOfEnginesField);
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

    public Plane(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String capacity, String length, String height, String volume, String grossWeight, String maxTakeoffWeight, int numOfDoors, String nose, String wheels, int numOfEngines) {
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, capacity, length, height, volume, grossWeight, maxTakeoffWeight);
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
    }

    public Plane(int numOfDoors, String nose, String wheels, int numOfEngines) {
        this.numOfDoors = numOfDoors;
        this.nose = nose;
        this.wheels = wheels;
        this.numOfEngines = numOfEngines;
    }


    public String getNumOfDoors() {
        return Integer.toString(numOfDoors);
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getNumOfEngines() {
        return Integer.toString(numOfEngines);
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }
}
