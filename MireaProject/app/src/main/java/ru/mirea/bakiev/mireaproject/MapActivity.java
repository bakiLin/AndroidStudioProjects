package ru.mirea.bakiev.mireaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import ru.mirea.bakiev.mireaproject.databinding.ActivityMainBinding;
import ru.mirea.bakiev.mireaproject.databinding.ActivityMapBinding;

public class MapActivity extends AppCompatActivity {
    private MapView mapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMapBinding binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        mapView = binding.mapView;

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double latitude = intent.getDoubleExtra("lat", 0);
        double longitude = intent.getDoubleExtra("long", 0);

        mapView.setZoomRounding(true);
        mapView.setMultiTouchControls(true);

        IMapController mapController = mapView.getController();
        mapController.setZoom(15.0);
        GeoPoint startPoint = new GeoPoint(latitude, longitude);
        mapController.setCenter(startPoint);

        MyLocationNewOverlay locationNewOverlay = new MyLocationNewOverlay(new
                GpsMyLocationProvider(getApplicationContext()),mapView);
        locationNewOverlay.enableMyLocation();
        mapView.getOverlays().add(locationNewOverlay);

        CompassOverlay compassOverlay = new CompassOverlay(getApplicationContext(),
                new InternalCompassOrientationProvider(getApplicationContext()), mapView);
        compassOverlay.enableCompass();
        mapView.getOverlays().add(compassOverlay);

        final Context context = this.getApplicationContext();
        final DisplayMetrics dm = context.getResources().getDisplayMetrics();
        ScaleBarOverlay scaleBarOverlay = new ScaleBarOverlay(mapView);
        scaleBarOverlay.setCentred(true);
        scaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);
        mapView.getOverlays().add(scaleBarOverlay);

        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(latitude, longitude));
        mapView.getOverlays().add(marker);
        marker.setIcon(ResourcesCompat.getDrawable(getResources(),
                org.osmdroid.library.R.drawable.osm_ic_follow_me_on,
                null));
        marker.setTitle(name);

        binding.toKremlButton.setOnClickListener(v -> {
            mapController.setZoom(16.0);
            GeoPoint startPoint1 = new GeoPoint(new GeoPoint(55.751426, 37.618879));
            mapController.setCenter(startPoint1);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        if (mapView != null)
            mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Configuration.getInstance().save(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        if (mapView != null)
            mapView.onPause();
    }
}