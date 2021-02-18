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

        run("http://172.26.64.1:3000/country");
        return null;
    }

    LiveData<List<Country>> getAllCountries(){
        return allCountries;
    }

    public void insert (Country country){
        new InsertAsyncTask(countryDao).execute(country);
    }

    public void run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    System.out.println("res:"+responseBody.string());
                }
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
