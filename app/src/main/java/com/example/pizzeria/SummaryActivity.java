package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView textParametry;
    TextView textRazem;
    Button buttonPowrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textParametry = findViewById(R.id.textParametry);
        textRazem = findViewById(R.id.textRazem);
        buttonPowrot = findViewById(R.id.buttonPowrot);

        Intent intent = getIntent();
        String rozmiar = intent.getStringExtra("rozmiar");
        String ciasto = intent.getStringExtra("ciasto");
        int sztuk = intent.getIntExtra("sztuk", 1);
        double razem = intent.getDoubleExtra("razem", 0);

        textParametry.setText("Rozmiar: " + rozmiar + "\nCiasto: " + ciasto + "\nSztuk: " + sztuk);
        textRazem.setText("Razem: " + String.format("%.2f", razem) + " PLN");

        buttonPowrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}