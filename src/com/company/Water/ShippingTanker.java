package com.company.Water;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
           JLabel aShippingTankerClass = new JLabel("Shipping Tanker Class");
           JTextField aShippingTankerClassField = new JTextField(getShippingTankerClass());
           JLabel aLength = new JLabel("Length");
           JTextField aLengthField = new JTextField(getLength());
           JLabel aBeam = new JLabel("Beam");
           JTextField aBeamField = new JTextField(getBeam());
           JLabel aDraft = new JLabel("Draft");
           JTextField aDraftField = new JTextField(getDraft());
           JLabel aDeadWeightTons = new JLabel("Dead Weight Tons");
           JTextField aDeadWeightTonsField = new JTextField(getDeadWeightTons());

            JButton delete = new JButton("Delete");
            JButton update = new JButton("Update");

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

    public ShippingTanker(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                          boolean aAvailability, String aTypeOfWaterTransport,String aShippingTankerClass, int aLength,
                          int aBeam, int aDraft, double aDeadWeightTons){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber, aAvailability, aTypeOfWaterTransport);
        setShippingTankerClass(aShippingTankerClass);
        setLength(aLength);
        setBeam(aBeam);
        setDraft(aDraft);
        setDeadWeightTons(aDeadWeightTons);
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