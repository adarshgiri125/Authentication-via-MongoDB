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

public class Courses extends AppCompatActivity {

    ListView listView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

       listView = findViewById(R.id.listCources);



        List<String> list = new ArrayList<>();
        list.add("SEMESTER - 1");
        list.add("SEMESTER - 2");
        list.add("SEMESTER - 3");
        list.add("SEMESTER - 4");
        list.add("SEMESTER - 5");
        list.add("SEMESTER - 6");
        list.add("SEMESTER - 7");
        list.add("SEMESTER - 8");
        list.add("OVERVIEW");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==1){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==2){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==3){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==4){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==5){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==6){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==7){
                    startActivity(new Intent(Courses.this,chapter.class));

                }
                if(position==8){
                    startActivity(new Intent(Courses.this,chapter.class));

                }



            }
        });
    }
}