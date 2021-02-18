package com.example.tothemoon;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

public class CountryViewModel  extends AndroidViewModel {
    private CountryRepository countryRepository;
    private LiveData<List<Country>> allCountries;

    // Initialize the repository and the list of words
    public CountryViewModel(Application application){
        super(application);
        countryRepository = new CountryRepository(application);
        initDatabase();
    }

    public LiveData<List<Country>> getAllCountries(){
        if(allCountries == null){
            allCountries = new MutableLiveData<List<Country>>();
            loadCountries();
        }
        return allCountries;
    }

    private void initDatabase(){
        try {
            countryRepository.getCountriesFromApi();
        }catch(IOException e){
            System.err.println(e);
        }
    }

    private void loadCountries() {
        try{
            countryRepository.getCountriesFromApi();
        }catch(IOException e){
            System.err.println(e);
        }
    }

}

