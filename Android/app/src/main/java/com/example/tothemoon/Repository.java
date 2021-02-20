package com.example.tothemoon;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CountryRepository {
    private CountryDao countryDao;
    private LiveData<List<Country>> allCountries;
    private OkHttpClient client;


    CountryRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        client  = new OkHttpClient();
        countryDao = db.countryDao();
        allCountries = (LiveData<List<Country>>) countryDao.getAll();
    }

    LiveData<List<Flight>> getAllFlights(String price) throws JSONException {
        MutableLiveData<List<Flight>> liveFlight = new MutableLiveData<>();


    JSONObject fr = new JSONObject();
    fr.put("name","France");
    fr.put("code","FR");

    JSONArray array = new JSONArray();
    array.put(fr);

    JSONObject json = new JSONObject();
    json.put("maxPrice",Integer.parseInt(price));
    json.put("alreadyVisitedCountry",array);


        Request request = new Request.Builder()
                .url("https://ap5tothemoon.herokuapp.com/travel")
                .header("Content-Type", "application/json")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                List<Flight> flights = Arrays.asList(objectMapper.readValue(response.body().string(), Flight[].class));
                liveFlight.postValue(flights);
            }
        });

        return liveFlight;
    }

    LiveData<List<Country>> getCountriesFromApi() {
        MutableLiveData<List<Country>> liveCountry = new MutableLiveData<>();

        Request request = new Request.Builder()
                .url("https://ap5tothemoon.herokuapp.com/country")
                .header("Content-Type", "application/json")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                List<Country> countries = Arrays.asList(objectMapper.readValue(response.body().string(), Country[].class));
                liveCountry.postValue(countries);
            }
        });

        return liveCountry;
    }

    LiveData<List<Country>> getAllCountries(){
        return allCountries;
    }

    public void insert (Country country){
        new InsertAsyncTask(countryDao).execute(country);
    }

    private static class InsertAsyncTask extends AsyncTask
            <Country, Void, Void> {
        private CountryDao mAsyncTaskDao;
        InsertAsyncTask(CountryDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Country... params) {
            try{
                mAsyncTaskDao.insert(params[0]);
            }catch(Exception e){
                System.err.println(e);
            }
            return null;
        }
    }

}
