package com.alaaclips.projectgir1.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alaaclips.projectgir1.R;
import com.alaaclips.projectgir1.adapter.AddmopNewsAdaptre;
import com.alaaclips.projectgir1.model.AddModnews;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private RecyclerView recy_allList;
    private ArrayList<AddModnews> s;
    private AddmopNewsAdaptre adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        s=new ArrayList<>();

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        s.add(new AddModnews(
                "https://img-prod-cms-rt-microsoft-com.akamaized.net/cms/api/am/imageFileData/RE4wwtq?ver=b3fb",
                " رغم ما تمر به قضيتنا أعدل قضية على الأرض، رغم كل المؤامرات والصفقات المشبوهة، والساقطين في بئر التطبيع مع الكيان المجرم، وإن كانوا عربًا ..."));

        recy_allList = root.findViewById(R.id.recy_add_and_news);

        recy_allList.setLayoutManager(new LinearLayoutManager(getActivity()));
        recy_allList.setHasFixedSize(true);

        adapter = new AddmopNewsAdaptre(s,getActivity());
        recy_allList.setAdapter(adapter);




      //  final TextView textView = root.findViewById(R.id.text_notifications);



        return root;
    }
}