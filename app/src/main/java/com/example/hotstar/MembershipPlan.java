package com.example.hotstar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.hotstar.Model.MembershipPlanModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MembershipPlan extends AppCompatActivity {

    RecyclerView recycler_plans;
    List<MembershipPlanModel> planModels=new ArrayList<>();
    PlanAdapter planAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_plan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_plans = findViewById(R.id.recycler_plans);
        recycler_plans.setHasFixedSize(true);
        recycler_plans.setLayoutManager(new LinearLayoutManager(MembershipPlan.this,LinearLayoutManager.HORIZONTAL,false));

        planModels.add(new MembershipPlanModel(
                "1",
                "Basic",
                "Ad free 1 Month",
                "199"
        ));
        planModels.add(new MembershipPlanModel(
                "1",
                "Standard",
                "Ad free 3 Month",
                "299"
        ));
        planModels.add(new MembershipPlanModel(
                "1",
                "Premium",
                "Ad free 1 Year",
                "999"
        ));

        planAdapter = new PlanAdapter(MembershipPlan.this,planModels);
        recycler_plans.setAdapter(planAdapter);
    }

    public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

        Context context;
        List<MembershipPlanModel> planModel;
        int selected_position = 0;
        public PlanAdapter(Context context, List<MembershipPlanModel> planModel) {
            this.context = context;
            this.planModel = planModel;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.custom_membership, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            holder.bind(planModel.get(position));

            /*if (!plan_id.equals("")){
                if (plan_id.equals(planModel.get(position).getId())){
                    holder.radio.setVisibility(View.VISIBLE);
                }else {
                    holder.radio.setVisibility(View.INVISIBLE);
                }
            }*/

            /*holder.select_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage(" Are you sure to buy this plan ?")
                            .setTitle("")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (user_id.equals("")){
                                        startActivity(new Intent(MembershipPlans.this,LoginActivity.class));
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                    }else {
                                        if (membership_status.equals("Y")){
                                            dialog.dismiss();
                                            Toast.makeText(context, "You are already a club member", Toast.LENGTH_SHORT).show();
                                        }else {
                                            dialog.dismiss();
                                            buy_plan(planModel.get(position).getId(),planModel.get(position).getValidity());
                                        }
                                    }
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    AlertDialog alert = builder.create();

                    alert.show();
                }
            });*/


        }

        @Override
        public int getItemCount() {
            return planModel.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView amount,type,validity;
            //RadioButton radio;
            //Button select_btn;
            LinearLayout lin;
            ImageView checked_btn;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                amount=itemView.findViewById(R.id.amount);
                type=itemView.findViewById(R.id.type);
                lin=itemView.findViewById(R.id.lin);
                checked_btn=itemView.findViewById(R.id.checked_btn);
                validity=itemView.findViewById(R.id.validity);


            }

            public void bind(MembershipPlanModel membershipPlanModel) {
                 type.setText(membershipPlanModel.getName());
                 amount.setText(membershipPlanModel.getAmount());
                validity.setText(membershipPlanModel.getValidity());
                if (selected_position == -1) {
                     lin.setBackgroundResource(R.drawable.box);
                    checked_btn.setVisibility(View.GONE);
                } else {
                    if (selected_position == getAdapterPosition()) {
                        lin.setBackgroundResource(R.drawable.box2);
                        checked_btn.setVisibility(View.VISIBLE);

                    } else {
                        lin.setBackgroundResource(R.drawable.box);
                        checked_btn.setVisibility(View.GONE);
                    }
                }

                lin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lin.setBackgroundResource(R.drawable.box2);
                        checked_btn.setVisibility(View.VISIBLE);
                        if (selected_position != getAdapterPosition()) {
                            notifyItemChanged(selected_position);
                            selected_position = getAdapterPosition();
                        }


                    }
                });
            }
        }
    }

  /*  private void buy_plan(final String id, final String validity) {
        Call<String> call=myInterface.buy_plan(id,user_id,validity);
        ProgressUtils.showLoadingDialog(MembershipPlans.this);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body()!=null){
                    String res=response.body();
                    try {
                        JSONObject object= new JSONObject(res);
                        if (object.getString("rec").trim().equals("1")){
                            ProgressUtils.cancelLoading();
                            user.setMembership_status("Y");
                            user.setMembership_date(object.getString("due_date"));
                            user.setPlan_id(id);
                            user.setMembership_validity(validity);
                            startActivity(new Intent(MembershipPlans.this,MembershipPlans.class));
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                        }else {
                            Toast.makeText(MembershipPlans.this, "Some error occured.", Toast.LENGTH_SHORT).show();
                            ProgressUtils.cancelLoading();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        ProgressUtils.cancelLoading();
                    }
                }else{
                    ProgressUtils.cancelLoading();
                    Toast.makeText(MembershipPlans.this, "No Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                ProgressUtils.cancelLoading();
                Toast.makeText(MembershipPlans.this, "Slow network connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            startActivity(new Intent(MembershipPlan.this, MainActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        startActivity(new Intent(MembershipPlan.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();

    }



}