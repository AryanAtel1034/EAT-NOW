package com.example.demozomato;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {


    Context context;
    ArrayList<recycler_content_struct> categoriesInfo;


    recyclerAdapter(Context context , ArrayList<recycler_content_struct> categoriesInfo){

        this.context=context;
        this.categoriesInfo=categoriesInfo;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_view_categories ,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categorieName.setText(categoriesInfo.get(position).name);
        holder.categorieImage.setImageResource(categoriesInfo.get(position).img);




    }

    @Override
    public int getItemCount() {
        return categoriesInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categorieImage;
        TextView categorieName;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            categorieImage=itemView.findViewById(R.id.categorieImage);
            categorieName=itemView.findViewById(R.id.categorieName);


        }
    }
}
