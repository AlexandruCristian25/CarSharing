package com.example.carsharing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class RideCarLogin extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login, registration;
    private ActivityResultLauncher<Intent> addUserLaucher;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String nume_utilizator;
    private String parola;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_car_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        login.setOnClickListener(LoginUseronClickListener());
        registration = findViewById(R.id.registration);

        addUserLaucher = registerAddUserLauncher();

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),addUser.class);
                addUserLaucher.launch(intent);

            }
        });

    }

    private View.OnClickListener LoginUseronClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userExists()){

                    //Launcher pentru activitatea noua
                    Toast.makeText(getApplicationContext(), "Succes", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private ActivityResultLauncher<Intent> registerAddUserLauncher() {
        ActivityResultCallback<ActivityResult> callback = gettAddUserActivityCallBack();
        return  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),callback);
    }

    private ActivityResultCallback<ActivityResult> gettAddUserActivityCallBack() {
        return new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                sharedPreferences =getApplicationContext().getSharedPreferences("Autentificare",MODE_PRIVATE);
                editor= sharedPreferences.edit();

                nume_utilizator = sharedPreferences.getString("nume","none");
                parola = sharedPreferences.getString("parola","none");


            }
        };
    }

    private boolean userExists() {

        if(username.getText().toString().length() < 3 || username.getText().toString().trim().isEmpty()
        || username.getText().toString().equals(nume_utilizator)){

            return false;
        }
        if(password.getText().toString().length() < 3 || password.getText().toString().trim().isEmpty()
                || password.getText().toString().equals(parola)){

            return false;
        }
        return true;
    }

    private boolean isValid() {
        return false;
    }

    @Override
    protected void onStart () {
        super.onStart();
    }

    @Override
    protected void onStop () {
        super.onStop();
    }

}
