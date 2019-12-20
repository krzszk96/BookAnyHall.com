package com.example.bookanyhallcom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
                        Cursor res =  myDB.getAllData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("Error","Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Street :"+ res.getString(2)+"\n");
                            buffer.append("Post :"+ res.getString(3)+"\n");
                            buffer.append("City :"+ res.getString(4)+"\n");
                        }
                        //show all data
                        showMessage("Data", buffer.toString());
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
