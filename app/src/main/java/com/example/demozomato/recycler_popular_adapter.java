package com.example.demozomato;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class recycler_popular_adapter extends RecyclerView.Adapter<recycler_popular_adapter.ViewHolder>{

    Context context;
    ArrayList<recycler_content_struct_popular> popularsInfo;


    recycler_popular_adapter(Context context , ArrayList<recycler_content_struct_popular> popularsInfo){

        this.context=context;
        this.popularsInfo=popularsInfo;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.recyclerview_view_popular ,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imgPopularDish.setImageResource(popularsInfo.get(position).image);
        holder.txtPopularName.setText(popularsInfo.get(position).namee);
//      holder.txtPopularPrice.setText(popularsInfo.get(position).price.toString());

        holder.btnForDescription.setOnClickListener(new View.OnClickListener() {

            Intent intent= new Intent(context,description_view.class);
            @Override
            public void onClick(View v) {



                intent.putExtra("heading",popularsInfo.get(position).namee);
                intent.putExtra("img",popularsInfo.get(position).image);
                intent.putExtra("price",popularsInfo.get(position).price);


                context.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return popularsInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPopularDish;
        TextView txtPopularName;
        Button btnForDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtPopularName=itemView.findViewById(R.id.txtPopularName);
//            txtPopularPrice=itemView.findViewById(R.id.txtPopularPrice);
            imgPopularDish=itemView.findViewById(R.id.imgPopularDish);
            btnForDescription=itemView.findViewById(R.id.btnForDescription);
        }
    }
}
