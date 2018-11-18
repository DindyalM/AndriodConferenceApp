package com.example.dindyal_mursingh_assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtname = (TextView) findViewById(R.id.textViewName);
        button = (Button) findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("key", 0);
                SharedPreferences.Editor sedt = sp.edit();
                sedt.putString("textvalue", txtname.getText().toString());
                sedt.apply();

                openActivity2();
            }
        });


    }
    public void openActivity2(){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
}

