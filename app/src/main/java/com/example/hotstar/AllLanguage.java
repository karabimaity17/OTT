package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Fragment.HomeFragment;
import com.example.hotstar.Model.GenreModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllLanguage extends AppCompatActivity {

    RecyclerView recycler_language;
    GenreAdaapter languageAdapter;
    List<GenreModel> languageModels = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_language);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_language = findViewById(R.id.recycler_language);

        recycler_language.setHasFixedSize(true);
        GridLayoutManager layoutManager2=new GridLayoutManager(AllLanguage.this,2);
        recycler_language.setLayoutManager(layoutManager2);

        languageModels.add(new GenreModel("1","Hindi",R.drawable.movie3_3));
        languageModels.add(new GenreModel("2","English",R.drawable.english2_2));
        languageModels.add(new GenreModel("3","Bengali",R.drawable.bengali_movie1_1));
        languageModels.add(new GenreModel("4","Tamil",R.drawable.tamil1_1));

        languageAdapter= new  GenreAdaapter(AllLanguage.this,languageModels);
        recycler_language.setAdapter(languageAdapter);
    }

    public class GenreAdaapter extends RecyclerView.Adapter< GenreAdaapter.ViewHolder> {

        Context context;
        List<GenreModel> modelList;

        public GenreAdaapter(Context context, List<GenreModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public   GenreAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_genre, parent,false);
            return new   GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final   GenreAdaapter.ViewHolder holder, final int position) {

            holder.genre_name.setText(modelList.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImage())
                    .into(holder.img);

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("name",modelList.get(position).getName());
                    bundle.putString("id",modelList.get(position).getId());
                    startActivity(new Intent(context,GenreActivity.class).putExtras(bundle));
                     overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                   finish();

                }
            });
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView genre_name;
            ImageView img;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                genre_name=itemView.findViewById(R.id.genre_name);
                img=itemView.findViewById(R.id.img);

            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {


            startActivity(new Intent(AllLanguage.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        startActivity(new Intent(AllLanguage.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();


    }
}