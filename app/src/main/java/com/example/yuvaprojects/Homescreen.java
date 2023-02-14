package com.example.yuvaprojects;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.mongo.iterable.FindIterable;
import io.realm.mongodb.mongo.iterable.MongoCursor;
import io.realm.mongodb.mongo.options.InsertManyResult;


public class Homescreen extends AppCompatActivity {

    Realm uiThreadRealm;
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection<Document> mongoCollection;
    User user;
    App app;
    String AppId = "yuva-demo-tdngt";
    Button upload;
    EditText Sendingtext;
    Button find;
    TextView finddetails;
    Button logout;
    Button skip;
    TextView collegename;
    EditText Age;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Realm.init(this);
        app = new App(new AppConfiguration.Builder(AppId).build());

        logout = findViewById(R.id.buttonLogout);
        find = findViewById(R.id.buttonfind);
        finddetails = findViewById(R.id.textViewfind);
        Sendingtext = findViewById(R.id.editTextDetails);
        upload = findViewById(R.id.buttonupload);
        skip = findViewById(R.id.buttoncontinue);
        collegename = findViewById(R.id.editTextTextPersonName);
        Age = findViewById(R.id.editTextAge);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = app.currentUser();
                mongoClient = user.getMongoClient("mongodb-atlas");
                mongoDatabase = mongoClient.getDatabase("CourseData");
                mongoCollection = mongoDatabase.getCollection("Test");



              //  asList is replaced by singletonlist -->
                List<Document> UserData = Collections.singletonList(
                        new Document("User", Sendingtext.getText().toString()).append("Name", Sendingtext.getText().toString())
                                .append("College", collegename.getText().toString())
                                .append("Age", Age.getText().toString()));

                mongoCollection.insertMany(UserData).getAsync(result -> {
                      if (result.isSuccess()) {
                        Toast.makeText(getApplicationContext(),"Data send to Databse",Toast.LENGTH_SHORT).show();
                    } else {
                        Log.v("Data", "Sending Failed");
                    }
                });


            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Document queryfilter = new Document().append("User", Sendingtext.getText().toString());
                mongoCollection.findOne(queryfilter).getAsync(result -> {
                    if (result.isSuccess()) {
                        Toast.makeText(getApplicationContext(), "showing data from Databse", Toast.LENGTH_SHORT).show();
                        Log.d("finding check", "onClick: here");
                        Document Resultdata = result.get();
                        finddetails.setText(Resultdata.getString("User"));
                    } else {
                        Toast.makeText(getApplicationContext(), "Data not availbale", Toast.LENGTH_SHORT).show();
                    }

                });







            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.currentUser().logOutAsync(result -> {
                    if(result.isSuccess()) {
                        Toast.makeText(getApplicationContext(), "Log out Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Homescreen.this,Loginscreen.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("checkcource", "onClick: clicked");
                startActivity(new Intent(Homescreen.this,Courses.class));
                Log.d("checkcource", "onClick: entered");
            }
        });



    }



    }


       //---> inserting a single document ---->//
//                mongoCollection.insertOne(new Document("user id", user.getId()).append("User-Name", Sendingtext.getText().toString())).getAsync(result -> {
//                    if (result.isSuccess()) {
//                        Toast.makeText(getApplicationContext(),"Data send to Databse",Toast.LENGTH_SHORT).show();
//                    } else {
//                        Log.v("Data", "Sending Failed");
//                    }
//                });
//                mongoCollection.insertOne(new Document("user id", user.getId()).append("College-name", collegename.getText().toString())).getAsync(result -> {
//                    if (result.isSuccess()) {
//
//                    } else {
//                        Log.v("Data", "");
//                    }
//                });
//                mongoCollection.insertOne(new Document("user id", user.getId()).append("User-Age", Age.getText().toString())).getAsync(result -> {
//                    if (result.isSuccess()) {
//
//                    } else {
//                        Log.v("Data", "");
//                    }
//                });



