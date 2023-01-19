package com.example.yuvaprojects;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuvaprojects.Loginscreen;
import com.example.yuvaprojects.R;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;


public class Registeruser extends AppCompatActivity {

    String appid = "yuva-demo-tdngt";


    EditText edname, edemail, edpassword, edconfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        Realm.init(this);
        App app = new App(new AppConfiguration.Builder(appid).build());

        edname = findViewById(R.id.editTextRegName);
        edemail = findViewById(R.id.editTextRegEmail);
        edpassword = findViewById(R.id.editTextRegPasswords);
        edconfirm = findViewById(R.id.editTextRegPasswords2);
        btn = findViewById(R.id.button2);
        tv = findViewById(R.id.textRegNewUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Registeruser.this, Loginscreen.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edname.getText().toString();
                String password = edpassword.getText().toString();
                String email = edemail.getText().toString();
                String confirm = edconfirm.getText().toString();
                if(email.length() == 0 || password.length() == 0 || confirm.length()==0) {
                    Toast.makeText(getApplicationContext(),"Fill all Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                     if(isvalid(password)){
                         app.getEmailPassword().registerUserAsync(email,password,it->{
                             if(it.isSuccess()){

                                 Toast.makeText(getApplicationContext(),"Registered successful",Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(Registeruser.this,Loginscreen.class));

                             }else{

                                 Toast.makeText(getApplicationContext(),"An error occured- Try again",Toast.LENGTH_SHORT).show();
                             }
                         });




                     }else {
                         Toast.makeText(getApplicationContext(),"Password length not suitable",Toast.LENGTH_SHORT).show();

                     }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password Didn't Matched",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
    public static boolean isvalid(String passwordhere){
        int f1=0,f2=0, f3=0;
        if(passwordhere.length()<6){
            return false;

        }
        else{
            for(int i=0; i<passwordhere.length(); i++){
                if(Character.isLetter(passwordhere.charAt(i))){
                    f1=1;
                }
            }
            for(int j=0; j<passwordhere.length(); j++){
                if(Character.isDigit(passwordhere.charAt(j))){
                    f2=1;
                }
            }
            for(int k=0; k<passwordhere.length(); k++){
                char c = passwordhere.charAt(k);
                    if(k>=33&&c<=46||c==64){
                        f3=1;
                }
            }


        }
        if(f1==1 && f2==1 & f3==1){
            return true;
        }
        return false;

    }


}