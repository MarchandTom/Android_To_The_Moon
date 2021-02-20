package com.example.tothemoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class VisitedCountriesFragment extends Fragment {

    private ViewModel viewModel;
    RecyclerView recyclerView;//fragment_visited_countries_recycler_view

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModel.class);
        viewModel.getAllCountries().observe(getActivity(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                VisitedCountriesAdapter adapter = new VisitedCountriesAdapter(new ArrayList(countries));
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visited_countries, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_visited_countries_recycler_view);

        view.findViewById(R.id.menu_from_visited_countries_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(VisitedCountriesFragment.this)
                        .navigate(R.id.action_visitedCountriesFragment_to_MenuFragment);
            }
        });
    }
}