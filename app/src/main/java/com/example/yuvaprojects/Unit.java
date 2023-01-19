package com.example.yuvaprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Unit extends AppCompatActivity {
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
         listView = findViewById(R.id.Unitview);

        List<String> list = new ArrayList<>();
        list.add("Unit - 1");
        list.add("Unit - 2");
        list.add("Unit - 3");
        list.add("Unit - 4");
        list.add("Unit - 5");
        list.add("Unit - 6");
        list.add("Unit - 7");
        list.add("Unit - 8");
        list.add("Unit - 9");
        list.add("Unit - 10");



        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 1) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 2) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 3) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 4) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 5) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 6) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 7) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 8) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 9) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }
                if(position == 10) {
                    startActivity(new Intent(Unit.this, chapter.class));
                }

            }
        });

    }
}