package com.example.javafinal.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javafinal.R;
import com.example.javafinal.adapter.HeartAdapter;
import com.example.javafinal.adapter.StoriesAdapter;
import com.google.android.material.tabs.TabLayout;

public class NavStories extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    StoriesAdapter storiesAdapter;
    public NavStories(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_stories, container, false);

        viewPager = view.findViewById(R.id.StoryviewPager);
        tabLayout = view.findViewById(R.id.Storytab);

        storiesAdapter = new StoriesAdapter(
                getChildFragmentManager());
        viewPager.setAdapter(storiesAdapter);

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}