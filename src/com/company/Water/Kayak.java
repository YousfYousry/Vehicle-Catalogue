package com.company.Water;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Kayak extends vehicleSea{
    private String kayakModel;
    private int hullSpecs;
    private int maxPaddlerWeight;
    private int maxShoeSize;
    private int maxPayload;

    public Kayak(){
        super();
        setKayakModel("");
        setHullSpecs(0);
        setMaxPaddlerWeight(0);
        setMaxShoeSize(0);
        setMaxPayload(0);
    }

    @Override
    public JButton getButton()  {
        JButton view = new JButton("");
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        view.setIcon(new ImageIcon(getScaledImage(img.getImage(), 15, 15)));
        view.addActionListener(e->{
            JPanel holder = new JPanel();
            holder.setLayout(new GridLayout(7,2));


            JLabel aTypeOfWaterTransport = new JLabel("Type Of Water Transport");
            JTextField aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
            JLabel aKayakModel = new JLabel("Kayak Model");
            JTextField aKayakModelField = new JTextField(getKayakModel());
            JLabel aHullSpecs = new JLabel("Hull Specs");
            JTextField aHullSpecsField = new JTextField(getHullSpecs());
            JLabel aMaxPaddlerWeight = new JLabel("Max Paddler Weight");
            JTextField aMaxPaddlerWeightField = new JTextField(getMaxPaddlerWeight());
            JLabel aMaxShoeSize = new JLabel("Max Shoe Size");
            JTextField aMaxShoeSizeField = new JTextField(getMaxShoeSize());
            JLabel aMaxPayload = new JLabel("Max Pay load");
            JTextField aMaxPayloadField = new JTextField(getMaxPayload());

            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(aTypeOfWaterTransport);
            holder.add(aTypeOfWaterTransportField);
            holder.add(aKayakModel);
            holder.add(aKayakModelField);
            holder.add(aHullSpecs);
            holder.add(aHullSpecsField);
            holder.add(aMaxPaddlerWeight);
            holder.add(aMaxPaddlerWeightField);
            holder.add(aMaxShoeSize);
            holder.add(aMaxShoeSizeField);
            holder.add(aMaxPayload);
            holder.add(aMaxPayloadField);


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

    public Kayak(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                 boolean aAvailability, String aTypeOfWaterTransport,String aKayakModel, int aHullSpecs,
                 int aMaxPaddlerWeight, int aMaxShoeSize, int aMaxPayload){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setKayakModel(aKayakModel);
        setHullSpecs(aHullSpecs);
        setMaxPaddlerWeight(aMaxPaddlerWeight);
        setMaxShoeSize(aMaxShoeSize);
        setMaxPayload(aMaxPayload);
    }

    public void setKayakModel(String aKayakModel){kayakModel=aKayakModel;}
    public void setHullSpecs(int aHullSpecs){hullSpecs=aHullSpecs;}
    public void setMaxPaddlerWeight(int aMaxPaddlerWeight){maxPaddlerWeight=aMaxPaddlerWeight;}
    public void setMaxShoeSize(int aMaxShoeSize){maxShoeSize=aMaxShoeSize;}
    public void setMaxPayload(int aMaxPayload){maxPayload=aMaxPayload;}

    public String getKayakModel(){return kayakModel;}
    public String getHullSpecs(){return        Integer.toString(hullSpecs);}
    public String getMaxPaddlerWeight(){return Integer.toString(maxPaddlerWeight);}
    public String getMaxShoeSize(){return      Integer.toString(maxShoeSize);}
    public String getMaxPayload(){return       Integer.toString(maxPayload);}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Water Transport: "+super.getTypeOfWaterTransport()+
                "\nKayak Model: "+getKayakModel()+"\nHull Specs: "+getHullSpecs()+"\nMaximum Paddler Weight: "+getMaxPaddlerWeight()+"\nMaximum Shoe Size: "+
                getMaxShoeSize()+"\nMaximum Payload: "+getMaxPayload();
    }
}