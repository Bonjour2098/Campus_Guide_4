package com.example.aywry.campus_guide_4.HeatMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.TileOverlayOptions;
import com.example.aywry.campus_guide_4.R;
import com.example.aywry.campus_guide_4.uTil.Constants;
import com.example.aywry.campus_guide_4.uTil.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aywry on 11/25/2017.
 */

public class TimeSpendActivity extends Activity implements
        SeekBar.OnSeekBarChangeListener {
    private static final int WIDTH_MAX = 50;
    private static final int HUE_MAX = 255;
    private static final int ALPHA_MAX = 255;
    private AMap aMap;
    private MapView mapView;
    private Polygon polygon;
    private SeekBar mColorBar;
    private SeekBar mAlphaBar;
    private SeekBar mWidthBar;

    private Polygon dpolygonTeachingArea;
    private Polygon dpolygonWestAthleticArea;
    private Polygon dpolygonLaboratoryArea;
    private Polygon dpolygonDormitory;
    private Polygon dpolygonEastAthleticArea;
    Circle circleLibrary;
    Circle circleArtSchool;

    private TextView textTemp;
    private Button FileTimeArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_spend);
        /*
         * 设置离线地图存储目录，在下载离线地图或初始化地图设置;
         * 使用过程中可自行设置, 若自行设置了离线地图存储的路径，
         * 则需要在离线地图下载和使用地图页面都进行路径设置
         * */
        //Demo中为了其他界面可以使用下载的离线地图，使用默认位置存储，屏蔽了自定义设置
