package com.example.tothemoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ListTripsFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_trips, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        System.out.println(bundle.getString("price"));
        System.out.println(bundle.getBoolean("priceSelected"));
        System.out.println(bundle.getString("date"));
        System.out.println(bundle.getBoolean("dateSelected"));

        view.findViewById(R.id.modify_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListTripsFragment.this)
                        .navigate(R.id.action_ListTripsFragment_to_SearchTripFragment);
            }
        });

        view.findViewById(R.id.select_trip_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListTripsFragment.this)
                        .navigate(R.id.action_ListTripsFragment_to_RecapTripFragment);
            }
        });
    }
}