package com.example.congthucnauan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BanDoActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ban_do_layout);
        //Map
        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.frMaps);
        mapFragment.getMapAsync( this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMaps = googleMap;
        Intent i = getIntent();
        String vt1 = i.getStringExtra("ViTri1");
        String vt2 = i.getStringExtra("ViTri2");
        if(mMaps != null){
            LatLng tdc = new LatLng(Double.parseDouble(vt1), Double.parseDouble(vt2));
            mMaps.addMarker(new MarkerOptions()
                    .position(tdc)
                    .draggable(true)
                    .title("Trường Cao Đẳng Công Nghệ Thủ Đức")
                    .snippet("I am Here"));
            mMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(tdc,15));
        }
    }
}
