package com.example.tothemoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        view.findViewById(R.id.modify_search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListTripsFragment.this)
                        .navigate(R.id.action_ListTripsFragment_to_SearchTripFragment);
            }
        });


        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String d = formatter.format(date);

        Flight[] flights = new Flight[] {
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50.0),
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50),
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50),
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50),
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50),
            new Flight("ESPAGNE","Madrid",d,300.5),
            new Flight("BELGIQUE","Bruxelles",d,50)
        };

        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);
        FlightAdapter adapter = new FlightAdapter(flights);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);

    }
}