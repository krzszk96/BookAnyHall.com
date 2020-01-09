package com.example.bookanyhallcom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddHall extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName, editStreet, editPost, editCity;
    Button btnadd;
    Button btnviewAll;
    Intent intent;

//    private static String value,value1, value2, value3;
//
//    public static String getValue() {
//        return value;
//    }
//    public static String getValue1() {
//        return value1;
//    }
//    public static String getValue2() {
//        return value2;
//    }
//    public static String getValue3() {
//        return value3;
//    }
//
//    @Override
//    protected void onCreate (Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_hall2);
//
//        backToMain1();
//
//        editName = findViewById(R.id.hname);
//        editStreet = findViewById(R.id.hstreet);
//        editPost = findViewById(R.id.hpost);
//        editCity = findViewById(R.id.hcity);
//
//        Button button = findViewById(R.id.addhallbtn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                value = editName.getText().toString().trim();
//                value1 = editStreet.getText().toString().trim();
//                value2 = editPost.getText().toString().trim();
//                value3 = editCity.getText().toString().trim();
//                Intent intent = new Intent(AddHall.this, Search.class);
//                startActivity(intent);
//            }
//
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hall2);

        backToMain1();

        myDB = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.hname);
        editStreet = (EditText)findViewById(R.id.hstreet);
        editPost = (EditText)findViewById(R.id.hpost);
        editCity = (EditText)findViewById(R.id.hcity);
        btnadd = (Button)findViewById(R.id.addhallbtn);
        btnviewAll = (Button)findViewById(R.id.viewallbtn);

        AddData();
        viewAll();
    }

      private void backToMain1(){
        Button backbtn = (Button) findViewById(R.id.backbtn1);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void AddData(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editName.getText().toString(),
                        editStreet.getText().toString(),
                        editPost.getText().toString(),
                        editCity.getText().toString());

                if(isInserted = true)
                    Toast.makeText(AddHall.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddHall.this, "Data not Inserted", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AddHall.this, Search.class);
                        startActivity(intent);
                        

                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
