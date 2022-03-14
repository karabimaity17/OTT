package com.example.hotstar;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapterChoice extends RecyclerView.Adapter<RecyclerViewAdapterChoice.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageUrls=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterChoice(Context mContext, ArrayList<String> mImageUrls) {
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_page_three,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onCreateViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(i))
                .into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.img);
        }
    }

}
