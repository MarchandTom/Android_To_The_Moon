package com.example.tothemoon;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

    LiveData<List<Country>> getCountriesFromApi() throws IOException {
        Request request = new Request.Builder()
                .url("https://ap5tothemoon.herokuapp.com/country")
                .header("Content-Type", "application/json")
                .build();
        run(request);
        return null;
    }

    LiveData<List<Country>> getAllCountries(){
        return allCountries;
    }

    public void insert (Country country){
        new InsertAsyncTask(countryDao).execute(country);
    }

    public void run(Request request) throws IOException {

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println("result="+response.body().string());

            }
        });
    }


    private static class InsertAsyncTask extends AsyncTask
            <Country, Void, Void> {
        private CountryDao mAsyncTaskDao;
        InsertAsyncTask(CountryDao dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final Country... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
