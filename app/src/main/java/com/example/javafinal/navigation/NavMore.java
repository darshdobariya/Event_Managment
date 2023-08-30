package com.example.javafinal.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javafinal.R;
public class NavMore extends Fragment {
    public NavMore() {
        // Required empty public constructor
    }

    TextView btnLogOut;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_more, container, false);

        btnLogOut = view.findViewById(R.id.tvLogOut);

        btnLogOut.setOnClickListener(v->{
            // logout
        });

        return view;
    }
}