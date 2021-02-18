package com.example.tothemoon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class RecapTripFragment extends Fragment {
    TextView recapDestination;
    TextView recapPrice;
    TextView recapDate;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recap_trip, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recapDestination = (TextView)view.findViewById(R.id.recapDestination);
        recapPrice = (TextView)view.findViewById(R.id.recapPrice);
        recapDate = (TextView)view.findViewById(R.id.recapDate);

        Bundle bundle = this.getArguments();

        recapDestination.setText(bundle.getString("country")+" - "+bundle.getString("capitalCity"));
        recapPrice.setText(String.valueOf(bundle.getDouble("priceFlight"))+" €");
        String dateDisplay=bundle.getString("departureDate").replace('-', '/');
        dateDisplay = dateDisplay.substring(0, dateDisplay.length()-3);
        recapDate.setText(dateDisplay);

        view.findViewById(R.id.list_trips_from_recap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.remove("country");
                bundle.remove("capitalCity");
                bundle.remove("departureDate");
                bundle.remove("priceFlight");
                NavHostFragment.findNavController(RecapTripFragment.this)
                        .navigate(R.id.action_RecapTripFragment_to_ListTripsFragment, bundle);
            }
        });

        view.findViewById(R.id.validate_trip_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.clear();
                bundle.putBoolean("confirmedTrip", true);
                NavHostFragment.findNavController(RecapTripFragment.this)
                        .navigate(R.id.action_RecapTripFragment_to_MenuFragment, bundle);
            }
        });
    }
}