package com.example.bandungfinalpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class transportasi extends AppCompatActivity {

    RecyclerView mRecylerView;
    DatabaseReference mFirebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportasi);



        //RecyclerView

        mRecylerView = findViewById(R.id.recycleview);
        mRecylerView.setHasFixedSize(true);

        //set layout as linearlayout
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));

        //send query to firebase
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference().child("transportasi");
        mFirebaseDatabase.keepSynced(true);


    }

    //load data into recycler view

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mFirebaseDatabase
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getNama(), model.getKeterangan(), model.getGambar());
                    }



                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                        viewHolder.setOnclickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                String mTitle = getItem(position).getNama();
                                String mDesc = getItem(position).getKeterangan();
                                String mImage = getItem(position).getGambar();
                                String malamat= getItem(position).getAlamat();
                                String mWaktu = getItem(position).getWaktuoperasi();
                                String mCall = getItem(position).getCall();
                                String map = getItem(position).getMap();


                                Intent intent = new Intent(view.getContext(), transportasidetail.class);


                                intent.putExtra("gambar", mImage);
                                intent.putExtra("call",mCall);
                                intent.putExtra("waktuoperasi",mWaktu);
                                intent.putExtra("nama", mTitle);
                                intent.putExtra("keterangan", mDesc);
                                intent.putExtra("alamat", malamat);
                                intent.putExtra("map",map);
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {



                            }
                        });

                        return viewHolder;
                    }
                }  ;

        //set adapter

        mRecylerView.setAdapter(firebaseRecyclerAdapter);

    }
}
