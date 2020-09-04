package com.example.ztest1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class Choice extends AppCompatActivity  {
    private Button rg,dp,so;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        auth= FirebaseAuth.getInstance();
        rg=findViewById(R.id.buttonREG);
        dp=findViewById(R.id.buttonShow);
        so=findViewById(R.id.signout);

        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==rg){
                    startActivity(new Intent(getApplicationContext(),IndGrp.class));
                }
            }
        });

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==dp){
                    startActivity(new Intent(getApplicationContext(),Retrieve.class));
                }
            }
        });

        so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==so){
                    auth.signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        });
    }
}
