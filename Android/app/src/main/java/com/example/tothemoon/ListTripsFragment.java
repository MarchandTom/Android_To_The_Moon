package com.example.tothemoon;

import android.os.Bundle;
import android.util.Log;
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

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ListTripsFragment extends Fragment {
    private ViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_trips, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();

        viewModel = new ViewModelProvider(requireActivity()).get(ViewModel.class);
            viewModel.getAllCountries().observe(getActivity(), new Observer<List<Country>>() {
                @Override
                public void onChanged(List<Country> countries) {
                    Log.i("COUNTRY","countries count = "+ countries.size());
                    try {
                        viewModel.getAllFlights(bundle.getString("price"),countries).observe(getActivity(), new Observer<List<Flight>>() {
                            @Override
                            public void onChanged(List<Flight> flights) {
                                System.out.println("listTripsflights="+flights);
                                for(Flight f : flights) {
                                    f.setDepartureDate(bundle.getString("date"));
                                }
                                FlightAdapter adapter = new FlightAdapter(flights);
                                RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView.setAdapter(adapter);
                                System.out.println("listTrips="+flights);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        super.onViewCreated(view, savedInstanceState);

//        System.out.println(bundle.getString("price"));
//        System.out.println(bundle.getBoolean("priceSelected"));
//        System.out.println(bundle.getString("date"));
//        System.out.println(bundle.getBoolean("dateSelected"));



        view.findViewById(R.id.modify_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListTripsFragment.this)
                        .navigate(R.id.action_ListTripsFragment_to_SearchTripFragment, bundle);
            }
        });



    }
}