package com.company.Land;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Train extends vehicleLand{
    private int maxSpeed;
    private int longOfTrain;
    private int passenger;
    private int body;
    private String typeOfTrain;

    public Train(){
        super();
        setMaxSpeed(0);
        setLong(0);
        setPassenger(0);
        setBody(0);
        setTypeOfTrain("");
    }

    @Override
    public JButton getButton()  {
        JButton view = new JButton("");
        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\assets\\view.png");
        view.setIcon(new ImageIcon(getScaledImage(img.getImage(), 15, 15)));
        view.addActionListener(e->{
            JPanel holder = new JPanel();
            holder.setLayout(new GridLayout(7,2));

            JLabel aTypeOfLandTransport = new JLabel("Type Of Land Transport");
            JTextField aTypeOfLandTransportField = new JTextField(getTypeOfLandTransport());
            JLabel aMaxSpeed = new JLabel("Max Speed");
            JTextField aMaxSpeedField = new JTextField(getMaxSpeed());
            JLabel aLongOfTrain = new JLabel("Long Of Train");
            JTextField aLongOfTrainField = new JTextField(getLong());
            JLabel aPassenger = new JLabel("Passenger");
            JTextField aPassengerField = new JTextField(getPassenger());
            JLabel aBody = new JLabel("Body");
            JTextField aBodyField = new JTextField(getBody());
            JLabel atypeOfTrain = new JLabel("Type Of Train");
            JTextField atypeOfTrainField = new JTextField(getTypeOfTrain());


            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(aTypeOfLandTransport);
            holder.add(aTypeOfLandTransportField);
            holder.add(aMaxSpeed);
            holder.add(aMaxSpeedField);
            holder.add(aLongOfTrain);
            holder.add(aLongOfTrainField);
            holder.add(aPassenger);
            holder.add(aPassengerField);
            holder.add(aBody);
            holder.add(aBodyField);
            holder.add(atypeOfTrain);
            holder.add(atypeOfTrainField);

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

    public Train(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                 boolean aAvailability, String aTypeOfLandTransport,int aMaxSpeed, int aLongOfTrain,
                 int aPassenger, int aBody, String atypeOfTrain){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setMaxSpeed(aMaxSpeed);
        setLong(aLongOfTrain);
        setPassenger(aPassenger);
        setBody(aBody);
        setTypeOfTrain(atypeOfTrain);
    }

    private void setMaxSpeed(int aMaxSpeed){maxSpeed=aMaxSpeed;}
    private void setLong(int aLongOfTrain){longOfTrain=aLongOfTrain;}
    private void setPassenger(int aPassenger){passenger=aPassenger;}
    private void setBody(int aBody){body=aBody;}
    private void setTypeOfTrain(String atypeOfTrain){typeOfTrain=atypeOfTrain;}

    private String getMaxSpeed(){return  Integer.toString(maxSpeed);}
    private String getLong(){return      Integer.toString(longOfTrain);}
    private String getPassenger(){return Integer.toString(passenger);}
    private String getBody(){return      Integer.toString(body);}
    private String getTypeOfTrain(){return typeOfTrain;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nMaximum speed: "+getMaxSpeed()+"mph" +"\nLong : "+getLong()+"meter"+"\nNumber of passenger: "+getPassenger()+"\nNumber of body: "+
                getBody()+"\nType of Train: "+getTypeOfTrain();
    }
}