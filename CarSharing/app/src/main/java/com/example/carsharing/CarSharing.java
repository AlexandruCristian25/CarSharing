package com.example.carsharing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CarSharing extends AppCompatActivity {

    private EditText name;
    private EditText year;
    private EditText brand;
    private EditText start_location;
    private EditText end_location;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_car);

        name= findViewById(R.id.edtxtName);
        year = findViewById(R.id.edtxtYofManufacturing);
        brand = findViewById(R.id.edtxtCarBrand);
        start_location = findViewById(R.id.edtxtStartLocation);
        end_location = findViewById(R.id.edtxtEndLocation);
        btn_save = findViewById(R.id.btnSaveShareCar);

    }
}