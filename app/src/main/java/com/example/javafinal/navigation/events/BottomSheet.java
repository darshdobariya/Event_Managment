package com.example.javafinal.navigation.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javafinal.R;

public class BottomSheet extends AppCompatActivity {

    TextView tvTitle, btnDone;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        tvTitle = findViewById(R.id.tvTitle);
        btnDone = findViewById(R.id.tvDone);
        edtText = findViewById(R.id.edtText);

        tvTitle.setText(getIntent().getExtras().getString("Title"));

        btnDone.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.putExtra("Title", tvTitle.getText().toString());
            intent.putExtra("Text", edtText.getText().toString());
            setResult(RESULT_OK, intent);
            startActivity(intent);
            finish();
        });
    }
}