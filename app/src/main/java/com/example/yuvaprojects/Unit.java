package com.example.yuvaprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class Unit extends AppCompatActivity {

//hello checking;



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
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 1) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 2) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 3) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 4) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 5) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 6) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 7) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 8) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 9) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }
                if(position == 10) {
                    Toast.makeText(getApplicationContext(),"Content will be uploaded soon",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}