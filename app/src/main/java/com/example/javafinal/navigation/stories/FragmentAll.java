package com.example.javafinal.navigation.stories;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.javafinal.R;
public class FragmentAll extends Fragment {

    ImageView btnNewStory;

    public FragmentAll() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);

        btnNewStory = view.findViewById(R.id.btnNewStory);
        btnNewStory.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), NewStory.class);
            startActivity(intent);
        });

        return view;
    }
}