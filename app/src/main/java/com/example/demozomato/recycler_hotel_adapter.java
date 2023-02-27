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

public class recycler_hotel_adapter extends RecyclerView.Adapter<recycler_hotel_adapter.ViewHolder>{

    Context context;
    ArrayList<recycler_content_struct_hotel> hotelInfos;


    recycler_hotel_adapter(Context context , ArrayList<recycler_content_struct_hotel> hotelInfos){

        this.context=context;
        this.hotelInfos=hotelInfos;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.restaurant_view ,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgHotelImage.setImageResource(hotelInfos.get(position).image);
        holder.txtHotelName.setText(hotelInfos.get(position).name);
        holder.txtHotelCusine.setText(hotelInfos.get(position).cusine);
        holder.txtHotelDistance.setText(hotelInfos.get(position).km);
        holder.txtHotelRating.setText(hotelInfos.get(position).rating);
        holder.txtHotelForOnePrice.setText(hotelInfos.get(position).forOne);

    }

    @Override
    public int getItemCount() {
        return hotelInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtHotelName,txtHotelCusine,txtHotelRating,txtHotelDistance,txtHotelForOnePrice;
        ImageView imgHotelImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtHotelName=itemView.findViewById(R.id.txtHotelName);
            txtHotelCusine=itemView.findViewById(R.id.txtHotelCusine);
            txtHotelRating=itemView.findViewById(R.id.txtHotelRating);
            txtHotelDistance=itemView.findViewById(R.id.txtHotelDistance);
            txtHotelForOnePrice=itemView.findViewById(R.id.txtHotelForOnePrice);
            imgHotelImage=itemView.findViewById(R.id.imgHotelImage);
        }
    }
}
