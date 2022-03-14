package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.GenreModel;
import com.example.hotstar.Model.LatestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SingleViewPage extends AppCompatActivity {
    RecyclerView recycler_trailer,recycler_more,recycler_episodes;
    TrailerAdaapter trailerAdaapter;
    MoreAdaapter moreAdaapter;
    EpisodeAdaapter episodeAdaapter;
    LinearLayoutManager manager,manager2,manager3;
    List<GenreModel> trailerModels = new ArrayList<>();
    List<LatestModel> moreModels = new ArrayList<>();
    List<GenreModel> episodeModels = new ArrayList<>();
    String type;
    TextView txt_series,name,txt;
    ImageView main_img,img2;
    Button rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getIntent().getExtras().getString("name"));
        recycler_trailer = findViewById(R.id.recycler_trailer);
        recycler_more = findViewById(R.id.recycler_more);
        recycler_episodes = findViewById(R.id.recycler_episodes);
        txt_series = findViewById(R.id.txt_series);
        txt = findViewById(R.id.txt);
        main_img = findViewById(R.id.main_img);
        img2 = findViewById(R.id.img2);
        name = findViewById(R.id.name);
        rating = findViewById(R.id.rating);

        recycler_trailer.setHasFixedSize(true);
        recycler_more.setHasFixedSize(true);
        recycler_episodes.setHasFixedSize(true);

        manager=new LinearLayoutManager(SingleViewPage.this,LinearLayoutManager.HORIZONTAL,false);
        manager2=new LinearLayoutManager(SingleViewPage.this,LinearLayoutManager.HORIZONTAL,false);
        manager3=new LinearLayoutManager(SingleViewPage.this,LinearLayoutManager.HORIZONTAL,false);

        recycler_trailer.setLayoutManager(manager);
        recycler_more.setLayoutManager(manager2);
        recycler_episodes.setLayoutManager(manager3);

        type=getIntent().getExtras().getString("type");
        name.setText(getIntent().getExtras().getString("name"));
        if(type.equals("movie")){
            txt_series.setVisibility(View.GONE);
            recycler_episodes.setVisibility(View.GONE);
            txt.setText("Watch Movie");
            moreModels.add(new LatestModel("1", "Radhe", "movie", R.drawable.action_movie1_1, R.drawable.action_movie1));
            moreModels.add(new LatestModel("1", "The Tommorrow War", "movie", R.drawable.action_movie3_3, R.drawable.action_movie3));
            moreModels.add(new LatestModel("1", "Bhuj", "movie", R.drawable.movie2_2, R.drawable.movie2));
            moreModels.add(new LatestModel("1", "Shershaah", "movie", R.drawable.action_movie4_4, R.drawable.action_movie4));
            moreModels.add(new LatestModel("1", "Rava", "movie", R.drawable.anime2_2, R.drawable.anime2));
            moreModels.add(new LatestModel("1", "Sonu ki Titu ki Sweety", "movie", R.drawable.comedy3_3, R.drawable.comedy3));
            moreModels.add(new LatestModel("1", "Good Newz", "movie", R.drawable.comedy4_4, R.drawable.comedy4));
            moreModels.add(new LatestModel("1", "Bang Bang", "movie", R.drawable.movie5, R.drawable.movie5_5));
            moreModels.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
            moreModels.add(new LatestModel("1","Rava","movie",R.drawable.anime2_2,R.drawable.anime2));
            moreModels.add(new LatestModel("1","Joker","movie",R.drawable.english1_1,R.drawable.english1));
            moreModels.add(new LatestModel("1","Tenet","movie",R.drawable.english3_3,R.drawable.english_3));
            moreModels.add(new LatestModel("1","Extraction","movie",R.drawable.english2_2,R.drawable.english2));
            moreModels.add(new LatestModel("1","Mowgli","movie",R.drawable.anime3_3,R.drawable.anime3_3));
            moreModels.add(new LatestModel("1","Alita Battle Angel","movie",R.drawable.anime1_1,R.drawable.anime_1));
            moreModels.add(new LatestModel("1","Parineeta","movie",R.drawable.bengali_movie1_1,R.drawable.bengali_movie1));
            moreModels.add(new LatestModel("1","Guptodhoner Sondhane","movie",R.drawable.bengali2_2,R.drawable.bengali_movie2));
            moreModels.add(new LatestModel("1","Ghore Baire","movie",R.drawable.bengali_movie3_3,R.drawable.bengali_movie3));
            moreModels.add(new LatestModel("1","Robibar","movie",R.drawable.bengali_movie4_4,R.drawable.bengali_movie4));
            moreModels.add(new LatestModel("1","Maari 2","movie",R.drawable.tamil1_1,R.drawable.tamil1));
            moreModels.add(new LatestModel("1","Thalapathy","movie",R.drawable.tamil2_2,R.drawable.tamil2));
            moreModels.add(new LatestModel("1","Sultaan","movie",R.drawable.tamil3_3,R.drawable.tamil3));
        }else{
            txt_series.setVisibility(View.VISIBLE);
            recycler_episodes.setVisibility(View.VISIBLE);
            txt.setText("Watch Latest Episode");
            moreModels.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
            moreModels.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));
            moreModels.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
            moreModels.add(new LatestModel("1","Hostages","series",R.drawable.series3_3,R.drawable.serie3));
            moreModels.add(new LatestModel("1","Special Ops","series",R.drawable.series4_4,R.drawable.series4));
            moreModels.add(new LatestModel("1","Tandav","series",R.drawable.series6_6,R.drawable.series6));
            moreModels.add(new LatestModel("1","Mirzapur","series",R.drawable.series7_7,R.drawable.series7));

        }

        Glide.with(SingleViewPage.this)
                .asBitmap()
                .load(getIntent().getExtras().getInt("img"))
                .into(main_img);
        Glide.with(SingleViewPage.this)
                .asBitmap()
                .load(getIntent().getExtras().getInt("img2"))
                .into(img2);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(SingleViewPage.this,R.style.CustomAlertDialog);
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


        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));
        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));
        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));
        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));
        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));
        episodeModels.add(new GenreModel("1",getIntent().getExtras().getString("name"),getIntent().getExtras().getInt("img")));

        trailerAdaapter= new TrailerAdaapter(SingleViewPage.this,trailerModels);
        recycler_trailer.setAdapter(trailerAdaapter);

        moreAdaapter= new MoreAdaapter(SingleViewPage.this,moreModels);
        recycler_more.setAdapter(moreAdaapter);


        episodeAdaapter= new EpisodeAdaapter(SingleViewPage.this,episodeModels);
        recycler_episodes.setAdapter(episodeAdaapter);

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


    public class MoreAdaapter extends RecyclerView.Adapter<MoreAdaapter.ViewHolder> {

        Context context;
        List<LatestModel> modelList;

        public MoreAdaapter(Context context, List<LatestModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public MoreAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_page, parent,false);
            return new MoreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final MoreAdaapter.ViewHolder holder, final int position) {

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
                    Intent intent=new Intent(SingleViewPage.this, SingleViewPage.class).putExtras(bundle);
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
            TextView genre_name;
            ImageView img;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                genre_name=itemView.findViewById(R.id.genre_name);
                img=itemView.findViewById(R.id.img);

            }
        }
    }

    public class EpisodeAdaapter extends RecyclerView.Adapter<EpisodeAdaapter.ViewHolder> {

        Context context;
        List<GenreModel> modelList;

        public EpisodeAdaapter(Context context, List<GenreModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public EpisodeAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_episodes, parent,false);
            return new EpisodeAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final EpisodeAdaapter.ViewHolder holder, final int position) {

            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImage())
                    .into(holder.img);
            holder.watch_movie.setVisibility(View.GONE);
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView genre_name,watch_movie;
            ImageView img;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                genre_name=itemView.findViewById(R.id.genre_name);
                img=itemView.findViewById(R.id.img);
                watch_movie=itemView.findViewById(R.id.watch_movie);

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            startActivity(new Intent(SingleViewPage.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(SingleViewPage.this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();

    }
}