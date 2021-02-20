package com.example.tothemoon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


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
//        System.out.println(bundle.getString("price"));
//        System.out.println(bundle.getBoolean("priceSelected"));
//        System.out.println(bundle.getString("date"));
//        System.out.println(bundle.getBoolean("dateSelected"));


        try {
            ArrayList<Flight> flights = new ArrayList<Flight>();
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            flights.add(new Flight("bbbb","bbbb","bbbb",2000));
            FlightAdapter adapter = new FlightAdapter(flights);

            HttpRequest http = new HttpRequest(adapter);
            String url = "https://ap5tothemoon.herokuapp.com/travel";

            JSONObject fr = new JSONObject();
            fr.put("name","France");
            fr.put("code","FR");

            JSONArray array = new JSONArray();
            array.put(fr);

            JSONObject json = new JSONObject();
            json.put("maxPrice",3000.0);
            json.put("alreadyVisitedCountry",array);


            RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        view.findViewById(R.id.modify_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListTripsFragment.this)
                        .navigate(R.id.action_ListTripsFragment_to_SearchTripFragment, bundle);
            }
        });



    }
}