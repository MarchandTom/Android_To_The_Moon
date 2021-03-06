package com.example.tothemoon;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder>{
    private Bundle bundle;
    private List<Flight> flights;

    // RecyclerView recyclerView;
    public FlightAdapter(List<Flight> flights, Bundle bundle) {
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
        final Flight flight = flights.get(position);

        holder.destination.setText(flights.get(position).getCountryName() + " - " + flights.get(position).getPlaceName());
        holder.price.setText(new Double(flights.get(position).getMaxPrice()).toString() + " €");
        holder.date.setText(flights.get(position).getDepartureDate());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("country",flight.getCountryName());
                bundle.putString("capitalCity",flight.getPlaceName());
                bundle.putString("departureDate","20/02/2021");
                bundle.putDouble("priceFlight",flight.getMaxPrice());

                Navigation.findNavController(view)
                        .navigate(R.id.action_ListTripsFragment_to_RecapTripFragment,bundle);

            }
        });
    }


    @Override
    public int getItemCount() {
        return flights.size();
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
            relativeLayout = itemView.findViewById(R.id.trip_layout_item);
        }
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}