package com.example.hotstar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.hotstar.EditProfile;
import com.example.hotstar.MembershipPlan;
import com.example.hotstar.MyAdapter;
import com.example.hotstar.R;
import com.example.hotstar.RecyclerViewAdapter;
import com.example.hotstar.RecyclerViewAdapterNews;
import com.example.hotstar.Single_Page;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ProfileFragment extends Fragment {
    private View view;
    Button membership_btn;
    Button edit;


    public ProfileFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        membership_btn=view.findViewById(R.id.membership_btn);
        edit=view.findViewById(R.id.edit);
        membership_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MembershipPlan.class));
                getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                getActivity().finish();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfile.class));
                getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                getActivity().finish();
            }
        });

        return view;
    }

}
