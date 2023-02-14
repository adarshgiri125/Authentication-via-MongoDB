package com.example.yuvaprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.bson.Document;

import java.util.Iterator;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.mongo.iterable.FindIterable;

public class chapter extends AppCompatActivity {

    MongoDatabase mongoDatabase;
    MongoClient mongoClient;
     TextView Callview;
     TextView Callview1;
    TextView Callview2;
    TextView Callview3;
    TextView Callview4;
    TextView Callview5;

     User user;
     String appid = "yuva-demo-tdngt";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        Callview = findViewById(R.id.callcontent);
        Callview1 = findViewById(R.id.callcontent1);
        Callview2 = findViewById(R.id.callcontent2);
        Callview3 = findViewById(R.id.callcontent3);
        Callview4 = findViewById(R.id.callcontent4);





        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(appid).build());
        user = app.currentUser();
        mongoClient = user.getMongoClient("mongodb-atlas");
        mongoDatabase = mongoClient.getDatabase("Courses");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("Content");



        // context 0 ->

        Document queryfilter = new Document().append("Co", "Machine Learning");
        mongoCollection.findOne(queryfilter).getAsync(result -> {
            if (result.isSuccess()){
                Toast.makeText(getApplicationContext(),"Database Reading Successfull",Toast.LENGTH_LONG).show();
                Log.d("messagecheck", "onCreate: succefull");
                Document Result= result.get();
                Callview.setText(Result.getString("Co"));

            }
            else{
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("data", "onCreate: succefull");
            }
        });

        //Context 1 ->

        Document queryfilter1 = new Document().append("Co1", "Artificial Intelligence");
        mongoCollection.findOne(queryfilter1).getAsync(result -> {
            if (result.isSuccess()){
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("messagecheck", "onCreate: succefull");
                Document Result1= result.get();
                Callview1.setText(Result1.getString("Co1"));

            }
            else{
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("data", "onCreate: succefull");
            }
        });

        // Context 2 ->
        Document queryfilter2 = new Document().append("Co2", "Android Development");
        mongoCollection.findOne(queryfilter2).getAsync(result -> {
            if (result.isSuccess()){
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("messagecheck", "onCreate: succefull");
                Document Result2= result.get();
                Callview2.setText(Result2.getString("Co2"));

            }
            else{
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("data", "onCreate: succefull");
            }
        });


        //Context 3 ->
        Document queryfilter3 = new Document().append("Co3", "Web Development");
        mongoCollection.findOne(queryfilter3).getAsync(result -> {
            if (result.isSuccess()){
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("messagecheck", "onCreate: succefull");
                Document Result3= result.get();
                Callview3.setText(Result3.getString("Co3"));

            }
            else{
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("data", "onCreate: succefull");
            }
        });


        //Context 4 ->
        Document queryfilter4 = new Document().append("Co4", "Data Science");
        mongoCollection.findOne(queryfilter4).getAsync(result -> {
            if (result.isSuccess()){
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("messagecheck", "onCreate: succefull");
                Document Result4= result.get();
                Callview4.setText(Result4.getString("Co4"));

            }
            else{
                Toast.makeText(getApplicationContext(),"found",Toast.LENGTH_SHORT);
                Log.d("data", "onCreate: succefull");
            }
        });



        // new page after clicking the view ->>>>

        Callview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chapter.this,Unit.class));
            }
        });

        Callview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chapter.this,Unit.class));
            }
        });
        Callview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chapter.this,Unit.class));
            }
        });

        Callview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chapter.this,Unit.class));
            }
        });

        Callview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chapter.this,Unit.class));
            }
        });


    }
}