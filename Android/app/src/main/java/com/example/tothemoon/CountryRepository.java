package com.example.tothemoon;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CountryRepository {
    private CountryDao countryDao;
    private LiveData<List<Country>> allCountries;

    CountryRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        countryDao = db.countryDao();
        allCountries = (LiveData<List<Country>>) countryDao.getAll();
    }

    LiveData<List<Country>> getCountriesFromApi() throws IOException {
        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Log.i(in.toString(),"on toto");
        }finally {
            urlConnection.disconnect();
        }
        return null;
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
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
