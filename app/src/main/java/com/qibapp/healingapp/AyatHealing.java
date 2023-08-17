package com.qibapp.healingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AyatHealing extends AppCompatActivity {
    Button rollButton;
    ImageView bm, bi, back;
    TextView text;
    String bahasa, healingBI = "", healingBM = "",BilHeling = "";
    String[][] quotes = {
            {"1","Quote 1 BI", "Quote 1 BM"},
            {"2","Quote 2 BI", "Quote 2 BM"},
            {"3","Quote 3 BI", "Quote 3 BM"},
            {"4","Quote 4 BI", "Quote 4 BM"},
            {"5","Quote 5 BI", "Quote 5 BM"},
            {"6","Quote 6 BI", "Quote 6 BM"},
            {"7","Quote 7 BI", "Quote 7 BM"},
            {"8","Quote 8 BI", "Quote 8 BM"},
            {"9","Quote 9 BI", "Quote 9 BM"},
            {"10","Quote 10 BI", "Quote 10 BM"},
            {"11","Quote 11 BI", "Quote 11 BM"},
            {"12","Quote 12 BI", "Quote 12 BM"},
            {"13","Quote 13 BI", "Quote 13 BM"},
            {"14","Quote 14 BI", "Quote 14 BM"},
            {"15","Quote 15 BI", "Quote 15 BM"},
            {"16","Quote 16 BI", "Quote 16 BM"},
            {"17","Quote 17 BI", "Quote 17 BM"},
            {"18","Quote 18 BI", "Quote 18 BM"},
            {"19","Quote 19 BI", "Quote 19 BM"},
            {"20","Quote 20 BI", "Quote 20 BM"},
            {"21","Quote 21 BI", "Quote 21 BM"},
            {"22","Quote 22 BI", "Quote 22 BM"},
            {"23","Quote 23 BI", "Quote 23 BM"},
            {"24","Quote 24 BI", "Quote 24 BM"},
            {"25","Quote 25 BI", "Quote 25 BM"},
            {"26","Quote 26 BI", "Quote 26 BM"},
            {"27","Quote 27 BI", "Quote 27 BM"},
            {"28","Quote 28 BI", "Quote 28 BM"},
            {"29","Quote 29 BI", "Quote 29 BM"},
            {"30","Quote 30 BI", "Quote 30 BM"},
            {"31","Quote 31 BI", "Quote 31 BM"},
            {"32","Quote 32 BI", "Quote 32 BM"},
            {"33","Quote 33 BI", "Quote 33 BM"},
            {"34","Quote 34 BI", "Quote 34 BM"},
            {"35","Quote 35 BI", "Quote 35 BM"},
            {"36","Quote 36 BI", "Quote 36 BM"},
            {"37","Quote 37 BI", "Quote 37 BM"},
            {"38","Quote 38 BI", "Quote 38 BM"},
            {"39","Quote 39 BI", "Quote 39 BM"},
            {"40","Quote 40 BI", "Quote 40 BM"},
            {"41","Quote 41 BI", "Quote 41 BM"},
            {"42","Quote 42 BI", "Quote 42 BM"},
            {"43","Quote 43 BI", "Quote 43 BM"},
            {"44","Quote 44 BI", "Quote 44 BM"},
            {"45","Quote 45 BI", "Quote 45 BM"},
            {"46","Quote 46 BI", "Quote 46 BM"},
            {"47","Quote 47 BI", "Quote 47 BM"},
            {"48","Quote 48 BI", "Quote 48 BM"},
            {"49","Quote 49 BI", "Quote 49 BM"},
            {"50","Quote 50 BI", "Quote 50 BM"}
    };
    int bilhealing = quotes.length;
    List<String[]> healingQuotes = new ArrayList<>(Arrays.asList(quotes));
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_healing);

        rollButton = findViewById(R.id.button);
        bm = findViewById(R.id.ivbm);
        bi = findViewById(R.id.ivbi);
        back = findViewById(R.id.ivback);
        text = findViewById(R.id.textView2);

        bahasa = getIntent().getStringExtra("bahasa");

        if (bahasa.equals("bi")) {
            explainBI();
        } else if (bahasa.equals("bm")) {
            explainBM();
        }

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeHealingQuote();
            }
        });

        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainBM();
            }
        });

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                explainBI();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), HealingPage.class);
                back.putExtra("bahasa", bahasa);
                startActivity(back);
            }
        });

        changeHealingQuote();
    }

    private void changeHealingQuote() {
        if (!healingQuotes.isEmpty()) {
            int randomIndex = random.nextInt(healingQuotes.size());
            String[] healingInfo = healingQuotes.get(randomIndex);

            BilHeling = healingInfo[0];
            healingBI = healingInfo[1];
            healingBM = healingInfo[2];
            bilhealing--;

            if (bahasa.equals("bi")) {
                explainBI();
            } else if (bahasa.equals("bm")) {
                explainBM();
            }
            healingQuotes.remove(randomIndex);

            if(bilhealing==0){
                healingQuotes.addAll(Arrays.asList(quotes));
                bilhealing = 50;
            }
        }
        else{
            healingQuotes.addAll(Arrays.asList(quotes));
            bilhealing = 50;
        }
    }

    @SuppressLint("SetTextI18n")
    private void explainBI() {
        bahasa = "bi";
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        text.setText("Healing Quote Number : "+BilHeling+"\n"+healingBI);
        rollButton.setText("CLICK TO CHANGE "+bilhealing+" RANDOMLY HEALING QUOTES");
    }

    @SuppressLint("SetTextI18n")
    private void explainBM() {
        bahasa = "bm";
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        text.setText("Nombor Quotes Healing : "+BilHeling+"\n"+healingBI);
        rollButton.setText("KLIK UNTUK UBAH "+bilhealing+" QUOTE HEALING SECARA RAWAK");
    }
}
