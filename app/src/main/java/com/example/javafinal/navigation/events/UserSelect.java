package com.example.javafinal.navigation.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.javafinal.R;

import java.util.ArrayList;

public class UserSelect extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter adapter;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);

        tvTitle = findViewById(R.id.tvTitle);

        tvTitle.setText(getIntent().getExtras().getString("Title"));

        arrayList=new ArrayList();
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("name");

        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}