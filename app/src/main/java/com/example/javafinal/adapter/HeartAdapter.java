package com.example.javafinal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.javafinal.navigation.events.FragmentPast;
import com.example.javafinal.navigation.events.FragmentRecorded;
import com.example.javafinal.navigation.events.FragmentScheduled;

public class HeartAdapter extends FragmentPagerAdapter {

    public HeartAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        if (position == 0)
//            fragment = new FragmentScheduled();
//        else if (position == 1)
//            fragment = new FragmentPast();
//        else if (position == 2)
//            fragment = new FragmentRecorded();
//
//        return fragment;

        Fragment fragment = null;
        if (position == 0)
            fragment = new FragmentScheduled();
        else if (position == 1)
            fragment = new FragmentPast();
        else if (position == 2)
            fragment = new FragmentRecorded();

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
            title = "Scheduled";
        else if (position == 1)
            title = "Past";
        else if (position == 2)
            title = "Recorded";
        return title;
    }
}