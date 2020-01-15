package com.farhan.advotics.View.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.advotics.R;
import com.farhan.advotics.model.mCat;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rc;
    RecyclerAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = this.getActivity().getApplicationContext();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rc = root.findViewById(R.id.recycleer_view);
        homeViewModel.getText().observe(this, (ArrayList<mCat> catList) -> {
            adapter = new RecyclerAdapter(catList);
            rc.setLayoutManager(layoutManager);
            rc.setAdapter(adapter);
            rc.setHasFixedSize(true);
            rc.setNestedScrollingEnabled(false);
        });
        return root;
    }
}