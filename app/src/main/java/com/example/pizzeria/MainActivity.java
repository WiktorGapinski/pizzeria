package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton radioMala;
    RadioButton radioSrednia;
    RadioButton radioDuza;
    CheckBox checkGrube;
    EditText editSztuk;
    Button buttonPodsumowanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioMala = findViewById(R.id.radioMala);
        radioSrednia = findViewById(R.id.radioSrednia);
        radioDuza = findViewById(R.id.radioDuza);
        checkGrube = findViewById(R.id.checkGrube);
        editSztuk = findViewById(R.id.editSztuk);
        buttonPodsumowanie = findViewById(R.id.buttonPodsumowanie);

        buttonPodsumowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tekst = editSztuk.getText().toString();

                if (tekst.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj liczbę sztuk", Toast.LENGTH_SHORT).show();
                    return;
                }

                int sztuk = Integer.parseInt(tekst);

                if (sztuk < 1) {
                    Toast.makeText(MainActivity.this, "Liczba sztuk musi być większa od 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                String rozmiar;
                int cena;

                if (radioMala.isChecked()) {
                    rozmiar = "Mała";
                    cena = 25;
                } else if (radioDuza.isChecked()) {
                    rozmiar = "Duża";
                    cena = 45;
                } else {
                    rozmiar = "Średnia";
                    cena = 35;
                }

                String ciasto = "Cienkie";
                if (checkGrube.isChecked()) {
                    ciasto = "Grube";
                    cena = cena + 5;
                }

                double razem = cena * sztuk;

                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                intent.putExtra("rozmiar", rozmiar);
                intent.putExtra("ciasto", ciasto);
                intent.putExtra("sztuk", sztuk);
                intent.putExtra("razem", razem);
                startActivity(intent);
            }
        });
    }
}