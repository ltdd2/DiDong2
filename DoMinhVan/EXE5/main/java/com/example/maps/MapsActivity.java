package com.example.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    Spinner spStyle;

    GoogleMap mMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_layout);
        //Map
        final MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.frMaps);
        mapFragment.getMapAsync(this);
        //Spinner
        spStyle = (Spinner) findViewById(R.id.spStyle);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Normal");
        arrayList.add("Hybrid");
        arrayList.add("Satellite");
        arrayList.add("Terrain");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        spStyle.setAdapter(arrayAdapter);
        spStyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mMaps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                    case 1:
                        mMaps.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;
                    case 2:
                        mMaps.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;
                    case 3:
                        mMaps.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void search(View view) {
        EditText edtSearch = (EditText) findViewById(R.id.edtSearch);
        String viTri = edtSearch.getText().toString();
        List<Address> addressList = null;
        if (viTri != null || !viTri.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(viTri, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
           Address diaChi = addressList.get(0);
            LatLng latLng = new LatLng(diaChi.getLatitude(), diaChi.getLongitude());
            mMaps.addMarker(new MarkerOptions().position(latLng).title(viTri).icon(BitmapDescriptorFactory.fromResource(R.drawable.place)));
            mMaps.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMaps = googleMap;
        //Set Information
        if(mMaps != null){
            mMaps.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                @Override
                public void onMarkerDragStart(Marker marker) {

                }
                @Override
                public void onMarkerDrag(Marker marker) {

                }
                @Override
                public void onMarkerDragEnd(Marker marker) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    LatLng latLng = marker.getPosition();
                    double lat = latLng.latitude;
                    double log = latLng.longitude;
                    List<Address> list = null;
                    try {
                        list = geocoder.getFromLocation(lat,log,1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = list.get(0);
                    marker.setTitle(address.getLocality());
                    marker.showInfoWindow();
                }
            });
            mMaps.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View view = getLayoutInflater().inflate(R.layout.thong_tin_layout,null);
                    TextView txtName = (TextView) view.findViewById(R.id.txtName);
                    TextView txtLatitude = (TextView) view.findViewById(R.id.txtLatitude);
                    TextView txtLongitude = (TextView) view.findViewById(R.id.txtLongitude);
                    TextView txtHere = (TextView) view.findViewById(R.id.txtHere);
                    LatLng latLng = marker.getPosition();
                    txtName.setText(marker.getTitle());
                    txtLatitude.setText("Latitude :"+latLng.latitude);
                    txtLongitude.setText("Longitude :"+latLng.longitude);
                    txtHere.setText(marker.getSnippet());
                    return view;
                }
            });

        }
        if(mMaps != null){
            LatLng tdc = new LatLng(10.852432, 106.758387);
            mMaps.addMarker(new MarkerOptions()
                    .position(tdc)
                    .draggable(true)
                    .title("Trường Cao Đẳng Công Nghệ Thủ Đức")
                    .snippet("I am Here"));
            mMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(tdc,15));
        }
    }
}
