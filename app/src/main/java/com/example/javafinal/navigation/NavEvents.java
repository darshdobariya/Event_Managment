package com.example.javafinal.navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javafinal.R;
import com.example.javafinal.UserLoginBottom;
import com.example.javafinal.adapter.HeartAdapter;
import com.example.javafinal.adapter.StoriesAdapter;
import com.example.javafinal.navigation.events.FragmentScheduled;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class NavEvents extends Fragment {
    //implements View.OnClickListener
    TabLayout tabLayout;
    ViewPager viewPager;
    HeartAdapter heartAdapter;
    TextView userSortName;

    public NavEvents() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_events, container, false);

        viewPager = view.findViewById(R.id.eventviewPager);
        tabLayout = view.findViewById(R.id.eventtab);
        userSortName = view.findViewById(R.id.userSortName);

        userSortName.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), UserLoginBottom.class);
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        heartAdapter = new HeartAdapter(getChildFragmentManager());
        viewPager.setAdapter(heartAdapter);

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager);
    }
}
