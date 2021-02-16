package com.example.tothemoon;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;


public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder>{
    private Flight[] flights;

    // RecyclerView recyclerView;
    public FlightAdapter(Flight[] flights) {
        this.flights = flights;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_trip_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Flight flight = flights[position];
        holder.textView.setText(flights[position].toString());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("country",flight.getCountry());
                bundle.putString("capitalCity",flight.getCapitalCity());
                bundle.putString("departureDate",flight.getDepartureDate());
                bundle.putDouble("price",flight.getPrice());

                Navigation.findNavController(view)
                        .navigate(R.id.action_ListTripsFragment_to_RecapTripFragment,bundle);

            }
        });
    }


    @Override
    public int getItemCount() {
        return flights.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textViewItem);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayoutItem);
        }
    }
}