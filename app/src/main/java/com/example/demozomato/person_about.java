package com.example.demozomato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class person_about extends AppCompatActivity {
    AppCompatButton btnContinue;
    EditText edtName, edtNumber,edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_about);

        btnContinue=findViewById(R.id.btnContinue);
        edtName=findViewById(R.id.edtName);
        edtNumber=findViewById(R.id.edtNumber);
        edtAddress=findViewById(R.id.edtAddress);

        String Name= edtName.getText().toString();
        edtName.setText(Name);











            btnContinue.setOnClickListener(new View.OnClickListener() {

                Intent intent=new Intent();


                @Override
                public void onClick(View v) {

                    String name= edtName.getText().toString();
                    String number= edtNumber.getText().toString();
                    String address= edtAddress.getText().toString();

                    if (!name.equals("")&& !number.equals("")&& !address.equals("")){


                        intent.putExtra("name", name);
                        intent.putExtra("no",number);
                        intent.putExtra("add",address);
                        setResult(RESULT_OK, intent);


                        finish();
                    }



                }
            });

    }
}