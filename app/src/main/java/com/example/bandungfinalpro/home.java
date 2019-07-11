package com.example.bandungfinalpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class home extends AppCompatActivity {

    Button pariwisatabtn , kulinerbtn, transportasibtn, penginapanbtn;

    private int[] mImages = new int[] {
            R.drawable.gambar1, R.drawable.gambar2, R.drawable.gambar3, R.drawable.gambar4
    };

    private String[] mImagesTitle = new String[]{
            "welcome Bandung" , "Kawah Putih" , "Gedung Sate" , "Masjid"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pariwisatabtn = (Button) findViewById(R.id.btn_pariwisata);

        pariwisatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,pariwisata.class);
                startActivity(intent);
            }
        });

        kulinerbtn = (Button) findViewById(R.id.btn_kuliner);

        kulinerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,kuliner.class);
                startActivity(intent);
            }
        });

        penginapanbtn = (Button) findViewById(R.id.btn_hotel);

        penginapanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,penginapan.class);
                startActivity(intent);
            }
        });

        transportasibtn = (Button) findViewById(R.id.btn_transportasi);

        transportasibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,transportasi.class);
                startActivity(intent);
            }
        });

        CarouselView carouselView = findViewById(R.id.caraouselview);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

            }
        });
    }
}
