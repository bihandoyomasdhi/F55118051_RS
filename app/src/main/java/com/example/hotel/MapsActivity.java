package com.example.hotel;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Membuar mark pada tempat tinggal User
        LatLng MyHome = new LatLng(-0.9325018375292781, 119.8976271112071);
        // Custom size marker
        int tinggi = 150;
        int lebar = 90;
        BitmapDrawable bitmapDraw = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_location);
        Bitmap b = bitmapDraw.getBitmap();
        Bitmap markerKecil = Bitmap.createScaledBitmap(b, lebar, tinggi, false);
        //Masukan Ke Map
        mMap.addMarker(new MarkerOptions().position(MyHome).title("Rumah (Bihandoyo Masdhi F55118051)").snippet("Ini Rumah Saya").icon(BitmapDescriptorFactory.fromBitmap(markerKecil)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MyHome, 13.5f));


        LatLng RumahSakitIslamBanteng = new LatLng(-0.9325169311945863, 119.89682485966961);
        mMap.addMarker(new MarkerOptions().position(RumahSakitIslamBanteng).title("Lokasi Terdekat : Rumah Sakit Islam Banteng "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RumahSakitIslamBanteng));

        LatLng RSBhayangkaraPalu = new LatLng(-0.8878896661462953, 119.86826801840465);
        mMap.addMarker(new MarkerOptions().position(RSBhayangkaraPalu).title("RS Bhayangkara Palu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RSBhayangkaraPalu));

        LatLng RumahSakitUmumSisAlJufriPalu = new LatLng(-0.9015242865381718, 119.85785585917117);
        mMap.addMarker(new MarkerOptions().position(RumahSakitUmumSisAlJufriPalu).title("Rumah Sakit Umum Sis. Al Jufri Palu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RumahSakitUmumSisAlJufriPalu));


        //PolyLine dari myHome ke RS RedDoorz Tinggede
        mMap.addPolyline(new PolylineOptions().add(
                MyHome,
                new LatLng(-0.9324433523750492, 119.89702942326028),
                new LatLng(-0.9324674890589852, 119.89607723912096),
                new LatLng(-0.9328644033932306, 119.89607992132979),
                RumahSakitIslamBanteng
        ).width(10)
                .color(Color.BLACK)
        );
    }
}