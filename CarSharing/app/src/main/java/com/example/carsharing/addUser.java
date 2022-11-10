package com.example.carsharing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class addUser extends AppCompatActivity {

    private TextInputEditText nume_utilizator;
    private TextInputEditText parola;
    private Button btnadd;
    private Button btncancel;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        nume_utilizator = findViewById(R.id.tiet_username);
        parola = findViewById(R.id.tiet_password);

        btnadd = findViewById(R.id.btn_adaugare);
        btnadd.setOnClickListener( addOnClickAddUser());
        btncancel = findViewById(R.id.btn_cancel);
        btncancel.setOnClickListener( addOnClickCancel());

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
                    editor.putString("Nume", nume_utilizator.getText().toString());
                    editor.putString("Parola", parola.getText().toString());
                    editor.apply();

                    setResult(RESULT_OK,intent);
                    finish();

                }
            }
        };
    }

    private boolean user_is_valid() {
        if (nume_utilizator.getText().length() < 3  || nume_utilizator.getText().toString().trim().isEmpty() )
        {
            Toast.makeText(getApplicationContext(), R.string.addUser_eroare_nume, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (parola.getText().length() < 3  || parola.getText().toString().trim().isEmpty() )
        {
            Toast.makeText(getApplicationContext(), R.string.AddUser_eroare_parola, Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }

}