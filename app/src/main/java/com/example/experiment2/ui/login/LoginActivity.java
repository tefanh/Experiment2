package com.example.experiment2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.experiment2.R;
import com.example.experiment2.config.RequestBuilder;
import com.example.experiment2.config.SharedPreferenceManager;
import com.example.experiment2.data.model.Authenticate;
import com.example.experiment2.data.model.Credential;
import com.example.experiment2.data.repository.AuthenticateService;
import com.example.experiment2.ui.region.RegionActivity;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText editTxtUsername;
    private EditText editTxtPassword;
    private ProgressBar pBarLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (SharedPreferenceManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, RegionActivity.class));
        }

        editTxtUsername = findViewById(R.id.editTxtUsername);
        editTxtPassword = findViewById(R.id.editTxtPassword);
        pBarLogin = findViewById(R.id.pBarLogin);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> processLogin());
    }

    private void processLogin() {
        try {
            pBarLogin.setVisibility(View.VISIBLE);
            final String username = editTxtUsername.getText().toString();
            final String password = editTxtPassword.getText().toString();
            final JSONObject body = new JSONObject();
            body.put("username", username);
            body.put("password", password);
            body.put("rememberMe", true);

            if (TextUtils.isEmpty(username)) {
                editTxtUsername.setError("Please enter your username!");
                editTxtUsername.requestFocus();

                return;
            }

            if (TextUtils.isEmpty(password)) {
                editTxtPassword.setError("Please enter your password!");
                editTxtPassword.requestFocus();

                return;
            }

            AuthenticateService authenticateService = RequestBuilder.getRetrofit().create(AuthenticateService.class);
            Credential credential = new Credential("admin", "admin", false);
            authenticateService.login(credential).enqueue(new Callback<Authenticate>() {
                @Override
                public void onResponse(Call<Authenticate> call, Response<Authenticate> response) {
                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();

                    SharedPreferenceManager.getInstance(getApplicationContext()).storeIdToken(response.body());
                    finish();
                    startActivity(new Intent(getApplicationContext(), RegionActivity.class));
                }

                @Override
                public void onFailure(Call<Authenticate> call, Throwable t) {
                    pBarLogin.setVisibility(View.GONE);
                    Log.d(TAG, "onErrorResponse: " + t.getMessage());
                    Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}