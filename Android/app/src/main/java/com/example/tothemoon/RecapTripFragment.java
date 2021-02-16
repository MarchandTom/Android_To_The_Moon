package com.example.tothemoon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class RecapTripFragment extends Fragment {

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

        Bundle bundle = this.getArguments();
        Log.i("Bundle",bundle.getString("country") + " / "
                + bundle.getString("capitalCity") + " / "
                + bundle.getString("departureDate") + " / "
                + bundle.getDouble("price"));

        view.findViewById(R.id.list_trips_from_recap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RecapTripFragment.this)
                        .navigate(R.id.action_RecapTripFragment_to_ListTripsFragment);
            }
        });

        view.findViewById(R.id.validate_trip_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RecapTripFragment.this)
                        .navigate(R.id.action_RecapTripFragment_to_MenuFragment);
            }
        });
    }
}