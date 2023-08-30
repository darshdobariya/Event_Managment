package com.example.javafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.javafinal.adapter.AdapterUserLoginBottom;
import com.example.javafinal.adapter.HeartAdapter;
import com.google.android.material.tabs.TabLayout;

public class UserLoginBottom extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterUserLoginBottom adapterUserLoginBottom;
    ImageView btnBackUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_bottom);

        viewPager = findViewById(R.id.eventviewPager);
        tabLayout = findViewById(R.id.showEventTab);
        btnBackUserLogin = findViewById(R.id.btnBackUserLogin);

        btnBackUserLogin.setOnClickListener(v->{
            finish();
        });

        adapterUserLoginBottom = new AdapterUserLoginBottom(getSupportFragmentManager());
        viewPager.setAdapter(adapterUserLoginBottom);

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager);
    }
}