package com.example.hotstar;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.LatestModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterNews extends RecyclerView.Adapter<RecyclerViewAdapterNews.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    private List<LatestModel> top_movieModel=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterNews(Context mContext, List<LatestModel> top_movieModel) {
        this.top_movieModel = top_movieModel;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_page,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onCreateViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(top_movieModel.get(i).getImg2())
                .into(viewHolder.image);
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("type",top_movieModel.get(i).getType());
                bundle.putString("name",top_movieModel.get(i).getName());
                bundle.putInt("img",top_movieModel.get(i).getImg());
                bundle.putInt("img2",top_movieModel.get(i).getImg2());
                Intent intent=new Intent(mContext, SingleViewPage.class).putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return top_movieModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.img);
        }
    }

}
