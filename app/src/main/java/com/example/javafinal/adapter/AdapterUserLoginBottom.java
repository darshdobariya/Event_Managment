package com.example.javafinal.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.javafinal.navigation.stories.FragmentAll;
import com.example.javafinal.navigation.stories.FragmentCompany;
import com.example.javafinal.navigation.stories.FragmentMe;
import com.example.javafinal.navigation.stories.FragmentThanks;
import com.example.javafinal.navigation.usericon.FragmentContacts;
import com.example.javafinal.navigation.usericon.FragmentTeams;

public class AdapterUserLoginBottom extends FragmentPagerAdapter {

    public AdapterUserLoginBottom(
            @NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new FragmentContacts();
        else if (position == 1)
            fragment = new FragmentTeams();

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
            title = "Team";
        else if (position == 1)
            title = "Contacts";
        return title;
    }
}