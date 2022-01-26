package com.alaaclips.projectgir1.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alaaclips.projectgir1.R;
import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Volting;

import java.util.ArrayList;
import java.util.Collection;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;


    TextView numperofVolting,numF,numH,numJ;

    ArrayList<Volting> usersArrayList;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);



        DatabaseHelpers db = new DatabaseHelpers(getActivity());
        usersArrayList = db.getALLVoltingUser();




        numperofVolting = root.findViewById(R.id.numperofVolting);
        numF = root.findViewById(R.id.numF);
        numH = root.findViewById(R.id.numH);
        numJ = root.findViewById(R.id.numJ);

        numperofVolting.setText(usersArrayList.size()+"");
        numF.setText(getlistarray("فتح",usersArrayList).size()+"");
        numH.setText(getlistarray("حماس",usersArrayList).size()+"");
        numJ.setText(getlistarray("الجهاد",usersArrayList).size()+"");



        return root;
    }




    public ArrayList<Volting> getlistarray( String name,ArrayList<Volting> customers) {

        ArrayList<Volting> usersArrayList = new ArrayList<>();

        for (Volting customer : customers) {
            if (customer.getNamelapel().equals(name)) {
                usersArrayList.add(customer);
            }
        }

        return usersArrayList;
    }


}