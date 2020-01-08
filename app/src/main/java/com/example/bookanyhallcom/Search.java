package com.example.bookanyhallcom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    TextView receive,receive1,receive2,receive3;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView receive = findViewById(R.id.tn);
        receive.setText(AddHall.getValue());
        /*TextView receive1 = findViewById(R.id.ts);
        receive1.setText(AddHall.getValue());
        TextView receive2 = findViewById(R.id.tp);
        receive2.setText(AddHall.getValue());
        TextView receive3 = findViewById(R.id.tc);
        receive3.setText(AddHall.getValue());*/

        /*@Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);*/

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
