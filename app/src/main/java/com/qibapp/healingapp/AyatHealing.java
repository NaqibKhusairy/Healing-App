package com.qibapp.healingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AyatHealing extends AppCompatActivity {
    Button Roll;
    ImageView bm,bi,back;
    TextView Text;
    String bahasa;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_healing);
        Roll = findViewById(R.id.button);
        bm = findViewById(R.id.ivbm);
        bi = findViewById(R.id.ivbi);
        back = findViewById(R.id.ivback);
        Text = findViewById(R.id.textView2);

        bahasa=getIntent().getStringExtra("bahasa");

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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(),HealingPage.class);
                back.putExtra("bahasa",bahasa);
                startActivity(back);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void explainbi() {
        bahasa = "bi";
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        Text.setText("BI");
        Roll.setText("CLICK TO CHANGE HEALING QUOTE RANDOMLY");
    }

    @SuppressLint("SetTextI18n")
    private void explainbm() {
        bahasa = "bm";
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        Text.setText("BM");
        Roll.setText("KLIK UNTUK UBAH QUOTE HEALING SECARA RAWAK");
    }
}