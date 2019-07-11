package com.example.bandungfinalpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class pariwisatadetail extends AppCompatActivity{

    TextView mTitle, mDetail, mAlamat, mWaktu,mcalls;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisatadetail);
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
}
