package com.example.experiment2.ui.region;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.experiment2.R;
import com.example.experiment2.config.SharedPreferenceManager;
import com.example.experiment2.data.model.Region;
import com.example.experiment2.ui.country.CountryActivity;

import java.util.ArrayList;
import java.util.List;

public class RegionActivity extends AppCompatActivity {
    private static final String TAG = "RegionActivity";
    private ListView lvRegion;
    private ArrayAdapter<Region> regionAdapter;
    private List<Region> regions;
    private RegionViewModel regionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        regions = new ArrayList<>();
        lvRegion = findViewById(R.id.lvRegion);
        regionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regions);
        lvRegion.setAdapter(regionAdapter);

        regionViewModel = new ViewModelProvider(this).get(RegionViewModel.class);
        final Observer<List<Region>> observer = regions -> {
            regionAdapter.clear();
            regionAdapter.addAll(regions);
            regionAdapter.notifyDataSetChanged();
        };
        regionViewModel.getRegions(this).observe(this, observer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMainItemCountry:
                startActivity(new Intent(RegionActivity.this, CountryActivity.class));
                finish();
                return true;
            case R.id.menuMainItemLogout:
                SharedPreferenceManager.getInstance(RegionActivity.this).logout();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}