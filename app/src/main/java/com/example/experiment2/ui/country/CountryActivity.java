package com.example.experiment2.ui.country;

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
import com.example.experiment2.data.model.Country;
import com.example.experiment2.ui.region.RegionActivity;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    private static final String TAG = "CountryActivity";
    private ListView lvCountry;
    private ArrayAdapter<Country> countryAdapter;
    private List<Country> countries;
    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        countries = new ArrayList<>();
        lvCountry = findViewById(R.id.lvCountry);
        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        lvCountry.setAdapter(countryAdapter);

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        final Observer<List<Country>> observer = countries -> {
            countryAdapter.clear();
            countryAdapter.addAll(countries);
            countryAdapter.notifyDataSetChanged();
        };
        countryViewModel.getCountries(this).observe(this, observer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMainItemRegion:
                startActivity(new Intent(CountryActivity.this, RegionActivity.class));
                finish();
                return true;
            case R.id.menuMainItemLogout:
                SharedPreferenceManager.getInstance(CountryActivity.this).logout();
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}