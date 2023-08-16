package com.qibapp.healingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HealingPage extends AppCompatActivity {
    Button Map,Healing;
    ImageView bm,bi,back;
    String bahasa,seach,url,toastmap,toasthealing,toastBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healing_page);
        Map = findViewById(R.id.button);
        Healing = findViewById(R.id.button2);
        bm = findViewById(R.id.ivbm);
        bi = findViewById(R.id.ivbi);
        back = findViewById(R.id.ivback);

        bahasa=getIntent().getStringExtra("bahasa");

        if(bahasa.equals("bi"))
        {
            explainbi();
        } else if (bahasa.equals("bm"))
        {
            explainbm();
        }

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seach = "tempat healing near me";
                url = "https://www.google.com/search?q=" + Uri.encode(seach);
                Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                Toast.makeText(getApplicationContext(),toastmap,Toast.LENGTH_SHORT).show();
                startActivity(map);
            }
        });

        Healing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healing = new Intent(getApplicationContext(),AyatHealing.class);
                healing.putExtra("bahasa",bahasa);
                startActivity(healing);
                Toast.makeText(getApplicationContext(), toasthealing, Toast.LENGTH_LONG).show();
            }
        });

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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent healing = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(healing);
                Toast.makeText(getApplicationContext(), toastBack, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void explainbi() {
        bahasa = "bi";
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        Map.setText("CLICK TO SEACH HEALING PLACE NEAR YOU");
        Healing.setText("CLICK TO READ RANDOM HEALING QUOTES");
        toastmap = "Happy Finding Healing Place Near You";
        toasthealing = "Happy Reading The Random Healing Quotes";
        toastBack = "Thank you For Using Healing App";
    }

    @SuppressLint("SetTextI18n")
    private void explainbm() {
        bahasa = "bm";
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        Map.setText("KLIK UNTUK MENCARI TEMPAT HEALING BERHAMPIRAN ANDA");
        Healing.setText("KLIK UNTUK MEMBACA QUOTE - QOUTE HEALING SECARA RAWAK");
        toastmap = "Selamat Mencari Tempat Healing Berhampiran Anda";
        toasthealing = "Selamat Membaca Random Quotes Healing";
        toastBack = "Terima Kasih Kerana Menggunakan Healing App";
    }
}