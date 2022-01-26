package com.alaaclips.projectgir1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alaaclips.projectgir1.R;
import com.alaaclips.projectgir1.adapter.VotingListAdapter;
import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView recy_allList;
    private ArrayList<VotingList> s;
    private VotingListAdapter studentAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        DatabaseHelpers db = new DatabaseHelpers(getActivity());



        View root = inflater.inflate(R.layout.fragment_home, container, false);


          recy_allList = root.findViewById(R.id.recy_allList);
//
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView btn_1 = root.findViewById(R.id.button_test);

//        btn_1.setOnClickListener(view -> {
//            Toast.makeText(getActivity(),"Hollw worde",Toast.LENGTH_SHORT).show();
//        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });


        recy_allList.setLayoutManager(new LinearLayoutManager(getActivity()));

        recy_allList.setHasFixedSize(true);

        s= db.getAllNotes();

        studentAdapter = new VotingListAdapter(s,getActivity());

        recy_allList.setAdapter(studentAdapter);



        return root;
    }
}
