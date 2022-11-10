package com.example.carsharing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SelectDestination extends AppCompatActivity {

    private TextInputEditText Destinatie;
    private TextInputEditText NumarDePersoane;
    private Button btninapoi;
    private Button btninainte;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_destination);

        Destinatie = findViewById(R.id.tiet_destination);
        NumarDePersoane = findViewById(R.id.tiet_personNumber);

        btninapoi = findViewById(R.id.btn_Inapoi);
        btninapoi.setOnClickListener( addOnClickAddUser());
        btninainte = findViewById(R.id.btn_Inainte);
        btninainte.setOnClickListener( addOnClickCancel());

        intent =getIntent();

    }

    private View.OnClickListener addOnClickCancel() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK,intent);
                finish();
            }
        };
    }

    private View.OnClickListener addOnClickAddUser() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_is_valid()){

                    sharedPreferences = getApplicationContext().getSharedPreferences("Autentificare", MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("Destinatie", Destinatie.getText().toString());
                    editor.putString("Numar de persoane", NumarDePersoane.getText().toString());
                    editor.apply();

                    setResult(RESULT_OK,intent);
                    finish();

                }
            }
        };
    }

    private boolean user_is_valid() {
        if (Destinatie.getText().length() < 3  || Destinatie.getText().toString().trim().isEmpty() )
        {
            Toast.makeText(getApplicationContext(), R.string.SelectDestination_eroare_Destinatie, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (NumarDePersoane.getText().length() < 3  || NumarDePersoane.getText().toString().trim().isEmpty() )
        {
            Toast.makeText(getApplicationContext(), R.string.SelectDestination_eroare_NumarDePersoane, Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }

}