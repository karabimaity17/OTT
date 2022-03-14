package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.AllViewModel;
import com.example.hotstar.Model.LatestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChooseLanguage extends AppCompatActivity {
    RecyclerView recycler_lang;
    LanguageAdaapter languageAdaapter;
    GridLayoutManager manager;
    List<AllViewModel> allViewModels = new ArrayList<>();
    Button continue_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_lang = findViewById(R.id.recycler_lang);
        continue_btn = findViewById(R.id.continue_btn);
        manager=new GridLayoutManager(ChooseLanguage.this,2);
        recycler_lang.setLayoutManager(manager);

        allViewModels.add(new AllViewModel("1","English",R.drawable.english_3));
        allViewModels.add(new AllViewModel("1","Hindi",R.drawable.movie2));

        languageAdaapter= new LanguageAdaapter(ChooseLanguage.this,allViewModels);
        recycler_lang.setAdapter(languageAdaapter);

        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLanguage.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

    public class LanguageAdaapter extends RecyclerView.Adapter<LanguageAdaapter.ViewHolder> {

        Context context;
        List<AllViewModel> modelList;

        public LanguageAdaapter(Context context, List<AllViewModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public LanguageAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_language, parent,false);
            return new LanguageAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final LanguageAdaapter.ViewHolder holder, final int position) {

            holder.lang_name.setText(modelList.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImg())
                    .into(holder.img);
            holder.rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.fav_img.setImageResource(R.drawable.favourite);
                }
            });
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView lang_name;
            ImageView fav_img,img;
            RelativeLayout rel;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                lang_name=itemView.findViewById(R.id.lang_name);
                fav_img=itemView.findViewById(R.id.fav_img);
                img=itemView.findViewById(R.id.img);
                rel=itemView.findViewById(R.id.rel);

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {


                startActivity(new Intent(ChooseLanguage.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


            startActivity(new Intent(ChooseLanguage.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();


    }
}