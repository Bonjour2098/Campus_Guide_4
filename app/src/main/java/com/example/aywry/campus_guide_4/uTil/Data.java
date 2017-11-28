package com.example.aywry.campus_guide_4.uTil;

import android.graphics.Color;

import com.amap.api.services.core.LatLonPoint;

/**
 * Created by aywry on 11/27/2017.
 */

public class Data {
    private static LatLonPoint StartPoint = new LatLonPoint(31.772106,117.204622);
    private static LatLonPoint DestinationPoint = new LatLonPoint(0,0);
    private static Color ColorClass1 = new Color();




    public static LatLonPoint getStartPointInfo() {return StartPoint;}
    public static LatLonPoint getDestinationPointInfo() {return DestinationPoint;}
    public static void setStartPoint(LatLonPoint i){StartPoint=i;}
    public static void setDestinationPoint(LatLonPoint i){DestinationPoint=i;}
}
