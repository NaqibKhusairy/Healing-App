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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AyatHealing extends AppCompatActivity {
    Button rollButton;
    ImageView bm, bi, back;
    TextView text;
    String bahasa,backtoast, healingBI = "", healingBM = "",BilHeling = "";
    String[][] quotes = {
            {"1","Healing takes courage,\n\nand we all have courage\n\neven if we have to dig a little to find it",
                    "Penyembuhan memerlukan keberanian,\n\ndan kita semua mempunyai keberanian\n\nwalaupun kita perlu menggali sedikit untuk mencarinya"},
            {"2","When God Has Decided\nit happened,\nthen that's the best\nfor you to go through.\n\nThe best for God is meaningful\n" +
                    "it's very good and\nwill not happen\nwithout beautiful results.",
                    "Ketika Tuhan Telah Memutuskan\nhal itu Terjadi,\nmaka itulah yang terbaik\nuntuk kamu harungi.\n\n" +
                    "Terbaik bagu Tuhan itu bermakna\nianya sanga baik dan\ntidak akan tejadi\ntanpa natijah yang indah."},
            {"3","Don't be afraid to say\n\"No\" to something you don't want.\n\nNo need to sacrifice\nyour own feelings for\n" +
                    "take care of his heart\n\nYou will not be able to survive\nforever in shame",
                    "Jangan takut untuk berkata\n\"Tidak\" untuk sesuatu yang kamu tidak mahu.\n\nTak perlu mengorbankan\n" +
                    "perasaanmu sendiri demi\nmenjaga hatinya\n\nKamu tak akan mampu bertahan\ndalam kepuraan selamanya"},
            {"4","Quote 4 BI", "Quote 4 BM"}, //nym1
            {"5","Quote 5 BI", "Quote 5 BM"}, //nmy2
            {"6","The soul always knows\nwhat to do to heal itself.\n\nBut the challenge is to \nsilence the mind",
                    "Jiwa sentiasa tahu\napa yang perlu dilakukan untuk menyembuhkan dirinya sendiri.\n\nTapi cabarannya ialah\nmendiamkan fikiran"},
            {"7","Quote 7 BI", "Quote 7 BM"}, //nym2
            {"8","Learn to be silent,\n\nBecause emotions can make us\nlost a lot of things",
                    "Belajarlah untuk berdiam diri,\n\nKerana emosi boleh membuatkan kita\nkehilangan banyak hal"}, //internet
            {"9","Quote 9 BI", "Quote 9 BM"}, //nym1
            {"10","Self-forgiveness is\nessential to self-healing",
                    "Memaafkan diri sendiri adalah\npenting untuk penyembuhan diri"},
            {"11","Quote 11 BI", "Quote 11 BM"}, //nym2
            {"12","Quote 12 BI", "Quote 12 BM"}, //nym1
            {"13","Quote 13 BI", "Quote 13 BM"}, //nym1
            {"14","Although the world is full of suffering,\nit is also full \nof the overcoming of it",
                    "Walaupun dunia penuh dengan penderitaan,\nia juga penuh\ndengan mengatasinya"},
            {"15","Quote 15 BI", "Quote 15 BM"}, //nym2
            {"16","Quote 16 BI", "Quote 16 BM"}, //nym2
            {"17","Quote 17 BI", "Quote 17 BM"}, //nym1
            {"18","Healing is an art.\n\nIt takes time,\nit takes practice and\nIt takes love",
                    "Penyembuhan adalah satu seni.\n\nIa memerlukan masa,\nia memerlukan latihan dan\nia memerlukan cinta"},
            {"19","Quote 19 BI", "Quote 19 BM"}, //nym2
            {"20","Quote 20 BI", "Quote 20 BM"}, //nym1
            {"21","When we heal the earth,\nwe heal ourselves",
                    "Apabila kita menyembuhkan bumi,\nkita sembuhkan diri kita"},
            {"22","Quote 22 BI", "Quote 22 BM"}, //nym1
            {"23","Natural forces within us\nare the true healers\nof disease",
                    "Kekuatan semula jadi dalam diri kita\nadalah penyembuh sebenar penyakit"},
            {"24","Quote 24 BI", "Quote 24 BM"}, //nym2
            {"25","It has been said that time heals all wounds.\nBut the truth is that time does not heal anything.\n\n" +
                    "It merely passes.\n\nIt is what we do during the passing of time\nthat helps or hinders the healing process",
                    "Dikatakan bahawa masa menyembuhkan semua luka.\nTapi hakikatnya masa tidak menyembuhkan apa-apa.\n\n" +
                            "Ia hanya berlalu.\n\nApa yang kita lakukan\nsemasa berlalunya masa yang membantu atau menghalang proses penyembuhan"},
            {"26","Quote 26 BI", "Quote 26 BM"}, //nym2
            {"27","Quote 27 BI", "Quote 27 BM"}, //nym1
            {"28","Quote 28 BI", "Quote 28 BM"}, //nym2
            {"29","Sometimes we look too far into happiness,\n\nAt what others achieve,\nother people have,\nother people do.\n" +
                    "\nEven though happiness is near,\nis in our chest,\nIn a grateful heart",
                    "Kadang kita memandang terlalu jauh tentang kebahagian,\n\nPada apa yang orang lain capai,\norang lain punya,\n" +
                            "orang lain lakukan.\n\nPadahal kebahagian itu dekat,\nada dalam dada kita,\nDalam hati yang bersyukur"},
            {"30","Quote 30 BI", "Quote 30 BM"}, //nym1
            {"31","Quote 31 BI", "Quote 31 BM"}, //nym1
            {"32","Quote 32 BI", "Quote 32 BM"}, //nym2
            {"33","It is not easy to take care of and satisfy everyone's heart.\n\nBut try not to hurt their hearts,\n\n" +
                    "even if your heart is hurt by them.",
                    "Bukan mudah untuk menjaga dan menuasakan hati semua orang.\n\nTapi berusahala agar Tidak menyakiti hati mereka," +
                            "\n\nwalaupon hati kamu disakiti oleh meraka."},
            {"34","Quote 34 BI", "Quote 34 BM"},
            {"35","Quote 35 BI", "Quote 35 BM"}, //nym1
            {"36","Quote 36 BI", "Quote 36 BM"}, //nym2
            {"37","The injury caused by an arrow,\nwill leave scars and heal\n\nA Forest felled by an axe,\nwill grow back.\n" +
                    "\nBut the wounds caused by words,\nIt will remain a deep wound\nand hard to heal",
                    "Luka disebabkan oleh sebatang panah,\nakan meninggalkan bekas dan sembuh\n\n" +
                            "Sebuah Rimba yang dirobohkan oleh kapak,\nakan tumbuh kembali.\n\n" +
                            "Tetapi luka yang disebabkan oleh kata-kata,\nAkan tepap mejadi luka yang dalam\ndan susah untuk sembuh"},
            {"38","Quote 38 BI", "Quote 38 BM"}, //nym2
            {"39","Quote 39 BI", "Quote 39 BM"}, //nym1
            {"40","Quote 40 BI", "Quote 40 BM"}, //nym2
            {"41","Quote 41 BI", "Quote 41 BM"}, //nym1
            {"42","Don't feel wasted\n\nIf you fail\nin survival\n\nAt least,\nYou have tried to fight",
                    "Jangan Merasa sia-sia\n\nJika kamu gagal\ndalam bertahan\n\nSetidaknya,\nKamu pernah Berusaha berjuang"},
            {"43","Quote 43 BI", "Quote 43 BM"}, //nym1
            {"44","Quote 44 BI", "Quote 44 BM"}, //nym2
            {"45","No matter how small the money,\nit is still used by\nsmart people use it\n\n" +
                    "Just like Life,\n\nNo matter how small the service,\nit remains appreciated by\nthe right people appreciate",
                    "Sekecil apapun wangnya,\nia tetap digunakan oleh\norang yang bijak menggunakannya\n\n" +
                            "Sama seperti Kehidupan,\n\nSekecil apapun jasa,\nia tetap dihargai oleh \norang yang betul menghargai"},
            {"46","Quote 46 BI", "Quote 46 BM"}, //nym2
            {"47","When you feel pain\n\nRemember!\n\nThat is a sign that your sins\nis decreasing",
                    "Saat kamu merasakan sakit\n\nIngatlah !\n\nItu pertanda bahawa dosa-dosamu\nmakin berkurang"},
            {"48","Quote 48 BI", "Quote 48 BM"}, //nym1
            {"49","Smile even though the burden feels heavy,\n\nWhatever suffering you are facing now,\n\n" +
                    "Trust me,\nTime will make you understand",
                    "Tersenyumlah walaupun beban itu terasa berat,\n\nWalau apapun derita yang tengah kau hadapi kini,\n\n" +
                            "Percayalah,\nWaktu akan buatmu mengerti"},
            {"50","Quote 50 BI", "Quote 50 BM"}, //nym1
            {"51","Quote 51 BI", "Quote 51 BM"} //nym2
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
                Toast.makeText(getApplicationContext(), backtoast, Toast.LENGTH_SHORT).show();
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
                bilhealing = 51;
            }
        }
        else{
            healingQuotes.addAll(Arrays.asList(quotes));
            bilhealing = 51;
        }
    }

    @SuppressLint("SetTextI18n")
    private void explainBI() {
        bahasa = "bi";
        bi.setVisibility(View.VISIBLE);
        bm.setVisibility(View.GONE);
        text.setText("Healing Quote Number : "+BilHeling+"\n\n"+healingBI);
        rollButton.setText("CLICK TO CHANGE "+bilhealing+" RANDOMLY HEALING QUOTES");
        backtoast = "Healing Quote Reseted";
    }

    @SuppressLint("SetTextI18n")
    private void explainBM() {
        bahasa = "bm";
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        text.setText("Nombor Quotes Healing : "+BilHeling+"\n\n"+healingBM);
        rollButton.setText("KLIK UNTUK UBAH "+bilhealing+" QUOTE HEALING SECARA RAWAK");
        backtoast = "Quote Healing Di Reset";
    }
}
