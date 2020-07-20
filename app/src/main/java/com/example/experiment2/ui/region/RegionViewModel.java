package com.example.experiment2.ui.region;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.experiment2.config.RequestBuilder;
import com.example.experiment2.config.SharedPreferenceManager;
import com.example.experiment2.data.model.Region;
import com.example.experiment2.data.repository.RegionService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegionViewModel extends ViewModel {
    private static final String TAG = "RegionViewModel";
    private MutableLiveData<List<Region>> regions;
    private Context context;

    public MutableLiveData<List<Region>> getRegions(Context context) {
        if (regions == null) {
            regions = new MutableLiveData<>();
            fetchRegions();
        }
        if (this.context == null) {
            this.context = context;
        }

        return regions;
    }

    public void fetchRegions() {
        RegionService regionService = RequestBuilder.getRetrofit().create(RegionService.class);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + SharedPreferenceManager.getInstance(context).getIdToken().getId_token());
        regionService.query(headers).enqueue(new Callback<Region[]>() {
            @Override
            public void onResponse(Call<Region[]> call, Response<Region[]> response) {
                regions.setValue(Arrays.asList(response.body()));
            }

            @Override
            public void onFailure(Call<Region[]> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
