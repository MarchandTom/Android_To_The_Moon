package com.example.tothemoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import java.util.Arrays;
import java.util.List;

public class VisitedCountriesFragment extends Fragment {
    AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
            AppDatabase.class, "database-name").build();
    CountryDao countryDao = db.countryDao();
    List<Country> countries = Arrays.asList(countryDao.getAll());

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visited_countries, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.menu_from_visited_countries_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(VisitedCountriesFragment.this)
                        .navigate(R.id.action_visitedCountriesFragment_to_MenuFragment);
            }
        });
    }
}