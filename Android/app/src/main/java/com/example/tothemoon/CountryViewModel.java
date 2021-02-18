package com.example.tothemoon;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.io.IOException;
import java.util.List;

public class CountryViewModel  extends AndroidViewModel {
    private CountryRepository countryRepository;
    private LiveData<List<Country>> allCountries;

    // Initialize the repository and the list of words
    public CountryViewModel(Application application) throws IOException {
        super(application);
        countryRepository = new CountryRepository(application);
        allCountries = countryRepository.getCountriesFromApi();
    }

    public LiveData<List<Country>> getAllCountries(){
        return allCountries;
    }

}

