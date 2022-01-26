package com.alaaclips.projectgir1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alaaclips.projectgir1.adapter.SelectListAdapter;
import com.alaaclips.projectgir1.adapter.VotingListAdapter;
import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;

public class VoteActivity extends AppCompatActivity {

    RecyclerView recyclerViewselecteditem;
    ArrayList<VotingList> s;
    SelectListAdapter selectListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);


        recyclerViewselecteditem = findViewById(R.id.recy_selcteItem);
        DatabaseHelpers db = new DatabaseHelpers(this);
        s = new ArrayList<>();





        recyclerViewselecteditem.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewselecteditem.setHasFixedSize(true);

        s = db.getAllNotes();

        selectListAdapter = new SelectListAdapter(s, this);
        recyclerViewselecteditem.setAdapter(selectListAdapter);

    }
}