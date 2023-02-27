package com.example.demozomato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategories , recyclerPopular;
    TextView txtSeeAll,txtDscriptionHeading,txtPopularName;

    Button btnForDescription;
    ArrayList<recycler_content_struct>categoriesInfo=new ArrayList<>();
    ArrayList<recycler_content_struct_popular>popularsInfo=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerCategories= findViewById(R.id.recyclerCategories);
        recyclerPopular=findViewById(R.id.recyclerPopular);
        txtSeeAll=findViewById(R.id.txtSeeAll);
        btnForDescription=findViewById(R.id.btnForDescription);


        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        categoriesInfo.add(new recycler_content_struct(R.drawable.pizza,"Pizza"));
        categoriesInfo.add(new recycler_content_struct(R.drawable.burger,"Burger"));
        categoriesInfo.add(new recycler_content_struct(R.drawable.chicken,"Chicken"));
        categoriesInfo.add(new recycler_content_struct(R.drawable.curry,"Curry"));
        categoriesInfo.add(new recycler_content_struct(R.drawable.drink,"Drink"));
        categoriesInfo.add(new recycler_content_struct(R.drawable.cake,"cream"));


       popularsInfo.add(new recycler_content_struct_popular(R.drawable.butterchicken,950, "ButterChicken"));
        popularsInfo.add(new recycler_content_struct_popular(R.drawable.biryani,400, "Biryani"));
        popularsInfo.add(new recycler_content_struct_popular(R.drawable.south,250, "Thali"));
        popularsInfo.add(new recycler_content_struct_popular(R.drawable.burgerr,180, "McSpicy Chicken Burger"));
       popularsInfo.add(new recycler_content_struct_popular(R.drawable.pizzaa,99, "Tomato Pizza"));


        recyclerAdapter adapter=new recyclerAdapter(this , categoriesInfo);
        recycler_popular_adapter adapter1=new recycler_popular_adapter(this, popularsInfo);

        recyclerPopular.setAdapter(adapter1);

        recyclerCategories.setAdapter(adapter);

    }


    public void seeAll(View view) {

        Intent intent;
        intent=new Intent(MainActivity.this, hotels_list_page.class);

        int currBtn=view.getId();

        if (currBtn==R.id.btnOrderNow ||currBtn==R.id.txtSeeAll){
            startActivity(intent);
        }
    }



}