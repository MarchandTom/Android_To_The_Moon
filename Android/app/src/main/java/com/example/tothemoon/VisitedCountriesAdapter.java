package com.example.tothemoon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VisitedCountriesAdapter extends RecyclerView.Adapter<VisitedCountriesAdapter.ViewHolder>{
    private ArrayList<Country> countries;

    // RecyclerView recyclerView;
    public VisitedCountriesAdapter(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @Override
    public VisitedCountriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_visited_countries_items, parent, false);
        VisitedCountriesAdapter.ViewHolder viewHolder = new VisitedCountriesAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VisitedCountriesAdapter.ViewHolder holder, int position) {
        final Country country = countries.get(position);

        holder.country_name.setText(country.getName());
        holder.switch_visited_country.setChecked(country.getVisited());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cpicpi"+country.getName());
                //Navigation.findNavController(view)
                //        .navigate(R.id.action_ListTripsFragment_to_RecapTripFragment,bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView country_name;
        public CheckBox switch_visited_country;

        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.country_name = itemView.findViewById(R.id.country_name);
            this.switch_visited_country = itemView.findViewById(R.id.switch_visited_country);
            relativeLayout = itemView.findViewById(R.id.visited_country_layout_item);
        }
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
