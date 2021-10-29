package com.company.Land;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bike extends vehicleLand{
    private String frameSize;
    private double handlebarWidth;
    private int seat;
    private int gear;
    private String material;

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
            JLabel aFrameSize = new JLabel("Frame Size");
            JTextField aFrameSizeField = new JTextField(getFrameSize());
            JLabel aHandlebarWidth = new JLabel("Handlebar Width");
            JTextField aHandlebarWidthField = new JTextField(getHandlebarWidth());
            JLabel aseat = new JLabel("Seat");
            JTextField aseatField = new JTextField(getSeat());
            JLabel aGear = new JLabel("Gear");
            JTextField aGearField = new JTextField(getGear());
            JLabel aMaterial = new JLabel("Material");
            JTextField aMaterialField = new JTextField(getMaterial());
            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(aTypeOfLandTransport);
            holder.add(aTypeOfLandTransportField);
            holder.add(aFrameSize);
            holder.add(aFrameSizeField);
            holder.add(aHandlebarWidth);
            holder.add(aHandlebarWidthField);
            holder.add(aseat);
            holder.add(aseatField);
            holder.add(aGear);
            holder.add(aGearField);
            holder.add(aMaterial);
            holder.add(aMaterialField);
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

    public Bike(){
        super();
        setFrameSize("");
        setHandlebarWidth(0);
        setSeat(0);
        setGear(0);
        setMaterial("");
    }


    public Bike(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                boolean aAvailability, String aTypeOfLandTransport,String aFrameSize, double aHandlebarWidth,
                int aseat, int aGear, String aMaterial){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfLandTransport);
        setFrameSize(aFrameSize);
        setHandlebarWidth(aHandlebarWidth);
        setSeat(aseat);
        setGear(aGear);
        setMaterial(aMaterial);
    }

    private void setFrameSize(String aFrameSize){frameSize=aFrameSize;}
    private void setHandlebarWidth(double aHandlebarWidth){handlebarWidth=aHandlebarWidth;}
    private void setSeat(int aseat){seat=aseat;}
    private void setGear(int aGear){gear=aGear;}
    private void setMaterial(String aMaterial){material=aMaterial;}

    private String getFrameSize(){return frameSize;}
    private String getHandlebarWidth(){return Double.toString(handlebarWidth);}
    private String getSeat(){return Integer.toString(seat);}
    private String getGear(){return Integer.toString(gear);}
    private String getMaterial(){return material;}

    public String toString(){
        return "\nCategory: "+super.getCategory()+"\nName: "+super.getName()+"\nBrand: "+super.getBrand()+"\nDate Of Production: "+super.getDateOfProduction()+
                "\nID Number: "+super.getIDNumber()+"\nAvailability: "+super.getAvailability()+"\nType of Land Transport: "+super.getTypeOfLandTransport()+
                "\nFrame size: "+getFrameSize()+"\nHandlebar Width: "+getHandlebarWidth()+"cm"+"\nNumber of seat: "+getSeat()+"\nNumber of gear: "+
                getGear()+"\nFrame material: "+getMaterial();
    }
}