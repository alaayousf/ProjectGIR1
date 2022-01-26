package com.alaaclips.projectgir1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alaaclips.projectgir1.adapter.VotingListAdapter;
import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends AppCompatActivity {


//    Button btn_insart, btn_get;
//
//    RecyclerView recyclerView;
//    ArrayList<VotingList> s;
//    VotingListAdapter studentAdapter;


    protected boolean _active = true;
    protected int _splashTime = 1500;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        // Creates a button that mimics a crash when pressed
//        Button crashButton = new Button(this);
//        crashButton.setText("Test Crash");
//        crashButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                throw new RuntimeException("Test Crash"); // Force a crash
//            }
//        });
//
//        addContentView(crashButton, new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));



        Thread splashTread = new Thread() {
            @Override
            public void run() {


                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(200);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                } finally {
                    startActivity(new Intent(getApplicationContext(), SignupActivity.class));
                    finish();
                }
            }

            ;
        };
        splashTread.start();

    }
}