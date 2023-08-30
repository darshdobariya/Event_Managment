package com.example.javafinal.navigation.stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javafinal.R;
import com.example.javafinal.navigation.events.BottomSheet;

public class NewStory extends AppCompatActivity {

    ImageView btnTitle, btnDetails, btnBackStory;
    TextView tvTitle, tvDetails;
    SwitchCompat switchPrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_story);

        btnTitle = findViewById(R.id.ivTitle);
        btnDetails = findViewById(R.id.ivDetail);
        switchPrivate = findViewById(R.id.switchPrivate);
        tvDetails = findViewById(R.id.tvDetails);
        tvTitle = findViewById(R.id.tvTitles);
        btnBackStory = findViewById(R.id.btnBackStory);

        btnTitle.setOnClickListener(v->{
            Intent intent = new Intent(this, BottomSheet.class);
            intent.putExtra("Title", "Title");
            startActivity(intent);
        });

        btnDetails.setOnClickListener(v->{
            Intent intent = new Intent(this, BottomSheet.class);
            intent.putExtra("Title", "Details");
            startActivity(intent);
        });

        btnBackStory.setOnClickListener(v->{
            finish();
        });
    }
}