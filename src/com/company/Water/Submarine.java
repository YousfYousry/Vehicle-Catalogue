package com.company.Water;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Submarine extends vehicleSea{
    private String submarineClass;
    private double submergedDisplacement;
    private int endurance;
    private boolean airIndependentPropulsion;
    private boolean permanentMagnetMotor;

    public Submarine(){
        super();
        setSubmarineClass("");
        setSubmergedDisplacement(0);
        setEndurance(0);
        setAirIndependentPropulsion(false);
        setPermanentMagnetMotor(false);
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
            JLabel aSubmarineClass = new JLabel("Submarine Class");
            JTextField aSubmarineClassField = new JTextField(getSubmarineClass());
            JLabel aSubmergedDisplacement = new JLabel("Submerged Displacement");
            JTextField aSubmergedDisplacementField = new JTextField(getSubmergedDisplacement());
            JLabel aEndurance = new JLabel("Endurance");
            JTextField aEnduranceField = new JTextField(getEndurance());
            JLabel aAirIndependentPropulsion = new JLabel("Air Independent Propulsion");
            JTextField aAirIndependentPropulsionField = new JTextField(getAirIndependentPropulsion());
            JLabel aPermanentMagnetMotor = new JLabel("Permanent Magnet Motor");
            JTextField aPermanentMagnetMotorField = new JTextField(getPermanentMagnetMotor());

            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

            holder.add(aTypeOfWaterTransport);
            holder.add(aTypeOfWaterTransportField);
            holder.add(aSubmarineClass);
            holder.add(aSubmarineClassField);
            holder.add(aSubmergedDisplacement);
            holder.add(aSubmergedDisplacementField);
            holder.add(aEndurance);
            holder.add(aEnduranceField);
            holder.add(aAirIndependentPropulsion);
            holder.add(aAirIndependentPropulsionField);
            holder.add(aPermanentMagnetMotor);
            holder.add(aPermanentMagnetMotorField);


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

    public Submarine(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                     boolean aAvailability, String aTypeOfWaterTransport,String aSubmarineClass, double aSubmergedDisplacement,
                     int aEndurance, boolean aAirIndependentPropulsion, boolean aPermanentMagnetMotor){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setSubmarineClass(aSubmarineClass);
        setSubmergedDisplacement(aSubmergedDisplacement);
        setEndurance(aEndurance);
        setAirIndependentPropulsion(aAirIndependentPropulsion);
        setPermanentMagnetMotor(aPermanentMagnetMotor);
    }

    public void setSubmarineClass(String aSubmarineClass){submarineClass=aSubmarineClass;}
    public void setSubmergedDisplacement(double aSubmergedDisplacement){submergedDisplacement=aSubmergedDisplacement;}
    public void setEndurance(int aEndurance){endurance=aEndurance;}
    public void setAirIndependentPropulsion(boolean aAirIndependentPropulsion){airIndependentPropulsion=aAirIndependentPropulsion;}
    public void setPermanentMagnetMotor(boolean aPermanentMagnetMotor){permanentMagnetMotor=aPermanentMagnetMotor;}

    public String getSubmarineClass(){return submarineClass;}
    public String getSubmergedDisplacement(){return Double.toString(submergedDisplacement);}
    public String getEndurance(){return Integer.toString(endurance);}
    public String getAirIndependentPropulsion(){
        if(airIndependentPropulsion){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    public String getPermanentMagnetMotor(){
        if(permanentMagnetMotor){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}