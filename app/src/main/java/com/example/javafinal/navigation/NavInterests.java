package com.example.javafinal.navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javafinal.R;
import com.example.javafinal.UserLoginBottom;

public class NavInterests extends Fragment {

    TextView userSortName;

    public NavInterests(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_interests, container, false);

        userSortName = view.findViewById(R.id.userSortName);

        userSortName.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), UserLoginBottom.class);
            startActivity(intent);
        });

        return view;
    }
}