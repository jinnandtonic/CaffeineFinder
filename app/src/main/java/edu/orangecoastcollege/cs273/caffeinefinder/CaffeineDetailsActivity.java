package edu.orangecoastcollege.cs273.caffeinefinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Ryan Millett on 11/21/2017.
 */
class CaffeineDetailsActivity extends AppCompatActivity implements OnMapReadyCallback{

    Location selectedLocation;

    private GoogleMap map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_details);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailMapFragment);
        mapFragment.getMapAsync(this);

        selectedLocation = getIntent().getExtras().getParcelable("Selected Location");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng selectedLocationPosition =
                new LatLng(selectedLocation.getLatitude(), selectedLocation.getLongitude());

        map.addMarker(new MarkerOptions()
                .position(selectedLocationPosition)
                .title(selectedLocation.getName()
                ));
    }
}
