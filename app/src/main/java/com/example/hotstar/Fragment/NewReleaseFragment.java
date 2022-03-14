package com.example.hotstar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotstar.ComingSoon;
import com.example.hotstar.Downloads;
import com.example.hotstar.Model.LatestModel;
import com.example.hotstar.Model.SearchModel;
import com.example.hotstar.R;
import com.example.hotstar.SingleViewPage;

import java.util.ArrayList;
import java.util.List;

public class NewReleaseFragment extends Fragment {
    private View view;
    RecyclerView recycler_new;
    GenreAdaapter genreAdaapter;
    List<LatestModel> comingModel = new ArrayList<>();
    NestedScrollView nested;
    GridLayoutManager manager;

    public NewReleaseFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_release, container, false);
        recycler_new = view.findViewById(R.id.recycler_new);
        nested = view.findViewById(R.id.nested);
        recycler_new.setHasFixedSize(true);
        manager=new GridLayoutManager(getActivity(),2);
        recycler_new.setLayoutManager(manager);

        comingModel.add(new LatestModel("1","83","movie",R.drawable.coming_soon1_1,R.drawable.coming_soon1));
        comingModel.add(new LatestModel("1","Suryavanshi","movie",R.drawable.coming_soon2_2,R.drawable.coming_soon2));
        comingModel.add(new LatestModel("1","Bhoot Police","movie",R.drawable.coming_soon3_3,R.drawable.coming_soon3));
        comingModel.add(new LatestModel("1","Dhaakad","movie",R.drawable.action_movie2_2,R.drawable.action_movie2));

        genreAdaapter= new GenreAdaapter(getActivity(),comingModel);
        recycler_new.setAdapter(genreAdaapter);
        return view;
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
            View view = inflater.inflate(R.layout.custom_new, parent,false);
            return new GenreAdaapter.ViewHolder(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(@NonNull final GenreAdaapter.ViewHolder holder, final int position) {


            Glide.with(context)
                    .asBitmap()
                    .load(modelList.get(position).getImg())
                    .into(holder.img);
            holder.name.setText(modelList.get(position).getName());
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("type",modelList.get(position).getType());
                    bundle.putString("name",modelList.get(position).getName());
                    bundle.putInt("img",modelList.get(position).getImg());
                    bundle.putInt("img2",modelList.get(position).getImg2());
                    Intent intent=new Intent(context, ComingSoon.class).putExtras(bundle);
                    getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    startActivity(intent);
                }
            });
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


                img=itemView.findViewById(R.id.img);
                name=itemView.findViewById(R.id.name);


            }
        }
    }
}
