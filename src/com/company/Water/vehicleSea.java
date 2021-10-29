package com.company.Water;

import com.company.vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract class vehicleSea extends vehicle {
    private String typeOfWaterTransport;

    vehicleSea(){
        super();
        setTypeOfWaterTransport("");
    }

    vehicleSea(String aCategory, String aName, String aBrand, int aDay, int aMonth, int aYear, String aIDNumber,
                      boolean aAvailability, String aTypeOfWaterTransport){
        super(aCategory, aName, aBrand, aDay, aMonth, aYear, aIDNumber,aAvailability);
        setTypeOfWaterTransport(aTypeOfWaterTransport);
    }

    private void setTypeOfWaterTransport(String aTypeOfWaterTransport){
        typeOfWaterTransport=aTypeOfWaterTransport;
    }

    String getTypeOfWaterTransport(){return typeOfWaterTransport;}


    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}