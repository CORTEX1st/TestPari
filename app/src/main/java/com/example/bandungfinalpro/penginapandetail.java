package com.example.bandungfinalpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class penginapandetail extends AppCompatActivity {

    TextView mTitle, mDetail, mAlamat, mWaktu;
    ImageView mImage, mCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penginapandetail);
        mTitle = findViewById(R.id.title);
        mDetail = findViewById(R.id.desc);
        mImage = findViewById(R.id.image);
        mAlamat = findViewById(R.id.alamat);
        mWaktu = findViewById(R.id.waktu);
        mCall = findViewById(R.id.dial);


        String image = getIntent().getStringExtra("gambar");
        String title = getIntent().getStringExtra("nama");
        String desc = getIntent().getStringExtra("keterangan");
        String alamat = getIntent().getStringExtra("alamat");
        String waktu = getIntent().getStringExtra("waktuoperasi");

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
}
