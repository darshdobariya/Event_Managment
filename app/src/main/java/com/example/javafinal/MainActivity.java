package com.example.javafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.example.javafinal.navigation.NavEvents;
import com.example.javafinal.navigation.NavInterests;
import com.example.javafinal.navigation.NavMore;
import com.example.javafinal.navigation.NavStories;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    TextView line1, line2, line3, line4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNavigationView);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
        line4 = findViewById(R.id.line4);

        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            line1.setBackgroundColor(Color.rgb(222, 160, 55));
            bottomNav.setItemIconTintList(null);
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new NavEvents()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_events) {
                selectedFragment = new NavEvents();
                DeselectAllColor();
                bottomNav.setItemIconTintList(null);
                resetAllIcons();
                bottomNav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_heart_selected));
                line1.setBackgroundColor(Color.rgb(222, 160, 55));

            } else if (item.getItemId() == R.id.nav_stories) {
                selectedFragment = new NavStories();
                DeselectAllColor();
                resetAllIcons();
                bottomNav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_book_selected));
                bottomNav.setItemIconTintList(null);
                line2.setBackgroundColor(Color.rgb(204, 38, 40));

            } else if (item.getItemId() == R.id.nav_interests) {
                selectedFragment = new NavInterests();
                DeselectAllColor();
                resetAllIcons();
                bottomNav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_interest_selected));
                bottomNav.setItemIconTintList(null);
                line3.setBackgroundColor(Color.rgb(10, 78, 120));

            } else if (item.getItemId() == R.id.nav_more) {
                selectedFragment = new NavMore();
                DeselectAllColor();
                resetAllIcons();
                bottomNav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_more_unselected));
                bottomNav.setItemIconTintList(null);
                line4.setBackgroundColor(Color.rgb(51, 63, 79));
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, selectedFragment).commit();
            return true;
        }
    };

    private void DeselectAllColor() {
        line1.setBackgroundColor(Color.rgb(255, 255, 255));
        line2.setBackgroundColor(Color.rgb(255, 255, 255));
        line3.setBackgroundColor(Color.rgb(255, 255, 255));
        line4.setBackgroundColor(Color.rgb(255, 255, 255));
    }

    private void resetAllIcons() {
        bottomNav.getMenu().getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_heart_unselected));
        bottomNav.getMenu().getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_book_unselected));
        bottomNav.getMenu().getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_interest_unselected));
        bottomNav.getMenu().getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.nav_more_unselected));
    }
}