package com.qibapp.healingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView bm,bi;
    TextView textView,penerangn;
    Button Start;
    String toast;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        penerangn = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView);
        Start = findViewById(R.id.button);
        bm = findViewById(R.id.ivbm);
        bi = findViewById(R.id.ivbi);
        toast = "Welcome to Healing App\nHappy read the quotes and happy healing";

        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        explainbi();

        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainbm();
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainbi();
            }
        });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
                Intent i= new Intent(getApplicationContext(),AyatHealing.class);
                startActivity(i);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void explainbi() {
        penerangn.setText("This App is use to show random healing sentences");
        textView.setText("WELCOME TO\nHEALING APP");
        Start.setText("CLICK TO START HEALING");
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        toast = "Welcome to Healing App\nHappy read the quotes and happy healing";
    }

    @SuppressLint("SetTextI18n")
    private void explainbm() {
        penerangn.setText("Aplikasi ini digunakan untuk menunjukkan ayat penyembuhan rawak");
        textView.setText("SELAMAT DATANG KE\nAPLIKASI HEALING");
        Start.setText("KLIK UNTUK MULAKAN HEALING");
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        toast = "Selamat Datang Ke Healing App\nSelamat membaca petikan dan selamat Healing";
    }
}