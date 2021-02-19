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
    }

    public LiveData<List<Country>> getAllCountries(){
        if(allCountries == null){
            allCountries = countryRepository.getAllCountries();
        }
        return allCountries;
    }

    public LiveData<List<Country>> loadCountries() {
        try{
            return countryRepository.getCountriesFromApi();
        }catch(IOException e){
            System.err.println(e);
            return null;
        }
    }

    public void insertCountries(List<Country> countries){
        for(Country c: countries){
            c.setVisited(false);
            System.out.println("insert into bdd="+c);
            countryRepository.insert(c);
        }
    }

}

