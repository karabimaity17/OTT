package com.example.hotstar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.hotstar.AllGenre;
import com.example.hotstar.GenreActivity;
import com.example.hotstar.MainActivity;
import com.example.hotstar.Model.AllViewModel;
import com.example.hotstar.Model.GenreModel;
import com.example.hotstar.Model.LatestModel;
import com.example.hotstar.MyAdapter;
import com.example.hotstar.R;
import com.example.hotstar.RecyclerViewAdapter;
import com.example.hotstar.RecyclerViewAdapterChoice;
import com.example.hotstar.RecyclerViewAdapterComedy;
import com.example.hotstar.RecyclerViewAdapterDrama;
import com.example.hotstar.RecyclerViewAdapterFamily;
import com.example.hotstar.RecyclerViewAdapterNew;
import com.example.hotstar.RecyclerViewAdapterNews;

import com.example.hotstar.RecyclerViewAdapterWeek;
import com.example.hotstar.SingleViewPage;
import com.example.hotstar.Single_Page;
import com.example.hotstar.ViewAll;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    private View view;

    DotsIndicator indicator;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    private List<LatestModel> comedyModel = new ArrayList<LatestModel>();
    private List<LatestModel> animeModel = new ArrayList<LatestModel>();
    private List<LatestModel> actionModel = new ArrayList<LatestModel>();
    private List<LatestModel> dramaModel = new ArrayList<LatestModel>();
    private List<LatestModel> tvshowModel = new ArrayList<LatestModel>();
    private List<LatestModel> recentModel = new ArrayList<LatestModel>();
    private List<LatestModel> top_movieModel = new ArrayList<LatestModel>();
    private List<LatestModel> comingModel = new ArrayList<LatestModel>();
    private List<AllViewModel> allViewModels = new ArrayList<AllViewModel>();
    private List<LatestModel> latestModels = new ArrayList<LatestModel>();
    List<GenreModel> genreModels = new ArrayList<>();
    List<GenreModel> languageModels = new ArrayList<>();
    RecyclerView recycler_genre,recycler_language;
    GenreAdaapter genreAdaapter;
    GenreAdaapter languageAdapter;
    ImageView arrow1,arrow2;

    private ArrayList<Integer> mImageUrls=new ArrayList<>();
    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        mPager = (ViewPager) view.findViewById(R.id.viewPager);
        indicator =  view.findViewById(R.id.indicator);
        recycler_genre =  view.findViewById(R.id.recycler_genre);
        recycler_language =  view.findViewById(R.id.recycler_language);
        arrow1 =  view.findViewById(R.id.arrow1);
        arrow2 =  view.findViewById(R.id.arrow2);

        mPager.setPadding(30, 0, 30, 0);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("name","Latest & Trending");
                Intent intent=new Intent(getActivity(), ViewAll.class).putExtras(bundle);
                getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                startActivity(intent);
            }
        });
        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("name","Top Movies");
                Intent intent=new Intent(getActivity(), ViewAll.class).putExtras(bundle);
                getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                startActivity(intent);
            }
        });
        init();
        initImageBitmaps();
        return view;
    }
    private void init() {
        mImageUrls.add(R.drawable.action_movie3_3);
        mImageUrls.add(R.drawable.serie1_1);
        mImageUrls.add(R.drawable.action_movie1_1);
        mImageUrls.add(R.drawable.coming_soon1_1);
        mImageUrls.add(R.drawable.coming_soon3_3);
        mImageUrls.add(R.drawable.anime2_2);

        mPager.setAdapter(new MyAdapter(getActivity(),mImageUrls));
        indicator.setViewPager(mPager);
        mPager.setOffscreenPageLimit(mImageUrls.size());
        /*final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == mImageUrls.size()) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);*/
    }



    private void initImageBitmaps()
    {
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");




        initRecyclerView();
        initRecyclerViewNews();
        comedyModel.add(new LatestModel("1","Badhaai Ho","movie",R.drawable.comedy1_1,R.drawable.comedy1));
        comedyModel.add(new LatestModel("1","Pagalpanti","movie",R.drawable.comedy2_2,R.drawable.comedy2));
        comedyModel.add(new LatestModel("1","Sonu ki Titu ki Sweety","movie",R.drawable.comedy3_3,R.drawable.comedy3));
        comedyModel.add(new LatestModel("1","Good Newz","movie",R.drawable.comedy4_4,R.drawable.comedy4));


        top_movieModel.add(new LatestModel("1","Radhe","movie",R.drawable.action_movie1_1,R.drawable.action_movie1));
        top_movieModel.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
        top_movieModel.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));
        top_movieModel.add(new LatestModel("1","Shershaah","movie",R.drawable.action_movie4_4,R.drawable.action_movie4));
        top_movieModel.add(new LatestModel("1","Rava","movie",R.drawable.anime2_2,R.drawable.anime2));
        top_movieModel.add(new LatestModel("1","Sonu ki Titu ki Sweety","movie",R.drawable.comedy3_3,R.drawable.comedy3));
        top_movieModel.add(new LatestModel("1","Good Newz","movie",R.drawable.comedy4_4,R.drawable.comedy4));

        actionModel.add(new LatestModel("1","Radhe","movie",R.drawable.action_movie1_1,R.drawable.action_movie1));
        actionModel.add(new LatestModel("1","Dhaakad","movie",R.drawable.action_movie2_2,R.drawable.action_movie2));
        actionModel.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
        actionModel.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));
        actionModel.add(new LatestModel("1","Bang Bang","movie",R.drawable.movie5,R.drawable.movie5_5));



        recentModel.add(new LatestModel("1","Shershaah","movie",R.drawable.action_movie4_4,R.drawable.action_movie4));
        recentModel.add(new LatestModel("1","The Tommorrow War","movie",R.drawable.action_movie3_3,R.drawable.action_movie3));
        recentModel.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));
        recentModel.add(new LatestModel("1","Bang Bang","movie",R.drawable.movie5,R.drawable.movie5_5));
        recentModel.add(new LatestModel("1","Radhe","movie",R.drawable.action_movie1_1,R.drawable.action_movie1));

        dramaModel.add(new LatestModel("1","Badhaai Ho","movie",R.drawable.comedy1_1,R.drawable.comedy1));
        dramaModel.add(new LatestModel("1","Shershaah","movie",R.drawable.action_movie4_4,R.drawable.action_movie4));
        dramaModel.add(new LatestModel("1","Good Newz","movie",R.drawable.comedy4_4,R.drawable.comedy4));
        dramaModel.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));

        animeModel.add(new LatestModel("1","Alita Battle Angel","movie",R.drawable.anime1_1,R.drawable.anime_1));
        animeModel.add(new LatestModel("1","Rava","movie",R.drawable.anime2_2,R.drawable.anime2));
        animeModel.add(new LatestModel("1","Mowgli","movie",R.drawable.anime3_3,R.drawable.anime3));
        animeModel.add(new LatestModel("1","Motu Patlu","movie",R.drawable.anime4_4,R.drawable.anime4));

        tvshowModel.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
        tvshowModel.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));
        tvshowModel.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
        tvshowModel.add(new LatestModel("1","Hostages","series",R.drawable.series3_3,R.drawable.serie3));
        tvshowModel.add(new LatestModel("1","Special Ops","series",R.drawable.series4_4,R.drawable.series4));
        tvshowModel.add(new LatestModel("1","Tandav","series",R.drawable.series6_6,R.drawable.series6));
        tvshowModel.add(new LatestModel("1","Mirzapur","series",R.drawable.series7_7,R.drawable.series7));


        comingModel.add(new LatestModel("1","83","movie",R.drawable.coming_soon1_1,R.drawable.coming_soon1));
        comingModel.add(new LatestModel("1","Suryavanshi","movie",R.drawable.coming_soon2_2,R.drawable.coming_soon2));
        comingModel.add(new LatestModel("1","Bhoot Police","movie",R.drawable.coming_soon3_3,R.drawable.coming_soon3));


        allViewModels.add(new AllViewModel("Web Series",tvshowModel));
        allViewModels.add(new AllViewModel("Recently Added Movies",recentModel));
        allViewModels.add(new AllViewModel("Drama Movies",dramaModel));
        allViewModels.add(new AllViewModel("Action Movies",actionModel));
        allViewModels.add(new AllViewModel("Comedy Movies",comedyModel));
        allViewModels.add(new AllViewModel("Kids & Family Tv",animeModel));
        allViewModels.add(new AllViewModel("Coming Soon",comingModel));
        allViewModels.add(new AllViewModel("Most Popular",recentModel));
        allViewModels.add(new AllViewModel("Recommended Web Series",tvshowModel));
        allViewModels.add(new AllViewModel("Recommended Movies",recentModel));
        initRecyclerViewPopular();

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler_genre.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager2=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler_language.setLayoutManager(layoutManager2);

        genreModels.add(new GenreModel("5","Romance",R.drawable.img_genre1));
        genreModels.add(new GenreModel("5","Drama",R.drawable.img_genre2));
        genreModels.add(new GenreModel("5","Lifestyle",R.drawable.img_genre3));
        genreModels.add(new GenreModel("5","Kids",R.drawable.img_genre16));
        genreModels.add(new GenreModel("5","Teen",R.drawable.img_genre4));
        genreModels.add(new GenreModel("5","Reality",R.drawable.img_genre5));
        genreModels.add(new GenreModel("5","Family",R.drawable.img_genre6));
        genreModels.add(new GenreModel("5","Comedy",R.drawable.img_genre7));
        genreModels.add(new GenreModel("5","Action",R.drawable.img_genre8));
        genreModels.add(new GenreModel("5","Thriller",R.drawable.img_genre9));
        genreModels.add(new GenreModel("5","Talk show",R.drawable.img_genre10));
        genreModels.add(new GenreModel("5","Awards",R.drawable.img_genre11));
        genreModels.add(new GenreModel("5","Science",R.drawable.img_genre12));
        genreModels.add(new GenreModel("5","Travel",R.drawable.img_genre13));
        genreModels.add(new GenreModel("5","Horror",R.drawable.img_genre14));
        genreModels.add(new GenreModel("5","Sports",R.drawable.img_genre15));
        genreModels.add(new GenreModel("5","animation",R.drawable.img_genre16));
        genreModels.add(new GenreModel("5","adventure",R.drawable.img_genre17));



        languageModels.add(new GenreModel("1","Hindi",R.drawable.movie3_3));
        languageModels.add(new GenreModel("2","English",R.drawable.english2_2));
        languageModels.add(new GenreModel("3","Bengali",R.drawable.bengali_movie1_1));
        languageModels.add(new GenreModel("4","Tamil",R.drawable.tamil1_1));


        genreAdaapter= new  GenreAdaapter(getActivity(),genreModels);
        recycler_genre.setAdapter(genreAdaapter);

        languageAdapter= new  GenreAdaapter(getActivity(),languageModels);
        recycler_language.setAdapter(languageAdapter);
    }

    private void initRecyclerView()
    {
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView rv_latest=view.findViewById(R.id.rv_latest);

        rv_latest.setLayoutManager(layoutManager);
        latestModels.add(new LatestModel("1","Bell Bottom","movie",R.drawable.movie1_1,R.drawable.movie1));
        latestModels.add(new LatestModel("1","The Empire","series",R.drawable.serie1_1,R.drawable.series1));
        latestModels.add(new LatestModel("1","The Family Man","series",R.drawable.series5_5,R.drawable.series5));
        latestModels.add(new LatestModel("1","Bhuj","movie",R.drawable.movie2_2,R.drawable.movie2));
        latestModels.add(new LatestModel("1","Prasthanam","movie",R.drawable.movie4_4,R.drawable.movie4));
        latestModels.add(new LatestModel("1","Criminal Justice","series",R.drawable.serie2_2,R.drawable.serie2));
        latestModels.add(new LatestModel("1","Bang Bang","movie",R.drawable.movie5,R.drawable.movie5_5));
        LatestAdapter adapter=new LatestAdapter(getActivity(),latestModels);

        rv_latest.setAdapter(adapter);


    }

    public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.ViewHolder> {


        private static final String TAG = "RecyclerViewAdapter";
        List<LatestModel> latestModels= new ArrayList<>();
        private Context mContext;

        public LatestAdapter(Context mContext,List<LatestModel> latestModels) {
            this.latestModels = latestModels;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public LatestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_page_one,viewGroup,false);

            return new LatestAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull LatestAdapter.ViewHolder viewHolder, int i) {
            Log.d(TAG, "onCreateViewHolder: called.");

            Glide.with(mContext)
                    .asBitmap()
                    .load(latestModels.get(i).getImg())
                    .into(viewHolder.image);

            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("type",latestModels.get(i).getType());
                    bundle.putString("name",latestModels.get(i).getName());
                    bundle.putInt("img",latestModels.get(i).getImg());
                    bundle.putInt("img2",latestModels.get(i).getImg2());
                    Intent intent=new Intent(getActivity(), SingleViewPage.class).putExtras(bundle);
                    getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return latestModels.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            ImageView image;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image=itemView.findViewById(R.id.img);
            }
        }

    }
    public class RecyclerViewAdapterNews extends RecyclerView.Adapter<RecyclerViewAdapterNews.ViewHolder> {


        private static final String TAG = "RecyclerViewAdapter";
        private List<LatestModel> top_movieModel=new ArrayList<>();
        private Context mContext;

        public RecyclerViewAdapterNews(Context mContext, List<LatestModel> top_movieModel) {
            this.top_movieModel = top_movieModel;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public  RecyclerViewAdapterNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_page,viewGroup,false);

            return new  RecyclerViewAdapterNews.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull  RecyclerViewAdapterNews.ViewHolder viewHolder, int i) {
            Log.d(TAG, "onCreateViewHolder: called.");

            Glide.with(mContext)
                    .asBitmap()
                    .load(top_movieModel.get(i).getImg2())
                    .into(viewHolder.image);
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("type",top_movieModel.get(i).getType());
                    bundle.putString("name",top_movieModel.get(i).getName());
                    bundle.putInt("img",top_movieModel.get(i).getImg());
                    bundle.putInt("img2",top_movieModel.get(i).getImg2());
                    Intent intent=new Intent(mContext, SingleViewPage.class).putExtras(bundle);
                    getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    mContext.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return top_movieModel.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            ImageView image;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                image=itemView.findViewById(R.id.img);
            }
        }

    }


    private void initRecyclerViewNews()
    {
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView=view.findViewById(R.id.rvtwo);

        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapterNews adapter=new RecyclerViewAdapterNews(getActivity(),top_movieModel);

        recyclerView.setAdapter(adapter);



  /*      recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                // Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(getActivity(), Single_Page.class);
//                startActivity(intent);
//                getActivity().finish();

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                //Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),Single_Page.class);
                startActivity(intent);
                getActivity().finish();
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {


                Intent intent=new Intent(getActivity(),Single_Page.class);
                startActivity(intent);
                getActivity().finish();
            }
        });*/


    }

    public class GenreAdaapter extends RecyclerView.Adapter<GenreAdaapter.ViewHolder> {

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
                    getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    getActivity().finish();

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

    private void initRecyclerViewPopular()
    {
        //Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView=view.findViewById(R.id.rvthree);

        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapterPopular adapter=new RecyclerViewAdapterPopular(getActivity(),allViewModels);

        recyclerView.setAdapter(adapter);

      /*  recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                //Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Single_Page.class);
                startActivity(intent);
                finish();

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                //Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Single_Page.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {


                Intent intent=new Intent(MainActivity.this,Single_Page.class);
                startActivity(intent);
                finish();
            }
        });*/


    }

    public class RecyclerViewAdapterPopular extends RecyclerView.Adapter<RecyclerViewAdapterPopular.ViewHolder> {


        private static final String TAG = "RecyclerViewAdapter";
        private List<AllViewModel> viewModels=new ArrayList<>();

        private Context mContext;

        public RecyclerViewAdapterPopular(Context mContext, List<AllViewModel> viewModels) {
            this.viewModels = viewModels;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public  RecyclerViewAdapterPopular.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_second_rv,viewGroup,false);

            return new  ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull  ViewHolder viewHolder, int i) {
            Log.d(TAG, "onCreateViewHolder: called.");
            viewHolder.txt.setText(viewModels.get(i).getName());
            viewHolder.rvthree.setHasFixedSize(true);


            viewHolder.arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle= new Bundle();
                    bundle.putString("name",viewModels.get(i).getName());
                    Intent intent=new Intent(getActivity(), ViewAll.class).putExtras(bundle);
                    getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                    startActivity(intent);
                }
            });
            LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);


            viewHolder.rvthree.setLayoutManager(layoutManager);

            RecyclerViewAdapterSubPopular adapter=new RecyclerViewAdapterSubPopular(getActivity(),viewModels.get(i).getLatestModels());

            viewHolder.rvthree.setAdapter(adapter);

        }

        @Override
        public int getItemCount() {
            return viewModels.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView txt;
            ImageView arrow;
            RecyclerView rvthree;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                txt=itemView.findViewById(R.id.txt);
                arrow=itemView.findViewById(R.id.arrow);
                rvthree=itemView.findViewById(R.id.rvthree);
            }
        }


        class RecyclerViewAdapterSubPopular extends RecyclerView.Adapter<RecyclerViewAdapterSubPopular.ViewHolder2> {


            private static final String TAG = "RecyclerViewAdapter";
            private  List<LatestModel> models=new ArrayList<>();
            private Context mContext;

            public RecyclerViewAdapterSubPopular(Context mContext, List<LatestModel> models) {
                this.models = models;
                this.mContext = mContext;
            }

            @NonNull
            @Override
            public RecyclerViewAdapterSubPopular.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_page_two,viewGroup,false);

                return new RecyclerViewAdapterSubPopular.ViewHolder2(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerViewAdapterSubPopular.ViewHolder2 viewHolder, int i) {
                Log.d(TAG, "onCreateViewHolder: called.");

                Glide.with(mContext)
                        .asBitmap()
                        .load(models.get(i).getImg())
                        .into(viewHolder.image);
                viewHolder.image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle= new Bundle();
                        bundle.putString("type",models.get(i).getType());
                        bundle.putString("name",models.get(i).getName());
                        bundle.putInt("img",models.get(i).getImg());
                        bundle.putInt("img2",models.get(i).getImg2());
                        Intent intent=new Intent(getActivity(), SingleViewPage.class).putExtras(bundle);
                        getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return models.size();
            }

            class ViewHolder2 extends RecyclerView.ViewHolder{

                ImageView image;

                public ViewHolder2(@NonNull View itemView) {
                    super(itemView);

                    image=itemView.findViewById(R.id.img);
                }
            }

        }

    }



}
