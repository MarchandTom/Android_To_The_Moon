package com.example.tothemoon;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Country>> allCountries;

    // Initialize the repository and the list of words
    public ViewModel(Application application){
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Country>> getAllCountries(){
        if(allCountries == null){
            allCountries = repository.getAllCountries();
        }
        return allCountries;
    }

    public LiveData<List<Flight>> getAllFlights(String price,List<Country> countries) throws JSONException {
        return repository.getAllFlights(price,countries);
    }

    public LiveData<List<Country>> loadCountries() {
        return repository.getCountriesFromApi();
    }

    public void insertCountries(List<Country> countries){
        for(Country c: countries){
            c.setVisited(false);
            System.out.println("insert into bdd="+c);
            repository.insert(c);
        }
    }

    public void updateCountry(Country country) {
        repository.updateCountry(country);
    }

}

