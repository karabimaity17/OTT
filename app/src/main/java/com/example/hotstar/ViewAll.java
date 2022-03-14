package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.LatestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    RecyclerView recycler_download;
    GenreAdaapter genreAdaapter;
    List<LatestModel> genreModels = new ArrayList<>();
    NestedScrollView nested;
    GridLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("name"));

        recycler_download = findViewById(R.id.recycler_download);
        nested = findViewById(R.id.nested);
        recycler_download.setHasFixedSize(true);
        manager=new GridLayoutManager(ViewAll.this,3);
        recycler_download.setLayoutManager(manager);



        genreModels.add(new LatestModel("1", "Radhe", "movie", R.drawable.action_movie1_1, R.drawable.action_movie1));
        genreModels.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
        genreModels.add(new LatestModel("1", "The Tommorrow War", "movie", R.drawable.action_movie3_3, R.drawable.action_movie3));

        genreModels.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
        genreModels.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));

        genreModels.add(new LatestModel("1", "Bhuj", "movie", R.drawable.movie2_2, R.drawable.movie2));
        genreModels.add(new LatestModel("1", "Shershaah", "movie", R.drawable.action_movie4_4, R.drawable.action_movie4));

        genreModels.add(new LatestModel("1", "Radhe", "movie", R.drawable.action_movie1_1, R.drawable.action_movie1));
        genreModels.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
        genreModels.add(new LatestModel("1", "The Tommorrow War", "movie", R.drawable.action_movie3_3, R.drawable.action_movie3));

        genreModels.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
        genreModels.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));

        genreModels.add(new LatestModel("1", "Bhuj", "movie", R.drawable.movie2_2, R.drawable.movie2));
        genreModels.add(new LatestModel("1", "Shershaah", "movie", R.drawable.action_movie4_4, R.drawable.action_movie4));

        genreAdaapter= new GenreAdaapter(ViewAll.this,genreModels);
        recycler_download.setAdapter(genreAdaapter);
    }

    public class GenreAdaapter extends RecyclerView.Adapter<GenreAdaapter.ViewHolder> {

        Context context;
        List<LatestModel> modelList;

        public GenreAdaapter(Context context, List<LatestModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public GenreAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_page, parent,false);
            return new GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final GenreAdaapter.ViewHolder holder, final int position) {


            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImg2())
                    .into(holder.img);

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("type",modelList.get(position).getType());
                    bundle.putString("name",modelList.get(position).getName());
                    bundle.putInt("img",modelList.get(position).getImg());
                    bundle.putInt("img2",modelList.get(position).getImg2());
                    Intent intent=new Intent(context, SingleViewPage.class).putExtras(bundle);
                    overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txt2,watch_movie,details,download_btn;
            LinearLayout lin1;
            ImageView img;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);


                img=itemView.findViewById(R.id.img);
                watch_movie=itemView.findViewById(R.id.watch_movie);
                txt2=itemView.findViewById(R.id.txt2);
                lin1=itemView.findViewById(R.id.lin1);
                details=itemView.findViewById(R.id.details);
                download_btn=itemView.findViewById(R.id.download_btn);

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {


            startActivity(new Intent(ViewAll.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        startActivity(new Intent(ViewAll.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();


    }
}
