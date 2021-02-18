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
    private Bundle bundle;

    // RecyclerView recyclerView;
    public FlightAdapter(Flight[] flights, Bundle bundle) {
        this.flights = flights;
        this.bundle = bundle;
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

        holder.destination.setText(flights[position].getCountry() + " - " + flights[position].getCapitalCity());
        holder.price.setText(new Double(flights[position].getPrice()).toString() + " €");
        holder.date.setText(flights[position].getDepartureDate());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("country",flight.getCountry());
                bundle.putString("capitalCity",flight.getCapitalCity());
                bundle.putString("departureDate",flight.getDepartureDate());
                bundle.putDouble("priceFlight",flight.getPrice());

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
        public TextView destination;
        public TextView price;
        public TextView date;

        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.destination = itemView.findViewById(R.id.destination);
            this.price = itemView.findViewById(R.id.price);
            this.date = itemView.findViewById(R.id.date);
            relativeLayout = itemView.findViewById(R.id.relativeLayoutItem);
        }
    }
}