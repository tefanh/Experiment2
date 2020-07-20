package com.example.experiment2.ui.country;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.experiment2.config.RequestBuilder;
import com.example.experiment2.config.SharedPreferenceManager;
import com.example.experiment2.data.model.Country;
import com.example.experiment2.data.repository.CountryService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {
    private static final String TAG = "CountryViewModel";

    private MutableLiveData<List<Country>> countries;
    private Context context;

    public MutableLiveData<List<Country>> getCountries(Context context) {
        if (countries == null) {
            countries = new MutableLiveData<>();
            fetchCountries();
            Log.d(TAG, "getRegions: fistst");
        }
        if (this.context == null) {
            this.context = context;
        }

        return countries;
    }

    public void fetchCountries() {
        CountryService countryService = RequestBuilder.getRetrofit().create(CountryService.class);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + SharedPreferenceManager.getInstance(context).getIdToken().getId_token());
        countryService.query(headers).enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                countries.setValue(Arrays.asList(response.body()));
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
