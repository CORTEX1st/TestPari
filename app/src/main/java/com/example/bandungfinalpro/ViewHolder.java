package com.example.bandungfinalpro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;


            }
        });

    }

    public void setDetails(Context ctx, String title, String desc, String image){
        //view
        TextView mTitleView = mView.findViewById(R.id.dtitle);
        TextView mDesc = mView.findViewById(R.id.ddesc);
        ImageView mImage = mView.findViewById(R.id.dimage);

        //set data to view
        mTitleView.setText(title);
        mDesc.setText(desc);
        Picasso.get().load(image).into(mImage);

    }

    private ViewHolder.ClickListener mClickListener;

    //interface to send
    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnclickListener(ViewHolder.ClickListener clickListener){

        mClickListener = clickListener;

    }


}
