package com.example.hotstar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.AllViewModel;
import com.example.hotstar.Model.GenreModel;
import com.example.hotstar.Model.LatestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GenreActivity extends AppCompatActivity {
    RecyclerView recycler_genre;
    GenreAdaapter genreAdaapter;
    List<LatestModel> genreModels = new ArrayList<>();
    NestedScrollView nested;
    GridLayoutManager manager;
    int page=0;
    boolean loadMore= false;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_genre = findViewById(R.id.recycler_genre);
        nested = findViewById(R.id.nested);
        recycler_genre.setHasFixedSize(true);
        manager=new GridLayoutManager(GenreActivity.this,2);
        recycler_genre.setLayoutManager(manager);
        getSupportActionBar().setTitle(getIntent().getExtras().getString("name"));
        id=getIntent().getExtras().getString("id");

       /* nested.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())){

                    //loadMore=true;
                    if (loadMore && (currentItems + scrollOutItems == totalItems)) {
                        page++;
                        fetch_recent_product(page);

                    }
                }
                if (scrollY < oldScrollY ){
                    loadMore =false;
                }else{
                    loadMore = true;
                }
            }
        });
        fetch_recent_product(page);
*/
       if(id.equals("1")){
           genreModels.add(new LatestModel("1","Radhe","movie",R.drawable.action_movie1_1,R.drawable.action_movie1));
           genreModels.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));
           genreModels.add(new LatestModel("1","Shershaah","movie",R.drawable.action_movie4_4,R.drawable.action_movie4));
           genreModels.add(new LatestModel("1","Sonu ki Titu ki Sweety","movie",R.drawable.comedy3_3,R.drawable.comedy3));
           genreModels.add(new LatestModel("1","Good Newz","movie",R.drawable.comedy4_4,R.drawable.comedy4));
           genreModels.add(new LatestModel("1","Bang Bang","movie",R.drawable.movie5,R.drawable.movie5_5));
           genreModels.add(new LatestModel("1","Badhaai Ho","movie",R.drawable.comedy1_1,R.drawable.comedy1));
           genreModels.add(new LatestModel("1","Motu Patlu","movie",R.drawable.anime4_4,R.drawable.anime4));
       }else if(id.equals("2")){
           genreModels.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
           genreModels.add(new LatestModel("1","Rava","movie",R.drawable.anime2_2,R.drawable.anime2));
           genreModels.add(new LatestModel("1","Joker","movie",R.drawable.english1_1,R.drawable.english1));
           genreModels.add(new LatestModel("1","Tenet","movie",R.drawable.english3_3,R.drawable.english_3));
           genreModels.add(new LatestModel("1","Extraction","movie",R.drawable.english2_2,R.drawable.english2));
           genreModels.add(new LatestModel("1","Mowgli","movie",R.drawable.anime3_3,R.drawable.anime3_3));
           genreModels.add(new LatestModel("1","Alita Battle Angel","movie",R.drawable.anime1_1,R.drawable.anime_1));
       }else if(id.equals("3")) {
           genreModels.add(new LatestModel("1","Parineeta","movie",R.drawable.bengali_movie1_1,R.drawable.bengali_movie1));
           genreModels.add(new LatestModel("1","Guptodhoner Sondhane","movie",R.drawable.bengali2_2,R.drawable.bengali_movie2));
           genreModels.add(new LatestModel("1","Ghore Baire","movie",R.drawable.bengali_movie3_3,R.drawable.bengali_movie3));
           genreModels.add(new LatestModel("1","Robibar","movie",R.drawable.bengali_movie4_4,R.drawable.bengali_movie4));
        } else if(id.equals("4")) {
           genreModels.add(new LatestModel("1","Maari 2","movie",R.drawable.tamil1_1,R.drawable.tamil1));
           genreModels.add(new LatestModel("1","Thalapathy","movie",R.drawable.tamil2_2,R.drawable.tamil2));
           genreModels.add(new LatestModel("1","Sultaan","movie",R.drawable.tamil3_3,R.drawable.tamil3));

        }else {
           genreModels.add(new LatestModel("1", "Radhe", "movie", R.drawable.action_movie1_1, R.drawable.action_movie1));
           genreModels.add(new LatestModel("1", "The Tommorrow War", "movie", R.drawable.action_movie3_3, R.drawable.action_movie3));
           genreModels.add(new LatestModel("1", "Bhuj", "movie", R.drawable.movie2_2, R.drawable.movie2));
           genreModels.add(new LatestModel("1", "Shershaah", "movie", R.drawable.action_movie4_4, R.drawable.action_movie4));
           genreModels.add(new LatestModel("1", "Rava", "movie", R.drawable.anime2_2, R.drawable.anime2));
           genreModels.add(new LatestModel("1", "Sonu ki Titu ki Sweety", "movie", R.drawable.comedy3_3, R.drawable.comedy3));
           genreModels.add(new LatestModel("1", "Good Newz", "movie", R.drawable.comedy4_4, R.drawable.comedy4));
           genreModels.add(new LatestModel("1", "Bang Bang", "movie", R.drawable.movie5, R.drawable.movie5_5));
           genreModels.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
           genreModels.add(new LatestModel("1","Rava","movie",R.drawable.anime2_2,R.drawable.anime2));
           genreModels.add(new LatestModel("1","Joker","movie",R.drawable.english1_1,R.drawable.english1));
           genreModels.add(new LatestModel("1","Tenet","movie",R.drawable.english3_3,R.drawable.english_3));
           genreModels.add(new LatestModel("1","Extraction","movie",R.drawable.english2_2,R.drawable.english2));
           genreModels.add(new LatestModel("1","Mowgli","movie",R.drawable.anime3_3,R.drawable.anime3_3));
           genreModels.add(new LatestModel("1","Alita Battle Angel","movie",R.drawable.anime1_1,R.drawable.anime_1));
           genreModels.add(new LatestModel("1","Parineeta","movie",R.drawable.bengali_movie1_1,R.drawable.bengali_movie1));
           genreModels.add(new LatestModel("1","Guptodhoner Sondhane","movie",R.drawable.bengali2_2,R.drawable.bengali_movie2));
           genreModels.add(new LatestModel("1","Ghore Baire","movie",R.drawable.bengali_movie3_3,R.drawable.bengali_movie3));
           genreModels.add(new LatestModel("1","Robibar","movie",R.drawable.bengali_movie4_4,R.drawable.bengali_movie4));
           genreModels.add(new LatestModel("1","Maari 2","movie",R.drawable.tamil1_1,R.drawable.tamil1));
           genreModels.add(new LatestModel("1","Thalapathy","movie",R.drawable.tamil2_2,R.drawable.tamil2));
           genreModels.add(new LatestModel("1","Sultaan","movie",R.drawable.tamil3_3,R.drawable.tamil3));
       }
        genreAdaapter= new GenreAdaapter(GenreActivity.this,genreModels);
        recycler_genre.setAdapter(genreAdaapter);
    }
   /* private void fetch_recent_product(int page) {
        Call<String> call=myInterface.fetch_recent_products(user_id, f_id,"Other",String.valueOf(page));
        ProgressUtils.showLoadingDialog(RecentProduct.this);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body()!=null){
                    String res=response.body();
                    try {
                        JSONArray array= new JSONArray(res);

                        if (array.length()==0){
                            recycler_recent.setVisibility(View.VISIBLE);
                            ProgressUtils.cancelLoading();
                            Toast.makeText(RecentProduct.this, "No Recent Product found", Toast.LENGTH_SHORT).show();
                        }else{
                            recycler_recent.setVisibility(View.VISIBLE);
                            //  productModels.clear();
                            for (int j=0;j<array.length();j++){
                                JSONObject object1= array.getJSONObject(j);
                                productModels.add(new ProductModel(
                                        object1.getString("product_id"),
                                        object1.getString("brand"),
                                        object1.getString("product_name"),
                                        object1.getString("quantity"),
                                        new DecimalFormat("##.##").format(Double.parseDouble(object1.getString("product_price"))),
                                        new DecimalFormat("##.##").format(Double.parseDouble(object1.getString("discounted_price"))),
                                        object1.getString("discount"),
                                        object1.getString("image"),
                                        object1.getString("cat_id"),
                                        object1.getString("qty_id"),
                                        object1.getString("stock"),
                                        object1.getString("gst_percentage"),
                                        object1.getString("count"),
                                        object1.getString("top_deal")


                                ));

                                recentProductAdaapter.notifyDataSetChanged();
                            }

                            ProgressUtils.cancelLoading();


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        ProgressUtils.cancelLoading();
                    }
                }else{
                    ProgressUtils.cancelLoading();
                    Toast.makeText(RecentProduct.this, "No Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                ProgressUtils.cancelLoading();
                Toast.makeText(RecentProduct.this, "Slow network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

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
            View view = inflater.inflate(R.layout.custom_genre, parent,false);
            return new GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final GenreAdaapter.ViewHolder holder, final int position) {

            holder.genre_name.setText(modelList.get(position).getName());
            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImg())
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

            if (getIntent().getExtras().getString("id").equals("6")) {
                startActivity(new Intent(GenreActivity.this, AllGenre.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();
            }else {
                startActivity(new Intent(GenreActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (getIntent().getExtras().getString("id").equals("6")) {
            startActivity(new Intent(GenreActivity.this, AllGenre.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }else {
            startActivity(new Intent(GenreActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }

    }
}