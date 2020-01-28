package com.example.bookanyhallcom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manageAccount();
        addHall();
        showMap();
        search();
        settings();
    }
    private void manageAccount(){
        ImageView btnacc = (ImageView) findViewById(R.id.btnacc);
        btnacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Account.class));
            }
        });
    }
    private void addHall(){
        ImageView btnadd = (ImageView) findViewById(R.id.btnaddHall);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddHall.class));
            }
        });
    }
    private void showMap(){
        ImageView btnmap = (ImageView) findViewById(R.id.btnmap);
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
    }
    private void search(){
        ImageView btns = (ImageView) findViewById(R.id.btnsearch);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Search.class));
            }
        });
    }
    private void settings(){
        ImageView btnsett = (ImageView) findViewById(R.id.btnsett);
        btnsett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });
    }

}
