package com.example.tothemoon;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequest {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private FlightAdapter adapter;

    public HttpRequest(FlightAdapter adapter) {
        this.adapter = adapter;
    }

//    public LiveData<List<List>> HttpGetRequest(String url, String json) {
//        MutableLiveData<List<Country>> travel = new MutableLiveData<>();
//
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = RequestBody.create(json,JSON);
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                String mMessage = e.getMessage().toString();
//                Log.w("failure Response", mMessage);
//                //call.cancel();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                List<Country> countries = Arrays.asList(objectMapper.readValue(response.body().string(), Country[].class));
//                liveCountry.postValue(countries);
//            }
//        });
//
//        return liveCountry;
//    }

    public FlightAdapter getAdapter() {
        return adapter;
    }
}
