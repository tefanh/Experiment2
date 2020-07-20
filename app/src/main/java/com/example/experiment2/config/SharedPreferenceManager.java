package com.example.experiment2.config;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.experiment2.data.model.Authenticate;
import com.example.experiment2.ui.login.LoginActivity;

public class SharedPreferenceManager {
    private static final String SHARED_PREFERENCE_NAME = "USER_ACCESS";
    private static final String ID_TOKEN = "id_token";

    private static SharedPreferenceManager instance;
    private static Context context;

    public SharedPreferenceManager(Context ctx) {
        context = ctx;
    }

    public static synchronized SharedPreferenceManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new SharedPreferenceManager(ctx);
        }
        return instance;
    }

    public void storeIdToken(Authenticate authenticate) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ID_TOKEN, authenticate.getId_token());
        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ID_TOKEN, null) != null;
    }

    public Authenticate getIdToken() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        return new Authenticate(sharedPreferences.getString(ID_TOKEN, null));
    }

    public void logout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
