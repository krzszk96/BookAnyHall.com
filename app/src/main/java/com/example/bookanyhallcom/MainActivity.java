package com.example.bookanyhallcom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int id;
    String hall;
    String city;
    String post;
    String output;

    EditText addUserID;
    EditText HallName;
    EditText CityName;
    EditText PostCode;
    TextView output_TextView;

    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUserID = (EditText) findViewById(R.id.addUserID);
        HallName = (EditText) findViewById(R.id.HallName);
        CityName = (EditText) findViewById(R.id.CityName);
        PostCode = (EditText) findViewById(R.id.PostCode);
        output_TextView = (TextView) findViewById(R.id.output_textView);

        addbtn = (Button) findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hall = HallName.getText().toString();
                city = CityName.getText().toString();
                post = PostCode.getText().toString();
                id = Integer.valueOf(addUserID.getText().toString());

                output = output_TextView.getText().toString();
            }
        });
    }

}
