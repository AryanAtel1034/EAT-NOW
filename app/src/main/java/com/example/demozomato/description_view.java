package com.example.demozomato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class description_view extends AppCompatActivity {
    TextView txtDescriptionHeading,txtAmount,txtPrice;
    ImageView imgDescriptionImage;
    RecyclerView recyclerSelect;

    Button btnAdd,btnMinus, btnCart;
    int itemCount=1;
    int total=0;
    int price=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_view);

        txtDescriptionHeading=findViewById(R.id.txtDescriptionHeading);
        imgDescriptionImage=findViewById(R.id.imgDescriptionImage);
        btnAdd= findViewById(R.id.btnAdd);
        txtAmount=findViewById(R.id.txtAmount);
        btnMinus=findViewById(R.id.btnMinus);
        txtPrice=findViewById(R.id.txtPrice);
        btnCart=findViewById(R.id.btnCart);


        String heading= getIntent().getStringExtra("heading");
        txtDescriptionHeading.setText(heading);
       int image = getIntent().getIntExtra("img",1);
       imgDescriptionImage.setImageResource(image);
        price= getIntent().getIntExtra("price",0);
       txtPrice.setText(Integer.toString(price));

       total=price;
       btnAdd.setOnClickListener(new View.OnClickListener() {


           @Override
           public void onClick(View v) {

               itemCount=itemCount+1;

               txtAmount.setText(Integer.toString(itemCount));

                   total=total+price;

               txtPrice.setText(Integer.toString(total));



           }
       });

       btnMinus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (itemCount>1){

                   itemCount=itemCount-1;


                   txtAmount.setText(Integer.toString(itemCount));
                   total=total-price;

                   txtPrice.setText(Integer.toString(total));

               }
           }
       });

        ;

       btnCart.setOnClickListener(new View.OnClickListener() {

           Intent intent= new Intent(description_view.this, billing_View.class);

           @Override
           public void onClick(View v) {

               String countString=  txtAmount.getText().toString();
               int count = Integer.parseInt(countString);
               String dishName= txtDescriptionHeading.getText().toString();
//               String priceString= txtPrice.getText().toString();
//               int pricee= Integer.parseInt(priceString);


               intent.putExtra("heading",dishName);
               intent.putExtra("count",count);
               intent.putExtra("pricee",price);
               intent.putExtra("total",total);

               startActivity(intent);

           }
       });


    }
}