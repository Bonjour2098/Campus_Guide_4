package com.example.aywry.campus_guide_4.uTil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Time;

/**
 * Created by aywry on 11/27/2017.
 */

public class Data{
    private static LatLonPoint StartPoint = new LatLonPoint(31.772106,117.204622);
    private static LatLonPoint DestinationPoint = new LatLonPoint(31.768393,117.201546);
    private static int ColorClass[] = {
            Color.argb(255, 148,0,12),
            Color.argb(255, 191,26,0),
            Color.argb(255, 244,0,41),
            Color.argb(255, 255, 53,64),
            Color.argb(255, 255, 63,123),
            Color.argb(255, 255, 95,198),
            Color.argb(255, 255, 142,85),
            Color.argb(255, 245, 255,21) };
    /**
     * 0 TimeOfLibrary
     * 1 TimeOfArtSchool
     * 2 TimeOfWestAthleticArea
     * 3 TimeOfDormitory
     * 4 TimeOfTeachingArea
     * 5 TimeOfEastAthleticArea
     * 6 TimeOfLaboratoryArea
     */
    private static int[] TimeSpending = new int[7];
    private static final int TimeGap = 720;
    public static final LatLng latLng1 = new LatLng(31.768375,117.201496);//,
    public static final LatLng latLng2 = new LatLng(31.770199,117.201046);//,
    public static final LatLng latLng3 = new LatLng(31.771996,117.197822);//,
    public static final LatLng latLng4 = new LatLng(31.771325,117.197822);//,
    public static final LatLng latLng5 = new LatLng(31.769797,117.197822);//,
    public static final LatLng latLng6 = new LatLng(31.769797,117.198771);//,
    public static final LatLng latLng7 = new LatLng(31.770865,117.198755);//,
    public static final LatLng latLng8 = new LatLng(31.771325,117.198744);//,
    public static final LatLng latLng9 = new LatLng(31.770887,117.19956); //,
    public static final LatLng latLng10 = new LatLng(31.77112,117.199581);//,
    public static final LatLng latLng11 = new LatLng(31.771143,117.200402);//,
    public static final LatLng latLng12 = new LatLng(31.771435,117.200423);//,
    public static final LatLng latLng13 = new LatLng(31.771435,117.201276);//,
    public static final LatLng latLng14 = new LatLng(31.771873,117.201292);//,
    public static final LatLng latLng15 = new LatLng(31.771886,117.202076);//,
    public static final LatLng latLng16 = new LatLng(31.772452,117.202065);//,
    public static final LatLng latLng17 = new LatLng(31.772465,117.202811);//,
    public static final LatLng latLng18 = new LatLng(31.772771,117.202811);//,
    public static final LatLng latLng19 = new LatLng(31.772771,117.203647);//
    public static final LatLng latLng20 = new LatLng(31.774668,117.203647);//,
    public static final LatLng latLng21 = new LatLng(31.774673,117.202811);//,
    public static final LatLng latLng22 = new LatLng(31.774326,117.202811);//,
    public static final LatLng latLng23 = new LatLng(31.774308,117.20207);//,
    public static final LatLng latLng24 = new LatLng(31.773902,117.202049);//,
    public static final LatLng latLng25 = new LatLng(31.773888,117.201271);//,
    public static final LatLng latLng26 = new LatLng(31.773414,117.201276);//,
    public static final LatLng latLng27 = new LatLng(31.773414,117.200413);//,
    public static final LatLng latLng28 = new LatLng(31.772967,117.200413);//,
    public static final LatLng latLng29 = new LatLng(31.772958,117.19956);//,
    public static final LatLng latLng30 = new LatLng(31.772693,117.199565);//,
    public static final LatLng latLng31 = new LatLng(31.77268,117.198766);//,
    public static final LatLng latLng32 = new LatLng(31.772,117.19875);//,
    public static final LatLng latLng33 = new LatLng(31.772267,117.205133);//,
    public static final LatLng latLng34 = new LatLng(31.771984,117.203996); //,
    public static final LatLng latLng35 = new LatLng(31.770776,117.20361);//,
    public static final LatLng latLng36 = new LatLng(31.769544,117.203637);//,
    public static final LatLng latLng37 = new LatLng(31.768336,117.204082);//,
    public static final LatLng latLng38 = new LatLng(31.768336,117.20509);//,
    public static final LatLng latLng39 = new LatLng(31.768336,117.20612);//,
    public static final LatLng latLng40 = new LatLng(31.76954,117.20655);//,
    public static final LatLng latLng41 = new LatLng(31.769531,117.206576);//,
    public static final LatLng latLng42 = new LatLng(31.770753,117.206555);//,
    public static final LatLng latLng43 = new LatLng(31.77099,117.206528);//,
    public static final LatLng latLng44 = new LatLng(31.771957,117.206185);//,
    public static final LatLng latLng45 = new LatLng(31.772231,117.20604);//
    public static final LatLng latLng46 = new LatLng(31.774999,117.205225);//,
    public static final LatLng latLng47 = new LatLng(31.773685,117.205268);//,
    public static final LatLng latLng48 = new LatLng(31.773001,117.205568);//,
    public static final LatLng latLng49 = new LatLng(31.769781,117.207622);//,
    public static final LatLng latLng50 = new LatLng(31.769914,117.207628);//,
    public static final LatLng latLng51 = new LatLng(31.769932,117.208481);//,
    public static final LatLng latLng52 = new LatLng(31.770771,117.208733);//,
    public static final LatLng latLng53 = new LatLng(31.771943,117.209098);//,
    public static final LatLng latLng54 = new LatLng(31.773047,117.209462);//,
    public static final LatLng latLng55 = new LatLng(31.774994,117.209602);//,
    public static final LatLng latLng56 = new LatLng(31.772231,117.207639);//,
    public static final LatLng latLng57 = new LatLng(31.771939,117.207639);//,
    public static final LatLng latLng58 = new LatLng(31.769795,117.206609);//,


    public static void setStartPoint(LatLonPoint i){StartPoint=i;}
    public static void setDestinationPoint(LatLonPoint i){DestinationPoint=i;}
    public static void setTimeSpending(int i){TimeSpending[i]+=1;}
    public static void setTimeSpending(int pos,int num){TimeSpending[pos]=num;}


    public static LatLonPoint getStartPointInfo() {return StartPoint;}
    public static LatLonPoint getDestinationPointInfo() {return DestinationPoint;}
    public static int[] getColorClass(){return ColorClass;}
    public static int getTimeSpending(int i){return TimeSpending[i];}
    public static int DetermineTimeClass(int i)
    {

        if(i>21*TimeGap) return 0;
        else if(i>18*TimeGap) return 1;
        else if(i>15*TimeGap) return 2;
        else if(i>12*TimeGap) return 3;
        else if(i>9*TimeGap) return 4;
        else if(i>6*TimeGap) return 5;
        else if(i>3*TimeGap) return 6;
        return 7;

        /*
        if(i==0) return 7;
        return 0;
        */
    }
}
