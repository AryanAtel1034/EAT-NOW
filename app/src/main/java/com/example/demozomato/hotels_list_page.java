package com.example.demozomato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class hotels_list_page extends AppCompatActivity {

    RecyclerView recyclerPopularPage;

    ArrayList<recycler_content_struct_hotel> hotelInfos= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_list_page);


        recyclerPopularPage=findViewById(R.id.recyclerPopularPage);

        recyclerPopularPage.setLayoutManager(new LinearLayoutManager(this));


        hotelInfos.add(new recycler_content_struct_hotel("Laxmi Family Garden and Restaurant","North Indian•Mughlai•Chinese","4.1", R.drawable.indiandish,"5 km","250"));
        hotelInfos.add(new recycler_content_struct_hotel("Mejawani Kitchen","North Indian•Continental•Chinese","4.9", R.drawable.mejwani,"7 km","420"));
        hotelInfos.add(new recycler_content_struct_hotel("McDonald's","Fast Food•Burger","3.8", R.drawable.mac,"3.5 km","200"));
        hotelInfos.add(new recycler_content_struct_hotel("KFC","Fried Chicken","4.9", R.drawable.kfc,"17 km","300"));
        hotelInfos.add(new recycler_content_struct_hotel("Dominos","Italian• Pizza","4.6", R.drawable.dominos,"5.5 km","150"));
        hotelInfos.add(new recycler_content_struct_hotel("Subway","Green Salad","4.7", R.drawable.subway,"12 km","120"));

        recycler_hotel_adapter adapter= new recycler_hotel_adapter(this, hotelInfos);
        recyclerPopularPage.setAdapter(adapter);

    }
}