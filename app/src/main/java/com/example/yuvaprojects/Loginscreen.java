package com.example.yuvaprojects;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;


public class Loginscreen extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    TextView tv;
    String appid = "yuva-demo-tdngt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(appid).build());



        edUsername = findViewById(R.id.editTextUsername);
        edPassword = findViewById(R.id.editTextPasswords);
        btn = findViewById(R.id.button2);
        tv = findViewById(R.id.textNewUser);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick  (View v) {
                String Usernames = edUsername.getText().toString();
                String Passwords = edPassword.getText().toString();
                Credentials credentials = Credentials.emailPassword(Usernames,Passwords);
                if(Usernames.length() == 0 || Passwords.length() == 0) {

                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Loginscreen.this,Loginscreen.class));
                }
//                else {
//                    Toast.makeText(getApplicationContext(),"Login Succesful",Toast.LENGTH_SHORT).show();
//                }


                app.loginAsync(credentials, new App.Callback<User>() {
                    @Override

                    public void onResult(App.Result<User> result) {
                        String email = edUsername.getText().toString();
                        if(result.isSuccess()){
                            Toast.makeText(getApplicationContext(),"Login Succesfull",Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(Loginscreen.this,Landingpage.class));
//                            app.getEmailPassword().sendResetPasswordEmailAsync(String.valueOf(email),result1 -> {
//                                if(result.isSuccess()){
//                                    Toast.makeText(getApplicationContext(),"Login succesful",Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(Loginscreen.this,Homescreen.class));
//                                }
//                                else{
//                                    Toast.makeText(getApplicationContext(),"Verify you Email Address",Toast.LENGTH_SHORT).show();}
//                            });




                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong Password or Email",Toast.LENGTH_SHORT).show();
                        }
                    }



                });




            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Loginscreen.this,Registeruser.class));
            }
        });

    }

}





