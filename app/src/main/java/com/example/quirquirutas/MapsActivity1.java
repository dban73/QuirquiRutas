package com.example.quirquirutas;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
       int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
       if(status == ConnectionResult.SUCCESS) {
           SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                   .findFragmentById(R.id.map);
           mapFragment.getMapAsync(this);
       }else{
           Dialog d = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
           d.show();
       }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng oruro = new LatLng(-17.9642368,-67.1064064);
        mMap.addMarker(new MarkerOptions().position(oruro).title("ORURO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oruro,16));
    }
}
