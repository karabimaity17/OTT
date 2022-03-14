package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.GenreModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ComingSoon extends AppCompatActivity {
    RecyclerView recycler_trailer;
    TrailerAdaapter trailerAdaapter;
    LinearLayoutManager manager;
    List<GenreModel> trailerModels = new ArrayList<>();
    TextView txt_series,name,txt;
    ImageView main_img,img2;
    Button rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coming_soon);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getIntent().getExtras().getString("name"));
        recycler_trailer = findViewById(R.id.recycler_trailer);

        txt_series = findViewById(R.id.txt_series);
        txt = findViewById(R.id.txt);
        main_img = findViewById(R.id.main_img);
        img2 = findViewById(R.id.img2);
        name = findViewById(R.id.name);
        rating = findViewById(R.id.rating);

        recycler_trailer.setHasFixedSize(true);
        manager=new LinearLayoutManager(ComingSoon.this,LinearLayoutManager.HORIZONTAL,false);
        recycler_trailer.setLayoutManager(manager);
        name.setText(getIntent().getExtras().getString("name"));

        Glide.with(ComingSoon.this)
                .asBitmap()
                .load(getIntent().getExtras().getInt("img"))
                .into(main_img);
        Glide.with(ComingSoon.this)
                .asBitmap()
                .load(getIntent().getExtras().getInt("img2"))
                .into(img2);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ComingSoon.this,R.style.CustomAlertDialog);
                ViewGroup viewGroup = v.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog_rating, viewGroup, false);
                TextView cancel=dialogView.findViewById(R.id.cancel);
                TextView add=dialogView.findViewById(R.id.add);
                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }



                });
                alertDialog.show();
            }
        });
        trailerModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));

        trailerAdaapter= new TrailerAdaapter(ComingSoon.this,trailerModels);
        recycler_trailer.setAdapter(trailerAdaapter);

    }

    public class TrailerAdaapter extends RecyclerView.Adapter<TrailerAdaapter.ViewHolder> {

        Context context;
        List<GenreModel> modelList;

        public TrailerAdaapter(Context context, List<GenreModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public TrailerAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_trailers, parent,false);
            return new TrailerAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final TrailerAdaapter.ViewHolder holder, final int position) {

            holder.name.setText(modelList.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImage())
                    .into(holder.img);

        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            ImageView img;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.name);
                img=itemView.findViewById(R.id.img);


            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            startActivity(new Intent(ComingSoon.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(ComingSoon.this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();

    }
}