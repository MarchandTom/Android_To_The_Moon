package com.example.tothemoon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SearchTripFragment extends Fragment {

    EditText preferredPrice;
    SwitchCompat priceSelected;
    DatePicker preferredDate;
    SwitchCompat dateSelected;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_trip, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferredPrice = (EditText)view.findViewById(R.id.inputPrice);
        preferredDate = (DatePicker)view.findViewById(R.id.inputDate);
        priceSelected = (SwitchCompat)view.findViewById(R.id.switchPrice);
        dateSelected = (SwitchCompat)view.findViewById(R.id.switchDate);

        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            if(bundle.getString("price") != null) {
                preferredPrice.setText(bundle.getString("price"));
            }
            if(bundle.getString("date") != null) {
                String[] dateDivided = bundle.getString("date").split("/");
                preferredDate.updateDate(Integer.valueOf(dateDivided[2]), Integer.valueOf(dateDivided[1]), Integer.valueOf(dateDivided[0]));
            }
            priceSelected.setChecked(bundle.getBoolean("priceSelected"));
            dateSelected.setChecked(bundle.getBoolean("dateSelected"));
        }

        view.findViewById(R.id.menu_from_visited_countries_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SearchTripFragment.this)
                        .navigate(R.id.action_SearchTripFragment_to_MenuFragment);
            }
        });

        view.findViewById(R.id.list_trips_from_recap_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("price", preferredPrice.getText().toString());
                bundle.putBoolean("priceSelected", priceSelected.isChecked());
                bundle.putString("date", preferredDate.getDayOfMonth()+"/"+preferredDate.getMonth()+"/"+preferredDate.getYear());
                bundle.putBoolean("dateSelected", dateSelected.isChecked());

                NavHostFragment.findNavController(SearchTripFragment.this)
                        .navigate(R.id.action_SearchTripFragment_to_ListTripsFragment, bundle);
            }
        });
    }
}