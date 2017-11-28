package com.example.aywry.campus_guide_4.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TileOverlayOptions;
import com.example.aywry.campus_guide_4.MainActivity;
import com.example.aywry.campus_guide_4.R;

import java.util.Arrays;

/**
 * Created by aywry on 11/24/2017.
 */

public class CameraMapActivity extends Activity {

    private TextView textview_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_map);
        textview_1 = (TextView)findViewById(R.id.textView_1);
        textview_1.setText("Camera");
    }

}

/*

*/