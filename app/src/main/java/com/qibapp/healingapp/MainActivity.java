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
    String toast,bahasa,Page;

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

        bahasa = "bi";
        toast = "Welcome to Healing App\nHappy read the quotes and happy healing";
        Page = "main";

        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);

        if(bahasa.equals("bi"))
        {
            explainbi();
        } else if (bahasa.equals("bm"))
        {
            explainbm();
        }

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
                Intent i= new Intent(getApplicationContext(),HealingPage.class);
                i.putExtra("bahasa",bahasa);
                startActivity(i);
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void explainbi() {
        bahasa = "bi";
        penerangn.setText("This app is used to show 50 random healing quotes and help you find Healing Places near you");
        textView.setText("WELCOME TO\nHEALING APP");
        Start.setText("CLICK TO START HEALING");
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        toast = "Welcome to Healing App\nHappy read the quotes and happy healing";
    }

    @SuppressLint("SetTextI18n")
    private void explainbm() {
        bahasa = "bm";
        penerangn.setText("Aplikasi ini digunakan untuk menunjukkan 50 quote-quote healing secara rawak dan bantu anda mencari tempat Healing berhampiran anda");
        textView.setText("SELAMAT DATANG KE\nAPLIKASI HEALING");
        Start.setText("KLIK UNTUK MULAKAN HEALING");
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        toast = "Selamat Datang Ke Healing App\nSelamat membaca petikan dan selamat Healing";
    }
}