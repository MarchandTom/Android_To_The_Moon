package com.example.tothemoon;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        if(bundle != null && !bundle.isEmpty() && bundle.getBoolean("confirmedTrip")) {
            bundle.putBoolean("confirmedTrip", false);
            Toast toast = Toast.makeText(view.getContext(), "Voyage confirmé !", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 200);
            toast.show();
        }

        view.findViewById(R.id.visit_country_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_SearchTripFragment);
            }
        });

        view.findViewById(R.id.visited_countries_from_menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_visitedCountriesFragment);
            }
        });
    }
}