package com.example.dindyal_mursingh_assignment1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.battleent.ribbonviews.RibbonLayout;
import com.battleent.ribbonviews.RibbonTagListView;
import com.example.dindyal_mursingh_assignment1.Model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    Context context;


    class WordViewHolder extends RecyclerView.ViewHolder {

        //
        public final RibbonLayout ribbonLayout;
        public final ImageView imageView;
        //

        private WordViewHolder(View itemView) {
            super(itemView);

            //
            ribbonLayout = itemView.findViewById(R.id.ribbonLayout);
            imageView = itemView.findViewById(R.id.imageView);

            //
        }
    }

    private final LayoutInflater mInflater;
    private List<Speaker> mSpeakers; // Cached copy of speakers

    WordListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.layout_listitem_speakers, parent, false); //build an xml hierarchy attach to parent
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mSpeakers != null) {
            Speaker current = mSpeakers.get(position);
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
            holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));
            holder.ribbonLayout.setHeaderText(current.getName());
            holder.ribbonLayout.setBottomText(current.getAffiliation());
            ImageView imageView = holder.imageView;

            holder.ribbonLayout.setOnClickListener((view) -> {
                Context context = view.getContext();
                Intent intent = new Intent(context,SpeakerPro.class);
                intent.putExtra("name",current.getName());
                intent.putExtra("affiliation",current.getAffiliation());
                intent.putExtra("email",current.getEmail());
                intent.putExtra("bio",current.getBio());
                context.startActivity(intent);
            });

        } else {
            // Covers the case of data not being ready yet.
            holder.ribbonLayout.setShowBottom(false);
            holder.ribbonLayout.setShowBottom(false);
        }



    }

    void setSpeakers(List<Speaker> speakers){
        mSpeakers = speakers;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mSpeakers != null)
            return mSpeakers.size();
        else return 0;
    }
}