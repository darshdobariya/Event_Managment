package com.example.javafinal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.javafinal.navigation.events.FragmentPast;
import com.example.javafinal.navigation.events.FragmentRecorded;
import com.example.javafinal.navigation.events.FragmentScheduled;
import com.example.javafinal.navigation.stories.FragmentAll;
import com.example.javafinal.navigation.stories.FragmentCompany;
import com.example.javafinal.navigation.stories.FragmentMe;
import com.example.javafinal.navigation.stories.FragmentThanks;

public class StoriesAdapter extends FragmentPagerAdapter {

    public StoriesAdapter(
            @NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new FragmentAll();
        else if (position == 1)
            fragment = new FragmentCompany();
        else if (position == 2)
            fragment = new FragmentMe();
        else if (position == 3)
            fragment = new FragmentThanks();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "All";
        else if (position == 1)
            title = "Company";
        else if (position == 2)
            title = "Me";
        else if (position == 3)
            title = "Thanks";
        return title;
    }
}