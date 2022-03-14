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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllGenre extends AppCompatActivity {
    RecyclerView recycler_genre;
    GenreAdaapter genreAdaapter;
    List<GenreModel> genreModels = new ArrayList<>();
    NestedScrollView nested;
    GridLayoutManager manager;
    int page=0;
    boolean loadMore= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_genre);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_genre = findViewById(R.id.recycler_genre);
        nested = findViewById(R.id.nested);
        recycler_genre.setHasFixedSize(true);
        manager=new GridLayoutManager(AllGenre.this,2);
        recycler_genre.setLayoutManager(manager);
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
        genreModels.add(new GenreModel("6","Romance",R.drawable.img_genre1));
        genreModels.add(new GenreModel("6","Drama",R.drawable.img_genre2));
        genreModels.add(new GenreModel("6","Lifestyle",R.drawable.img_genre3));
        genreModels.add(new GenreModel("6","Kids",R.drawable.img_genre16));
        genreModels.add(new GenreModel("6","Teen",R.drawable.img_genre4));
        genreModels.add(new GenreModel("6","Reality",R.drawable.img_genre5));
        genreModels.add(new GenreModel("6","Family",R.drawable.img_genre6));
        genreModels.add(new GenreModel("6","Comedy",R.drawable.img_genre7));
        genreModels.add(new GenreModel("6","Action",R.drawable.img_genre8));
        genreModels.add(new GenreModel("6","Thriller",R.drawable.img_genre9));
        genreModels.add(new GenreModel("6","Talk show",R.drawable.img_genre10));
        genreModels.add(new GenreModel("6","Awards",R.drawable.img_genre11));
        genreModels.add(new GenreModel("6","Science",R.drawable.img_genre12));
        genreModels.add(new GenreModel("6","Travel",R.drawable.img_genre13));
        genreModels.add(new GenreModel("6","Horror",R.drawable.img_genre14));
        genreModels.add(new GenreModel("6","Sports",R.drawable.img_genre15));
        genreModels.add(new GenreModel("6","animation",R.drawable.img_genre16));
        genreModels.add(new GenreModel("6","adventure",R.drawable.img_genre17));

        genreAdaapter= new  GenreAdaapter(AllGenre.this,genreModels);
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

    public class GenreAdaapter extends RecyclerView.Adapter< GenreAdaapter.ViewHolder> {

        Context context;
        List<GenreModel> modelList;

        public GenreAdaapter(Context context, List<GenreModel> modelList) {
            this.context = context;
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public  GenreAdaapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_genre, parent,false);
            return new  GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final  GenreAdaapter.ViewHolder holder, final int position) {

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

            startActivity(new Intent(AllGenre.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(AllGenre.this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();

    }
}