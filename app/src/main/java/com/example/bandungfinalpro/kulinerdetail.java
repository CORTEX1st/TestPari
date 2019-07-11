package com.example.bandungfinalpro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class kulinerdetail extends AppCompatActivity implements OnMapReadyCallback {

    TextView mTitle, mDetail, mAlamat, mWaktu,mcalls;
    ImageView mImage,direction;
    Double latitude, longitude;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kulinerdetail);
        final double latitude = Double.parseDouble(getIntent().getStringExtra("laitude"));
        final double longitude = Double.parseDouble(getIntent().getStringExtra("longitude"));
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.id/maps/dir/?api=1&destination="+latitude+","+longitude));
                startActivity(i);
            }
        });





    mTitle = findViewById(R.id.title);
        mDetail = findViewById(R.id.desc);
        mImage = findViewById(R.id.image);
        mAlamat = findViewById(R.id.alamat);
        mWaktu = findViewById(R.id.waktu);
        mcalls = findViewById(R.id.calls);


        String image = getIntent().getStringExtra("gambar");
        String title = getIntent().getStringExtra("nama");
        String desc = getIntent().getStringExtra("keterangan");
        String alamat = getIntent().getStringExtra("alamat");
        String waktu = getIntent().getStringExtra("waktuoperasi");
        String jam = getIntent().getStringExtra("call");

        mcalls.setText(jam);
        mTitle.setText(title);
        mAlamat.setText(alamat);
        mDetail.setText(desc);
        mWaktu.setText(waktu);
        Picasso.get().load(image).into(mImage);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng lokasi = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(lokasi).title(String.valueOf(mTitle)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,15));
    }
}