//        MapsInitializer.sdcardDir =OffLineMapUtils.getSdCacheDir(this);
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写

        textTemp = (TextView)findViewById(R.id.textTemp);
        init();
        load();

        textTemp.setText(Data.getTimeSpending(0)+" "+Data.getTimeSpending(1)+" "+
                Data.getTimeSpending(2)+" "+Data.getTimeSpending(3)+" "+
                Data.getTimeSpending(4)+" "+Data.getTimeSpending(5)+" "+
                Data.getTimeSpending(6)+" ");

        SetUpTimeMap();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {

        if (aMap == null) {
            aMap = mapView.getMap();
            setUpMap();
        }
    }

    // 设置监听 添加多边形
    private void setUpMap() {

        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.HfutCoordinate, 15.3f));// 设置指定的可视区域地图


        PolygonOptions polygonTeachingArea = new PolygonOptions();
        PolygonOptions polygonWestAthleticArea = new PolygonOptions();
        PolygonOptions polygonLaboratoryArea = new PolygonOptions();
        PolygonOptions polygonDormitory = new PolygonOptions();
        PolygonOptions polygonEastAthleticArea = new PolygonOptions();

        circleLibrary = aMap.addCircle(new CircleOptions().center(Data.latLng1)
                .strokeWidth(0)
                .radius(90)
                .fillColor(Color.argb(0,0,0,0)));
        circleArtSchool = aMap.addCircle(new CircleOptions().center(Data.latLng2)
                .strokeWidth(0)
                .radius(60)
                .fillColor(Color.argb(0,0,0,0)));


        polygonWestAthleticArea.add(Data.latLng4,Data.latLng5,Data.latLng6,Data.latLng7,
                Data.latLng8);
        polygonDormitory.add(Data.latLng3,Data.latLng4,Data.latLng8,Data.latLng7,Data.latLng9,
                Data.latLng10,Data.latLng11,Data.latLng12,Data.latLng13,Data.latLng14,
                Data.latLng15, Data.latLng16,Data.latLng17,Data.latLng18,Data.latLng19,
                Data.latLng20,Data.latLng21,Data.latLng22,Data.latLng23,Data.latLng24,
                Data.latLng25,Data.latLng26,Data.latLng27, Data.latLng28,
                Data.latLng29,Data.latLng30,Data.latLng31,Data.latLng32);
        polygonTeachingArea.add(Data.latLng33,Data.latLng34,Data.latLng35,Data.latLng36,
                Data.latLng37,Data.latLng38,Data.latLng39,Data.latLng40,
                Data.latLng41,Data.latLng42,Data.latLng43,Data.latLng44);
        polygonLaboratoryArea.add(Data.latLng45,Data.latLng43,Data.latLng42,Data.latLng58,
                Data.latLng49,Data.latLng50,Data.latLng51,Data.latLng52,
                Data.latLng53,Data.latLng57,Data.latLng56);
        polygonEastAthleticArea.add(Data.latLng46,Data.latLng47,Data.latLng48,
                Data.latLng45, Data.latLng56,Data.latLng57,Data.latLng53,
                Data.latLng54, Data.latLng55);


        polygonWestAthleticArea.strokeWidth(0)
                .fillColor(Color.argb(0,0,0,0));
        polygonDormitory.strokeWidth(0)
                .fillColor(Color.argb(0,0,0,0));
        polygonTeachingArea.strokeWidth(0)
                .fillColor(Color.argb(0,0,0,0));
        polygonLaboratoryArea.strokeWidth(0)
                .fillColor(Color.argb(0,0,0,0));
        polygonEastAthleticArea.strokeWidth(0)
                .fillColor(Color.argb(0,0,0,0));


        dpolygonWestAthleticArea = aMap.addPolygon(polygonWestAthleticArea);
        dpolygonDormitory = aMap.addPolygon(polygonDormitory);
        dpolygonTeachingArea = aMap.addPolygon(polygonTeachingArea);
        dpolygonLaboratoryArea = aMap.addPolygon(polygonLaboratoryArea);
        dpolygonEastAthleticArea = aMap.addPolygon(polygonEastAthleticArea);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    /**
     * Polygon中对填充颜色，透明度，画笔宽度设置响应事件
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (polygon == null) {
            return;
        }
        if (seekBar == mColorBar) {
            polygon.setFillColor(Color.argb(progress, 1, 1, 1));
        } else if (seekBar == mAlphaBar) {
            polygon.setStrokeColor(Color.argb(progress, 1, 1, 1));
        } else if (seekBar == mWidthBar) {
            polygon.setStrokeWidth(progress);
        }
    }

    public void load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            //设置将要打开的存储文件名称
            in = openFileInput("TimeSpending");
            //FileInputStream -> InputStreamReader ->BufferedReader
            reader = new BufferedReader(new InputStreamReader(in));
            String line = new String();
            String line2 = new String();
            //读取每一行数据，并追加到StringBuilder对象中，直到结束

            while ((line = reader.readLine()) != null) {
                double lat = Double.parseDouble(line);
                double lng = 0;
                if((line2 = reader.readLine()) != null)
                {
                    lng = Double.parseDouble(line2);
                }
                //textTemp.setText(line+" "+line2);
                Contains(new LatLng(lat,lng));
                /*
                content.append(line);
                content.append("\n");
                content.append(line2);
                content.append("\n");
                */
            }
            //textTemp.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ResetTimeSpending();
        SaveTimeArray();
    }

    /**
     * 0 TimeOfLibrary
     * 1 TimeOfArtSchool
     * 2 TimeOfWestAthleticArea
     * 3 TimeOfDormitory
     * 4 TimeOfTeachingArea
     * 5 TimeOfEastAthleticArea
     * 6 TimeOfLaboratoryArea
     */
    private void Contains(LatLng v)
    {
        if(dpolygonEastAthleticArea.contains(v))
        {
            Data.setTimeSpending(5);
        }
        else if(dpolygonLaboratoryArea.contains(v))
        {
            Data.setTimeSpending(6);
        }
        else if(dpolygonTeachingArea.contains(v))
        {
            Data.setTimeSpending(4);
        }
        else if(dpolygonDormitory.contains(v))
        {
            Data.setTimeSpending(3);
        }
        else if(dpolygonWestAthleticArea.contains(v))
        {
            Data.setTimeSpending(2);
        }
        else if(circleArtSchool.contains(v))
        {
            Data.setTimeSpending(1);
        }
        else if(circleLibrary.contains(v))
        {
            Data.setTimeSpending(0);
        }
    }

    private void SaveTimeArray()
    {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            //设置文件名称，以及存储方式
            out = openFileOutput("TimeArray", Context.MODE_PRIVATE);
            //创建一个OutputStreamWriter对象，传入BufferedWriter的构造器中
            writer = new BufferedWriter(new OutputStreamWriter(out));
            //向文件中写入数据
            for(int i=0;i<7;i++)
            {
                writer.write(Integer.toString(Data.getTimeSpending(i)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void ResetTimeSpending()
    {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            //设置文件名称，以及存储方式
            out = openFileOutput("TimeSpending", Context.MODE_PRIVATE);
            //创建一个OutputStreamWriter对象，传入BufferedWriter的构造器中
            writer = new BufferedWriter(new OutputStreamWriter(out));
            //向文件中写入数据
            writer.write(new String());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int[] ReadTimeArray()
    {
        int ret[] = new int[7];
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            //设置将要打开的存储文件名称
            in = openFileInput("TimeArray");
            //FileInputStream -> InputStreamReader ->BufferedReader
            reader = new BufferedReader(new InputStreamReader(in));
            String line = new String();
            int i=0;
            //读取每一行数据，并追加到StringBuilder对象中，直到结束
            while ((line = reader.readLine()) != null) {
                ret[i] = Integer.parseInt(line);
                i++;
            }
            //textTemp.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    private void SetUpTimeMap()
    {
        Circle showCircleLibrary;
        Circle showCircleArtSchool;
        PolygonOptions showPolygonTeachingArea = new PolygonOptions();
        PolygonOptions showPolygonWestAthleticArea = new PolygonOptions();
        PolygonOptions showPolygonLaboratoryArea = new PolygonOptions();
        PolygonOptions showPolygonDormitory = new PolygonOptions();
        PolygonOptions showPolygonEastAthleticArea = new PolygonOptions();

        showCircleLibrary = aMap.addCircle(new CircleOptions().center(Data.latLng1)
                .strokeWidth(0)
                .radius(90)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(0))]));
        showCircleArtSchool = aMap.addCircle(new CircleOptions().center(Data.latLng2)
                .strokeWidth(0)
                .radius(60)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(1))]));


        showPolygonWestAthleticArea.add(Data.latLng4,Data.latLng5,Data.latLng6,Data.latLng7,
                Data.latLng8);
        showPolygonDormitory.add(Data.latLng3,Data.latLng4,Data.latLng8,Data.latLng7,Data.latLng9,
                Data.latLng10,Data.latLng11,Data.latLng12,Data.latLng13,Data.latLng14,
                Data.latLng15, Data.latLng16,Data.latLng17,Data.latLng18,Data.latLng19,
                Data.latLng20,Data.latLng21,Data.latLng22,Data.latLng23,Data.latLng24,
                Data.latLng25,Data.latLng26,Data.latLng27, Data.latLng28,
                Data.latLng29,Data.latLng30,Data.latLng31,Data.latLng32);
        showPolygonTeachingArea.add(Data.latLng33,Data.latLng34,Data.latLng35,Data.latLng36,
                Data.latLng37,Data.latLng38,Data.latLng39,Data.latLng40,
                Data.latLng41,Data.latLng42,Data.latLng43,Data.latLng44);
        showPolygonLaboratoryArea.add(Data.latLng45,Data.latLng43,Data.latLng42,Data.latLng58,
                Data.latLng49,Data.latLng50,Data.latLng51,Data.latLng52,
                Data.latLng53,Data.latLng57,Data.latLng56);
        showPolygonEastAthleticArea.add(Data.latLng46,Data.latLng47,Data.latLng48,
                Data.latLng45, Data.latLng56,Data.latLng57,Data.latLng53,
                Data.latLng54, Data.latLng55);

        aMap.addPolygon(showPolygonWestAthleticArea.strokeWidth(0)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(2))]));
        aMap.addPolygon(showPolygonDormitory.strokeWidth(0)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(3))]));
        aMap.addPolygon(showPolygonTeachingArea.strokeWidth(0)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(4))]));
        aMap.addPolygon(showPolygonLaboratoryArea.strokeWidth(0)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(6))]));
        aMap.addPolygon(showPolygonEastAthleticArea.strokeWidth(0)
                .fillColor(Data.getColorClass()[Data.DetermineTimeClass(Data.getTimeSpending(5))]));
    }

}
