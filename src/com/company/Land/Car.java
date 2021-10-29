package com.company.Land;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Car extends vehicleLand{
    private String carModel;
    private double bootSize;
    private int seat;
    private int airBag;
    private String typeOfCar;

    public Car(){
        super();
        setCarModel("");
        setBootSize(0);
        setSeat(0);
        setAirBag(0);
        setTypeOfCar("");
    }

    @Override
    public JButton getButton()  {
        JButton view = new JButton("");
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        view.setIcon(new ImageIcon(getScaledImage(img.getImage(), 15, 15)));
        view.addActionListener(e->{
            JPanel holder = new JPanel();
            holder.setLayout(new GridLayout(7,2));


            JLabel aTypeOfLandTransport=new JLabel("Type Of Land Transport");
            JTextField aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
            JLabel acarModel=new JLabel("Car Model");
            JTextField acarModelField = new JTextField(getCarModel());
            JLabel abootSize=new JLabel("Boot Size");
            JTextField abootSizeField = new JTextField(getBootSize());
            JLabel aseat=new JLabel("Seat");
            JTextField aseatField = new JTextField(getSeat());
            JLabel aAirBag=new JLabel("Air Bag");
            JTextField aAirBagField = new JTextField(getAirBag());
            JLabel atypeOfCar=new JLabel("Type Of Car");
            JTextField atypeOfCarField = new JTextField(getTypeOfCar());

            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(aTypeOfLandTransport);
            holder.add(aTypeOfLandTransportField);
            holder.add(acarModel);
            holder.add(acarModelField);
            holder.add(abootSize);
            holder.add(abootSizeField);
            holder.add(aseat);
            holder.add(aseatField);
            holder.add(aAirBag);
            holder.add(aAirBagField);
            holder.add(atypeOfCar);
            holder.add(atypeOfCarField);

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

    public Car(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
               boolean aAvailability, String aTypeOfLandTransport,String acarModel, double abootSize,
               int aseat, int aAirBag, String atypeOfCar){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setCarModel(acarModel);
        setBootSize(abootSize);
        setSeat(aseat);
        setAirBag(aAirBag);
        setTypeOfCar(atypeOfCar);
    }

    private void setCarModel(String acarModel){carModel=acarModel;}
    private void setBootSize(double abootSize){bootSize=abootSize;}
    private void setSeat(int aseat){seat=aseat;}
    private void setAirBag(int aAirBag){airBag=aAirBag;}
    private void setTypeOfCar(String atypeOfCar){typeOfCar=atypeOfCar;}

    private String getCarModel(){return carModel;}
    private String getBootSize(){return Double.toString(bootSize);}
    private String getSeat(){return Integer.toString(seat);}
    private String getAirBag(){return Integer.toString(airBag);}
    private String getTypeOfCar(){return typeOfCar;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nCar Model: "+getCarModel()+"\nBoot size: "+getBootSize()+"\nNumber of seat: "+getSeat()+"\nNumber of airbag: "+
                getAirBag()+"\nType of car: "+getTypeOfCar();
    }
}