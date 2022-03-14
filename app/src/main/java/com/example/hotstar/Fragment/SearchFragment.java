package com.example.hotstar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.hotstar.Model.SearchModel;
import com.example.hotstar.MyAdapter;
import com.example.hotstar.R;
import com.example.hotstar.RecyclerViewAdapter;
import com.example.hotstar.RecyclerViewAdapterNews;
import com.example.hotstar.SingleViewPage;
import com.example.hotstar.Single_Page;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SearchFragment extends Fragment {
    private View view;
    RecyclerView recycler_all_search;
    SearchAdapter searchAdapter;
    ImageView clear;
    List<SearchModel> searchModels = new ArrayList<>();
    AutoCompleteTextView edit_search;

    public SearchFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        recycler_all_search = view.findViewById(R.id.recycler_all_search);
        clear = view.findViewById(R.id.clear);
        edit_search=(AutoCompleteTextView) view.findViewById(R.id.edit_search);
        edit_search.setThreshold(1);//will start working from first character
        recycler_all_search.setHasFixedSize(true);
        recycler_all_search.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetch_all_search();
        searchAdapter= new SearchAdapter(getActivity(),searchModels);
        recycler_all_search.setAdapter(searchAdapter);

        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count==0){
                    recycler_all_search.setVisibility(View.GONE);
                    clear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")){
                    recycler_all_search.setVisibility(View.GONE);
                    clear.setVisibility(View.GONE);
                }else{
                    filter(s.toString());
                    clear.setVisibility(View.VISIBLE);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setText("");
            }
        });
        return view;
    }
    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<SearchModel> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (SearchModel s : searchModels) {
            //if the existing elements contains the search input
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        searchAdapter.filterList(filterdNames);
        recycler_all_search.setVisibility(View.VISIBLE);
    }

    public void fetch_all_search() {
        searchModels.add(new SearchModel(
                "1",
                R.drawable.movie3,
                "Padmavat",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.movie2,
                "Bhuj",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.bengali_movie1,
                "Parineeta",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.english4,
                "Black Widow",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.english1,
                "Joker",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.action_movie4,
                "Shershaah",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.anime_1,
                "Alita Battle Angel",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.action_movie1,
                "Radhe",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.movie1,
                "Bell Bottom",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.tamil1,
                "Maari 2",
                ""
        ));
        searchModels.add(new SearchModel(
                "1",
                R.drawable.english_3,
                "Tenet",
                ""
        ));
        /*Call<String> call= myInterface.fetch_all_search();
        ProgressUtils.showLoadingDialog(getActivity());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body()!=null){
                    String res= response.body();
                    try {

                        JSONArray jsonArray=new JSONArray(res);
                        if (jsonArray.length()==0){
                            recycler_all_search.setVisibility(View.VISIBLE);
                            //Toast.makeText(getActivity(), "No Tenant Found", Toast.LENGTH_SHORT).show();
                            ProgressUtils.cancelLoading();
                        }else {
                            searchModels.clear();
                            for (int i=0;i<jsonArray.length(); i++){
                                JSONObject object= jsonArray.getJSONObject(i);
                                searchModels.add(new SearchModel(
                                        object.getString("id"),
                                        object.getString("image"),
                                        object.getString("product")+object.getString("category"),
                                        object.getString("type")
                                ));

                                ProgressUtils.cancelLoading();
                            }
                        }

                    } catch (JSONException e) {
                        ProgressUtils.cancelLoading();
                        e.printStackTrace();
                    }

                }else {
                    ProgressUtils.cancelLoading();
                    Toast.makeText(getActivity(), "No Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                ProgressUtils.cancelLoading();
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

        Context context;
        List<SearchModel> filteredList;
        List<SearchModel> searchModel;
        String product_url="https://new.easytodb.com/ecom_grocery/product_image/";
        String category_url="https://new.easytodb.com/ecom_grocery/category_images/";
        String subcategory_url="https://new.easytodb.com/ecom_grocery/sub_category_images/";
        String img_url="";

        public SearchAdapter(Context context, List<SearchModel> searchModel) {
            this.context = context;
            this.searchModel = searchModel;
            filteredList = searchModel;
        }

        public void filter(String query) {
            filteredList = new ArrayList<>();
            for (SearchModel model : searchModel) {
                if(model.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(model);
                }
            }
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_search,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, final int position) {

            holder.product_name.setText(searchModel.get(position).getName());

            Glide.with(context)
                    .asBitmap()
                    .load(searchModel.get(position).getImage())
                    .into(holder.image);

//            holder.linear.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Bundle bundle= new Bundle();
//                    bundle.putString("type",searchModel.get(position).getType());
//                    bundle.putString("id",searchModel.get(position).getId());
//                    context.startActivity(new Intent(context, SingleViewPage.class).putExtras(bundle));
//                }
//            });


        }

        @Override
        public int getItemCount() {
            return searchModel.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView product_name;
            ImageView image;
            LinearLayout linear;
            View view;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                product_name=itemView.findViewById(R.id.product_name);
                image=itemView.findViewById(R.id.image);
                linear=itemView.findViewById(R.id.linear);
            }
        }
        public void filterList(ArrayList<SearchModel> filterdNames) {
            this.searchModel = filterdNames;
            notifyDataSetChanged();
        }

    }
}
