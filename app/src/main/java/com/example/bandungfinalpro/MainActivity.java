package com.example.bandungfinalpro;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView persentase;
    private int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        persentase = findViewById(R.id.persentase);
        progressBar.setProgress(0);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                persentase.setText(String.valueOf(value)+"%");
                if (value == progressBar.getMax()){
                    Toast.makeText(getApplicationContext(),"Wilujeung Sumping", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, home.class));
                    finish();
                }
                value++;
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int w=0; w<=progressBar.getMax(); w++){
                        progressBar.setProgress(w);
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(100);
                    }
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
