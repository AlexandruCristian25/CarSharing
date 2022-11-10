package com.example.carsharing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnShareCar, btnRideCar;
    private ActivityResultLauncher<Intent> addShareCarLauncher;
    private ActivityResultLauncher<Intent> addSelectCarLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addShareCarLauncher = registerAddStudentActivityResultLauncher();
        
        btnShareCar = findViewById(R.id.btnShareCar);
        btnRideCar = findViewById(R.id.btnRideCar);

        btnShareCar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ShareCarLogin.class);
                addShareCarLauncher.launch(intent);
            }
        });

        btnRideCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ShareCar.class);
                addShareCarLauncher.launch(intent);
            }
        });
    }




    private ActivityResultLauncher<Intent> registerAddStudentActivityResultLauncher() {

        ActivityResultCallback<ActivityResult> callback = getAddStudentActivityResultCallback();
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), callback);

    }

    private ActivityResultCallback<ActivityResult> getAddStudentActivityResultCallback() {

        return new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            }
        };
    }
}