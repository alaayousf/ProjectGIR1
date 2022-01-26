package com.alaaclips.projectgir1.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alaaclips.projectgir1.R;
import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Volting;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;



public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.VotingListViewHolde> {

    ArrayList<VotingList> mData;
    Activity activity;


    public SelectListAdapter(ArrayList<VotingList> mData, Activity activity) {
        this.mData = mData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VotingListViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(activity).inflate(R.layout.volting_item,parent,false);
        return new VotingListViewHolde(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull VotingListViewHolde holder, int position) {
        holder.name_list.setText(mData.get(position).getName());
        holder.carde_secterd_item.setOnClickListener(view -> {

            Toast.makeText(activity, "secte item ", Toast.LENGTH_SHORT).show();

            new AlertDialog.Builder(activity)
                    .setTitle("انتخاب")
                    .setMessage("ها انت متاكد من انك تريد انتخاب هادة القائمة")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        public void onClick(DialogInterface dialog, int which) {

                            SharedPreferences prefs =activity.getSharedPreferences("ALAA", activity.MODE_PRIVATE);
                            String emaileUser = prefs.getString("useremaile","no emaile");




                            DatabaseHelpers db = new DatabaseHelpers(activity);

                        Volting UserVoltinguseingemaile= db.getVoltingUser(emaileUser);

                      if(UserVoltinguseingemaile ==null){
                            Volting v = new Volting(emaileUser,mData.get(position).getName());
                            boolean vstate =  db.addVolting(v);

                            if (vstate){
                                Toast.makeText(activity,"تم التصويت بنجاح",Toast.LENGTH_SHORT).show();
                            }


                        }else{
                            Toast.makeText(activity,"لقد قمت بي التصويت من قبل",Toast.LENGTH_SHORT).show();

                        }




                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(R.drawable.ic_speaker)
                    .show();
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class VotingListViewHolde extends RecyclerView.ViewHolder{

        TextView name_list;
        ImageView image_list;
        CardView carde_secterd_item;


        public VotingListViewHolde(@NonNull View itemView) {
            super(itemView);

            name_list = itemView.findViewById(R.id.name_list);
            image_list = itemView.findViewById(R.id.image_list);
            carde_secterd_item = itemView.findViewById(R.id.carde_secterd_item);


        }
    }
}


