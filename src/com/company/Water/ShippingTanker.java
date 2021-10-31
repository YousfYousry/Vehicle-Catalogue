package com.company.Water;

import javax.swing.*;
import java.awt.*;

public class ShippingTanker extends vehicleSea{
    private String shippingTankerClass;
    private int length;
    private int beam;
    private int draft;
    private double deadWeightTons;

    public ShippingTanker(){
        super();
        setShippingTankerClass("");
        setLength(0);
        setBeam(0);
        setDraft(0);
        setDeadWeightTons(0);
    }
    private JTextField aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
    private JTextField aShippingTankerClassField = new JTextField(getShippingTankerClass());
    private JTextField aLengthField = new JTextField(getLength());
    private JTextField aBeamField = new JTextField(getBeam());
    private JTextField aDraftField = new JTextField(getDraft());
    private JTextField aDeadWeightTonsField = new JTextField(getDeadWeightTons());

    @Override
    public JPanel getView() {
        JPanel holder = new JPanel();
        holder.setLayout(new GridLayout(6,2));

        JLabel aTypeOfWaterTransport = new JLabel("Type Of Water Transport");
        JLabel aShippingTankerClass = new JLabel("Shipping Tanker Class");
        JLabel aLength = new JLabel("Length");
        JLabel aBeam = new JLabel("Beam");
        JLabel aDraft = new JLabel("Draft");
        JLabel aDeadWeightTons = new JLabel("Dead Weight Tons");

//        JButton delete = new JButton("Delete");
//        JButton update = new JButton("Update");

        holder.add(aTypeOfWaterTransport);
        holder.add(aTypeOfWaterTransportField);
        holder.add(aShippingTankerClass);
        holder.add(aShippingTankerClassField);
        holder.add(aLength);
        holder.add(aLengthField);
        holder.add(aBeam);
        holder.add(aBeamField);
        holder.add(aDraft);
        holder.add(aDraftField);
        holder.add(aDeadWeightTons);
        holder.add(aDeadWeightTonsField);


//        holder.add(delete);
//        holder.add(update);
        return holder;
    }

    public ShippingTanker getFields(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability) {
        return new ShippingTanker(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransportField.getText(), aShippingTankerClassField.getText(), getInt(aLengthField.getText()), getInt(aBeamField.getText()), getInt(aDraftField.getText()), getDouble(aDeadWeightTonsField.getText()));
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception error) {
            return 0;
        }
    }

    private double getDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception error) {
            return 0;
        }
    }

    public ShippingTanker(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber, boolean aAvailability, String aTypeOfWaterTransport,String aShippingTankerClass, int aLength, int aBeam, int aDraft, double aDeadWeightTons){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setShippingTankerClass(aShippingTankerClass);
        setLength(aLength);
        setBeam(aBeam);
        setDraft(aDraft);
        setDeadWeightTons(aDeadWeightTons);
        aTypeOfWaterTransportField = new JTextField(getTypeOfWaterTransport());
        aShippingTankerClassField = new JTextField(getShippingTankerClass());
        aLengthField = new JTextField(getLength());
        aBeamField = new JTextField(getBeam());
        aDraftField = new JTextField(getDraft());
        aDeadWeightTonsField = new JTextField(getDeadWeightTons());
    }

    public void setShippingTankerClass(String aShippingTankerClass){shippingTankerClass=aShippingTankerClass;}
    public void setLength(int aLength){length=aLength;}
    public void setBeam(int aBeam){beam=aBeam;}
    public void setDraft(int aDraft){draft=aDraft;}
    public void setDeadWeightTons(double aDeadWeightTons){deadWeightTons=aDeadWeightTons;}

    public String getShippingTankerClass(){return shippingTankerClass;}
    public String getLength(){return    Integer.toString(length);}
    public String getBeam(){return      Integer.toString(beam);}
    public String getDraft(){return     Integer.toString(draft);}
    public String getDeadWeightTons(){return Double.toString(deadWeightTons);}

}