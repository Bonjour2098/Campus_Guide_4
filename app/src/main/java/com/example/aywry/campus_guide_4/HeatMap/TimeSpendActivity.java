package com.example.aywry.campus_guide_4.HeatMap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.TileOverlayOptions;
import com.example.aywry.campus_guide_4.R;
import com.example.aywry.campus_guide_4.uTil.Constants;

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
        init();
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

        //Teaching Area
        LatLng latLngTeachingArea1 = new LatLng(31.770783,117.203618);
        LatLng latLngTeachingArea2 = new LatLng(31.76956,117.203618);
        LatLng latLngTeachingArea3 = new LatLng(31.768338,117.204101);
        LatLng latLngTeachingArea4 = new LatLng(31.768338,117.20615);
        LatLng latLngTeachingArea5 = new LatLng(31.76956,117.206558);
        LatLng latLngTeachingArea6 = new LatLng(31.770755,117.20658);
        //CafeteriaEast(1 and 2)
        LatLng latLngCafeteriaEast1 = new LatLng(31.774819,117.20381);//
        LatLng latLngCafeteriaEast2 = new LatLng(31.773989,117.203724);//,
        LatLng latLngCafeteriaEast3 = new LatLng(31.774112,117.204872);//,
        LatLng latLngCafeteriaEast4 = new LatLng(31.774937,117.204882);//,
        //AthleticArea
        LatLng latLngAthleticArea1 = new LatLng(31.774996,117.205274);//
        LatLng latLngAthleticArea2 = new LatLng(31.773741,117.205295);//,
        LatLng latLngAthleticArea3 = new LatLng(31.772984,117.205607);//,
        LatLng latLngAthleticArea4 = new LatLng(31.772246,117.206068);//,
        LatLng latLngAthleticArea5 = new LatLng(31.772218,117.207613);//,
        LatLng latLngAthleticArea6 = new LatLng(31.771945,117.207656);//,
        LatLng latLngAthleticArea7 = new LatLng(31.771945,117.209115);//,
        LatLng latLngAthleticArea8 = new LatLng(31.773012,117.209372);//,
        LatLng latLngAthleticArea9 = new LatLng(31.774982,117.209544);//,
        //LaboratoryArea
        LatLng latLngLaboratoryArea1 = new LatLng(31.772246,117.206068);//
        LatLng latLngLaboratoryArea2 = new LatLng(31.770978,117.20654);//,
        LatLng latLngLaboratoryArea3 = new LatLng(31.769847,117.206701);//,
        LatLng latLngLaboratoryArea4 = new LatLng(31.769865,117.208332);//,
        LatLng latLngLaboratoryArea5 = new LatLng(31.771917,117.209104);//,
        LatLng latLngLaboratoryArea6 = new LatLng(31.771945,117.207656);//
        LatLng latLngLaboratoryArea7 = new LatLng(31.772218,117.207613);//


        PolygonOptions polygonTeachingArea = new PolygonOptions();
        PolygonOptions polygonCafeteriaEast = new PolygonOptions();
        PolygonOptions polygonAthleticArea = new PolygonOptions();
        PolygonOptions polygonLaboratoryArea = new PolygonOptions();


        polygonTeachingArea.add(latLngTeachingArea1, latLngTeachingArea2, latLngTeachingArea3,
                latLngTeachingArea4, latLngTeachingArea5,latLngTeachingArea6);
        polygonCafeteriaEast.add(latLngCafeteriaEast1,latLngCafeteriaEast2,latLngCafeteriaEast3,
                latLngCafeteriaEast4);
        polygonAthleticArea.add(latLngAthleticArea1,latLngAthleticArea2,latLngAthleticArea3,
                latLngAthleticArea4,latLngAthleticArea5,latLngAthleticArea6,latLngAthleticArea7,
                latLngAthleticArea8,latLngAthleticArea9);
        polygonLaboratoryArea.add(latLngLaboratoryArea1,latLngLaboratoryArea2,latLngLaboratoryArea3,
                latLngLaboratoryArea4,latLngLaboratoryArea5,latLngLaboratoryArea6,latLngLaboratoryArea7);



        polygonTeachingArea.strokeWidth(1) // 多边形的边框
                .strokeColor(Color.argb(50, 1, 1, 1)) // 边框颜色
                .fillColor(Color.argb(50, 255, 44, 31));   // 多边形的填充色

        aMap.addPolygon(polygonTeachingArea);


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

    /**
     * 生成一个长方形的四个坐标点
     */
    private List<LatLng> createRectangle(LatLng center, double halfWidth,
                                         double halfHeight) {
        List<LatLng> latLngs = new ArrayList<LatLng>();
        latLngs.add(new LatLng(center.latitude - halfHeight, center.longitude - halfWidth));
        latLngs.add(new LatLng(center.latitude - halfHeight, center.longitude + halfWidth));
        latLngs.add(new LatLng(center.latitude + halfHeight, center.longitude + halfWidth));
        latLngs.add(new LatLng(center.latitude + halfHeight, center.longitude - halfWidth));
        return latLngs;
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
}
