package com.example.bookanyhallcom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    DatabaseHelper myDB;
    ListView listView;
    //TextView receive,receive1,receive2,receive3;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//        receive = findViewById(R.id.tn);
//        receive.setText(AddHall.getValue());
//        receive1 = findViewById(R.id.ts);
//        receive1.setText(AddHall.getValue1());
//        receive2 = findViewById(R.id.tp);
//        receive2.setText(AddHall.getValue2());
//        receive3 = findViewById(R.id.tc);
//        receive3.setText(AddHall.getValue3());

        /*@Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);*/

        ListView listView = (ListView) findViewById(R.id.ListView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getAllData();

        if(data.getCount() == 0){
            Toast.makeText(Search.this, "Database empty", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(0));
                theList.add(data.getString(1));
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                theList.add(data.getString(4));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }

        backToMain2();
    }

    private void backToMain2(){
        Button backbtn2 = (Button) findViewById(R.id.backbtn2);
        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
