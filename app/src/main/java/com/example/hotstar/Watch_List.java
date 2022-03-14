package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.LatestModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Watch_List extends AppCompatActivity{

    RecyclerView recycler_watchlist;
     GenreAdaapter genreAdaapter;
    List<LatestModel> genreModels = new ArrayList<>();
    NestedScrollView nested;
    GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch__list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_watchlist = findViewById(R.id.recycler_watchlist);
        nested = findViewById(R.id.nested);
        recycler_watchlist.setHasFixedSize(true);
        manager=new GridLayoutManager(Watch_List.this,2);
        recycler_watchlist.setLayoutManager(manager);



        genreModels.add(new LatestModel("1", "Radhe", "movie", R.drawable.action_movie1_1, R.drawable.action_movie1));
        genreModels.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
        genreModels.add(new LatestModel("1", "The Tommorrow War", "movie", R.drawable.action_movie3_3, R.drawable.action_movie3));

        genreModels.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
        genreModels.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));

        genreModels.add(new LatestModel("1", "Bhuj", "movie", R.drawable.movie2_2, R.drawable.movie2));
        genreModels.add(new LatestModel("1", "Shershaah", "movie", R.drawable.action_movie4_4, R.drawable.action_movie4));

        genreAdaapter= new GenreAdaapter(Watch_List.this,genreModels);
        recycler_watchlist.setAdapter(genreAdaapter);
    }

    public class GenreAdaapter extends RecyclerView.Adapter< GenreAdaapter.ViewHolder> {

        Context context;
        List<LatestModel> modelList;

        public GenreAdaapter(Context context, List<LatestModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public  GenreAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_download, parent,false);
            return new  GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final  GenreAdaapter.ViewHolder holder, final int position) {


            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImg())
                    .into(holder.img);
            holder.details.setVisibility(View.GONE);
            holder.download_btn.setVisibility(View.GONE);
            if (modelList.get(position).getType().equals("movie")){
                holder.txt2.setVisibility(View.GONE);
                holder.lin1.setVisibility(View.GONE);
                holder.watch_movie.setVisibility(View.VISIBLE);

            }else{
                holder.txt2.setVisibility(View.VISIBLE);
                holder.txt2.setText(modelList.get(position).getName());
                holder.watch_movie.setVisibility(View.GONE);
                holder.lin1.setVisibility(View.VISIBLE);

            }
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
                download_btn=itemView.findViewById(R.id.download_btn);
                txt2=itemView.findViewById(R.id.txt2);
                lin1=itemView.findViewById(R.id.lin1);
                details=itemView.findViewById(R.id.details);

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {


                startActivity(new Intent(Watch_List.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


            startActivity(new Intent(Watch_List.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();


    }
}
