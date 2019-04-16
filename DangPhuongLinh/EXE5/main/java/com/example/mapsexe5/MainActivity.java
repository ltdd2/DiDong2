package com.example.mapsexe5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    RadioGroup radioGroup;
    RadioButton radNormal, radhibryd,radSatellite,radTerrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapsDemo);
        mapFragment.getMapAsync(this);
        //
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radNormal = (RadioButton) findViewById(R.id.normal);
        radhibryd = (RadioButton) findViewById(R.id.hibryd);
        radTerrain = (RadioButton) findViewById(R.id.terrain);
        radSatellite = (RadioButton) findViewById(R.id.satellite);
        //
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.normal:
                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                    case R.id.hibryd:
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;
                    case R.id.terrain:
                        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;
                    case R.id.satellite:
                        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;
                    default:break;
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        if(googleMap != null){
            LatLng tdc = new LatLng(10.772787, 106.697998);
            googleMap.addMarker(new MarkerOptions()
                    .position(tdc)
                    .draggable(true)
                    .title("Chợ Bến Thành")
                    .snippet("I am Here"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tdc,20));
        }
    }
}
