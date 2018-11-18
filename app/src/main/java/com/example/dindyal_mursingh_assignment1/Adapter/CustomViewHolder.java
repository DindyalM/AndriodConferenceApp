package com.example.dindyal_mursingh_assignment1.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.battleent.ribbonviews.RibbonLayout;
import com.example.dindyal_mursingh_assignment1.R;

public class CustomViewHolder extends RecyclerView.ViewHolder{

    RibbonLayout ribbonLayout;
    ImageView imageView;

    public CustomViewHolder( View itemView) {
        super(itemView);

        ribbonLayout = itemView.findViewById(R.id.ribbonLayout);
        imageView = itemView.findViewById(R.id.imageView);

    }
}
