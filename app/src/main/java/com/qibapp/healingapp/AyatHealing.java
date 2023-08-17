package com.qibapp.healingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
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
    MediaPlayer mediaPlayer;
    String bahasa,backtoast,resettoast, healingBI = "", healingBM = "",  BilHeling = "";
    String[][] quotes = {
            {"1","Healing takes courage,\n\nand we all have courage\n\neven if we have to dig a little to find it",
                    "Penyembuhan memerlukan keberanian,\n\ndan kita semua mempunyai keberanian\n\nwalaupun kita perlu menggali sedikit untuk mencarinya"},
            {"2","When God Has Decided\nit happened,\nthen that's the best\nfor you to go through.\n\nThe best for God is meaningful\n" +
                    "it's very good and\nwill not happen\nwithout beautiful results.", "Ketika Tuhan Telah Memutuskan\nhal itu Terjadi,\nmaka itulah yang terbaik\nuntuk kamu harungi.\n\n" +
                    "Terbaik bagu Tuhan itu bermakna\nianya sanga baik dan\ntidak akan tejadi\ntanpa natijah yang indah."},
            {"3","Don't be afraid to say\n\"No\" to something you don't want.\n\nNo need to sacrifice\nyour own feelings for\n" +
                    "take care of his heart\n\nYou will not be able to survive\nforever in shame",
                    "Jangan takut untuk berkata\n\"Tidak\" untuk sesuatu yang kamu tidak mahu.\n\nTak perlu mengorbankan\n" +
                    "perasaanmu sendiri demi\nmenjaga hatinya\n\nKamu tak akan mampu bertahan\ndalam kepuraan selamanya"},
            {"4","Maybe no one understands\n\nNo one knows\n\nNo one goes through with you.\n\nBut the same God takes care of you\n" +
                    "since in your mother's womb too\ntake care of you until now\n\nYou are not alone,\nGod is always there on every side.",
                    "Mungkin tiada siapa yang mengerti\n\nTiada yang tahu\n\nTiada yang lalui bersamamu.\n\nTapi Tuhan yang sama menjagamu\n" +
                    "sejak di dalam rahim ibumu juga\nmenjaga kamu sehingga saat ini\n\nKamu tidak sendiri,\nTuhan tetap ada di setiap sisi."},
            {"5","You can cry too\nDon't be held back by that mistake.\n\nyou are just a man\nwho has a day\nYou feel sad too\n" +
                    "when in the lowest phase\nin your life\n\nIt's okay if it's crying\nlet go of what is open\nand grow what is planted.",
                    "Kamu juga boleh menangis\nJangan ditahan hiba itu.\n\nkamu itu cuma lelaki\nyang punya hari.\n" +
                    "kau juga merasakan duka\ntatkala berada di fasa terendah\ndalam hidupmu.\n\nTak mengapa jika tangisan itu\n" +
                    "melepaskan apa yang terbukam\ndan menumbuhkan apa yang tertanam."},
            {"6","The soul always knows\nwhat to do to heal itself.\n\nBut the challenge is to \nsilence the mind",
                    "Jiwa sentiasa tahu\napa yang perlu dilakukan untuk menyembuhkan dirinya sendiri.\n\nTapi cabarannya ialah\nmendiamkan fikiran"},
            {"7","What comes can go\nthose who go can come back\n\nButterflies leave cocoons\nBirds return to the nest\n\n" +
                    "Make sure you are ready\nface all odds\nin your life so that you don't\ntoo sick to get through the day.",
                    "Yang datang boleh pergi\nyang pergi boleh datang kembali\n\nRama-rama tinggalkan kepompong\nBurung pula pulang ke sarang\n" +
                    "\nPastikan kamu bersedia\nberhadapan segala kemungkinan\ndalam hidupmu agar kamu tidak\nterlalu sakit melalui hari itu."},
            {"8","Learn to be silent,\n\nBecause emotions can make us\nlost a lot of things",
                    "Belajarlah untuk berdiam diri,\n\nKerana emosi boleh membuatkan kita\nkehilangan banyak hal"},
            {"9","A valuable gift\ndoesn't necessarily have to be beautifully wrapped\nwithin it there is something\nprecious and meaningful.\n" +
                    "\nSometimes that precious gift\nGod wraps it inside\nproblems, suspicions and tests.\n\nBut inside it is full of\n" +
                    "God's blessings and love\to His servants",
                    "Hadiah yang bernilai itu\ntidak semestinya harus dibungkus indah\nyang di dalamnya terdapat sesuatu\nyang berharga dan bermakna.\n" +
                            "\nTerkadang hadiah bernilai itu\nTuhan bungkuskan di dalamnya\nmasalah, dugaan dan ujian.\n\nTetapi di dalamnya penuh dengan\n" +
                            "barakah dan kasih sayang Tuhan\nkepada hamba-Nya"},
            {"10","Self-forgiveness is\nessential to self-healing",
                    "Memaafkan diri sendiri adalah\npenting untuk penyembuhan diri"},
            {"11","Maybe there will be someone present\nin your life\nthen left without an answer\njust keep silent\n\n" +
                    "What else are you waiting for?\nyou don't have to hurt yourself\nby waiting for the answer.\n\nHe doesn't care\n" +
                    "He is worried about your heart\nthen for what\nare you still there?\n\nDon't hurt yourself anymore\nby waiting\n" +
                    "You need to cut high\nI'm sure your wound will dry up later",
                    "Mungkin akan ada yang hadir\ndalam hidupmu\nlalu pergi tanpa jawapan\nhanya diam membisu\n\n" +
                    "Apa lagi yang kamu tunggu?\nkamu tak perlu menyakiti dirimu\ndengan menunggu jawapannya.\n\n" +
                    "Dia tidak peduli\nDia ridak kesah soaln hatimu\nlalu untuk apa\nmasih lagi kamu disitu?\n\n" +
                    "Jangan sakiti dirimu lagi\ndengan menanti\nKamu perlu tebang tinggi\npasti lukamu akan kering nanti"},
            {"12","\"Overthingking\"\nthat can destroy\nfriendship,\nrelationship\nand even destroy yourself.\n\n" +
                    "Stop listening to what is being said\nby your imagination.\n\n" +
                    "It told you\nfalse things\then why do you know?",
                    "\"Overthingking\"\nitu mampu menghancurkan\npeesahabatan,\nperhubungan\ndan malah menghancurkan dirimu sendiri.\n" +
                            "\nBerhenti mendengar apa yang dikatakan\noleh imaginasimu.\n\n" +
                            "Dia memberi tahu kamu\nperkara yang palsu\nlalu untuk apa kamu ambil tahu?"},
            {"13","Where possible\ndestiny will change.\n\nMore like a mate, right?\n\nif is your destiny\n" +
                    "surely you and he will become one.\n\nIf  just a stopover for you,\n" +
                    "the road will split in two\nno matter how hard you try\nto put it together.",
                    "Mana mungkin\nnamanya takdir itu akan tertukar.\n\nLebih lagi soal jodoh, kan?\n\njika dia takdirmu\n" +
                            "pasti kamu dan dia menjadi satu.\n\nJika dia hanya persinggahan untukmu,\n" +
                            "jalan akan terbahagi dua\nwalau sekuat apa pun usaha\nuntuk menyatukannya."},
            {"14","Although the world is full of suffering,\nit is also full \nof the overcoming of it",
                    "Walaupun dunia penuh dengan penderitaan,\nia juga penuh\ndengan mengatasinya"},
            {"15","You and him are just friends\n\nDon't you dare get your hopes up\nif you don't want to be broken.\n\nBetter to be aware\nfrom shock itself.",
                    "Kamu dan dia cuma berkawan\n\nJangan berani menaruh harapan\njika tidak mahu dipatahkan.\n\nLebih baik sedar diri\ndaripada syok sendiri."},
            {"16","Live, goes on.\n\nYour life does not stop\nduring the storm.\n\nLearn to be sincere\nyour every destiny because of the sincere\n" +
                    "will always win defeat\nthe desire to give up your Lord's fast.",
                    "Hidup, terus berjalan.\n\nHidupmu tidak terhenti\nketika badai.\n\nBelajarlah mengikhlaskan\nsetiap tekdirmu kerana yang ikhlas\n" +
                            "akan sentiasa menang menewaskan\nkeinginan berputus asa pasa Tuhanmu."},
            {"17","Do you feel\nyou are alone\nafter what you have been through?\n\nSo far you have managed to survive\none by one problems in front of you.\n" +
                    "\nSurely your strength is present because\nGod is with you.",
                    "Apakah kamu merasakan\nkamu bersendirian\nsetelah apa yang telah kamu lalui ?\n\nSejauh ini kamu berjaya harungi\n" +
                            "satu per satu masalah di hadapanmu.\n\nPastinya kekuatanmu itu hadir kerana\nadanya Tuhan bersamamu."},
            {"18","Healing is an art.\n\nIt takes time,\nit takes practice and\nIt takes love",
                    "Penyembuhan adalah satu seni.\n\nIa memerlukan masa,\nia memerlukan latihan dan\nia memerlukan cinta"},
            {"19","Among the hardest things is\ndeny your own feelings\n\nyou are missing\n\nBut you deny that feeling\n" +
                    "because you are aware of missing you\nwill not be welcomed again like before",
                    "Antara hal terberat itu adalah\nmendustakan perasaamu sendiri\n\nKamu sedang rindu,\n\nTapi kamu menafikan rasa itu\n" +
                    "kerana kamu sedar rindu kamu itu\ntidak akan disambut lagi seperti dulu"},
            {"20","I once fell in the dark,\nthen I started\nis calmness.\n\nWhere can I find it?\nbecause the calmness is present\n" +
                    "by loving God.\n\nThat's right,\nloving God is not an option\nbut duty",
                    "Aku pernah jatuh dalam kegelapan,\nlalu yang aku mulakan\nadalah ketenangan.\n\nMana mungkin aku akan temukan\n" +
                            "kerana ketenangan itu hadir\ndengan mencintai Tuhan.\n\nBenarlah,\n" +
                            "mencintai Tuhan bukan pilihan\ntapi kewajipan"},
            {"21","When we heal the earth,\nwe heal ourselves",
                    "Apabila kita menyembuhkan bumi,\nkita sembuhkan diri kita"},
            {"22","Makes a revelation\nas a guide is a claim\nnot an option.\n\nWhatever you are looking for\neverything is in godly life.\n\n" +
                    "Seek God,\nsurely the best will find you.",
                    "Menjadikan petunjuk wahyu\nsebagai panduan adalah tuntutan\nbukan pilihan.\n\nApa saja yang kamu cari\nsegala ada di dalam hidup bertuhan.\n" +
                            "\nCarilah Tuhan,\npasti yang terbaik akan mencarimu."},
            {"23","Natural forces within us\nare the true healers\nof disease",
                    "Kekuatan semula jadi dalam diri kita\nadalah penyembuh sebenar penyakit"},
            {"24","To clarify\nthe water should continue to flow.\n\nSo is life\nwhich should continue even if the obstacle kills hope\n\n" +
                    "Keep going\n\nBecause happiness is always waiting for you ahead.",
                    "Untuk menjernihkan\nair itu harus terus mengalir.\n\nBegitu juga kehidupan\nyang seharusnya diteruskan meskipun halangan itu mematikan harapan\n\n" +
                            "Teruslah berjalan\n\nKerana bahagia sentiasa menunggumu di hadapan."},
            {"25","It has been said that time heals all wounds.\nBut the truth is that time does not heal anything.\n\n" +
                    "It merely passes.\n\nIt is what we do during the passing of time\nthat helps or hinders the healing process",
                    "Dikatakan bahawa masa menyembuhkan semua luka.\nTapi hakikatnya masa tidak menyembuhkan apa-apa.\n\n" +
                            "Ia hanya berlalu.\n\nApa yang kita lakukan\nsemasa berlalunya masa yang membantu atau menghalang proses penyembuhan"},
            {"26","because of you\nnot grateful to have it\nGod will take it\nthat's good from you.\n\nBecause that's good\ndeserve\n" +
                    "better than you\n\nGod will replace you\nwith someone good\nalso for him",
                    "kerana kamu \ntidak bersyukur memilikinya\nTuhan akan ambil\nyang baik itu daripada kamu.\n\nKerana yang baik itu\n" +
                    "layak mendapat\nyang lebih baik dari kamu.\n\nTuhan akan menggantikan kamu\ndengan seseorang yang baik\njuga untuknya"},
            {"27","Be patient in patience.\n\nBecause of that patience\nrequires struggle.\n\nIf needed,\n\nCry in the struggle\n" +
                    "to increase your fighting strength.\n\nMake sure you succeed . Ok?",
                    "Sabarlah di dalam sabar.\n\nKerana sabar itu\nmemerlukan perjuangan.\n\nJika perlu,\n\n" +
                            "Menangislah dalam perjuangan itu\nuntuk menambahkan kekuatan juangmu.\n\nPastikan kamu berjaya, ya?"},
            {"28","Among the impossible things\nis persuading the heart\nhas bargained\n\nThey won't listen to your sorry.\n" +
                    "\nYour voice used to be like music\nwhich is beautiful in the halwa of his ears.\n\nNow, not only voice,\n" +
                    "they just don't want to hear your name.",
                    "Antara perkara yang mustahil\nadalah memujuk hati yang\ntelah tawar\n\nKata maafmu tidak akn lagi didengarinya.\n" +
                    "\nDahulu suaramu bagaikan muzik\nyang indah di halwa telinganya.\n\n" +
                    "Kini, jangankan suara,\nnamamu saja dia tidak mahu dengari."},
            {"29","Sometimes we look too far into happiness,\n\nAt what others achieve,\nother people have,\nother people do.\n" +
                    "\nEven though happiness is near,\nis in our chest,\nIn a grateful heart",
                    "Kadang kita memandang terlalu jauh tentang kebahagian,\n\nPada apa yang orang lain capai,\norang lain punya,\n" +
                            "orang lain lakukan.\n\nPadahal kebahagian itu dekat,\nada dalam dada kita,\nDalam hati yang bersyukur"},
            {"30","This life has many episodes.\nSometimes you are broken.\nSometimes you get\nluck.\n\nNot all\nwhat you plan is in line\n" +
                    "but that is not well planned\nruns well and perfectly.\n\nSuch is life.\nLearn not to put up\nhigh \"expectations\".\n" +
                    "against something you are chasing.\n\nSurrender everything to Him\nafter you try\nYou will be calm,\nas calm as a flower garden.",
                    "Hidup ini punya pelbagai episod.\nTerkadang kamu dipatahkan.\nTerkadang kamu mendapat\nkeberuntungan.\n\nTidak semua\nyang kamu rancang itu sejalan\n" +
                            "tapi yang tidak dirancang dengan baik itu\nberjalan dengan baik dan sempurna.\n\nBegitulah kehidupan.\nBelajarlah untuk tidak meletakan\n" +
                            "\"expectation\" yang tinggi\ntehadap sesuatu yang kamu kejar.\n\nSerahkan segalanya pada-Nya\nsetelah kamu mencuba.\n" +
                            "Kamu akan tenang,\nsetenang taman bunga."},
            {"31","you are not allowed to be happy\nnot because you don't deserve it,\nbut because the time has not yet come.\n\nNot much longer\n" +
                    "your happiness will exist\nto make a smile\nand heal wounds.",
                    "kamu tidak diizinkan bahagia\nbukan kerana kamu tidak layak,\ntapi kerana waktunya belum tiba.\n\nTidak lama lagi\n" +
                            "bahagiamu itu akan wujud\nuntuk mengukir senyuman\ndan mengubati luka."},
            {"32","Hoping for something\nwhich is unlikely to be\nbest way to do\nyour heart.\n\nKeep it simple\nso that you don't lose yourself.",
                    "Mengharapkan sesuatu\nyang tidak mengkin adalah\ncara terbaik untuk melakukan\nhatimu.\n\nBersederhanalah\nagar kamu tidak hilang dirimu."},
            {"33","It is not easy to take care of and satisfy everyone's heart.\n\nBut try not to hurt their hearts,\n\n" +
                    "even if your heart is hurt by them.",
                    "Bukan mudah untuk menjaga dan menuasakan hati semua orang.\n\nTapi berusahala agar Tidak menyakiti hati mereka," +
                            "\n\nwalaupon hati kamu disakiti oleh meraka."},
            {"34","Simple is happiness\nsimple is always\nsave you\n\nIf you hope. don't overdo it.\nIf you love, don't reach\nyou are forgotten\n" +
                    "\nIf you like it, don't forget it\nhe is also a human being with flaws\n\nBe simple if you want to be happy.",
                    "Sederhana itu bahagia\nsederhana itu setiasa\nmenyelamatkan kamu.\n\nJika berharap. jangan berlebihan.\nJika mencintai, jangan sampai\n" +
                            "dirimu dilupakan.\n\nJika suka, jangan sampai lupa\ndia juga manusia ada kekurangan\n\nBesederhanalah jika mahu bahagia."},
            {"35","lift your head,\nlook ahead and keep going.\n\nDon't make it a bad day\nreason for you to stop chasing\na good life.",
                    "Angkat kepalamu,\npandang kehadapan dan terus berjalan.\n\nJangan jadikan hari yang buruk itu\n" +
                            "alasan unutk kamu berhenti mengejar\nkehidupan yang baik."},
            {"36","You can't force it\nall to like you\nWhile you too\ndon't like it at all, right?\n\nIt's not fair to expect that.\n\n" +
                    "Remember, no matter how good you are,\nwill definitely exist\nwho do not like,\nthe pretender and the sincere one.",
                    "Kamu tak boleh paksa\nsemua untuk sukakan kamu.\nSedangkan kamu juga\ntidak suka pada semua, kan?\n\n" +
                    "Tidak adil untuk mengharapkan perkara itu.\n\nIngat, sebaik apa pun kamu, \npasti akan wujud\n" +
                    "yang tidak menyukai,\nyang berpura dan yang ikhlas."},
            {"37","The injury caused by an arrow,\nwill leave scars and heal\n\nA Forest felled by an axe,\nwill grow back.\n" +
                    "\nBut the wounds caused by words,\nIt will remain a deep wound\nand hard to heal",
                    "Luka disebabkan oleh sebatang panah,\nakan meninggalkan bekas dan sembuh\n\n" +
                            "Sebuah Rimba yang dirobohkan oleh kapak,\nakan tumbuh kembali.\n\n" +
                            "Tetapi luka yang disebabkan oleh kata-kata,\nAkan tepap mejadi luka yang dalam\ndan susah untuk sembuh"},
            {"38","If you make a mistake in choosing,\nwhere is it possible that God will\nlet you go on like that.\n\nThe reason why\n" +
                    "your hopes are not fulfilled,\n\nwhy him and you\nnot being one is\nfor the protection of your Lord\n" +
                    "from something wrong\nin your life\n\nYou should be grateful\nabove that statement.",
                    "Jika kamu salah dalam memilih,\nmana mungkin Allah akan\nmembiarkan kamu terus begitu.\n\nAlasan kenapa\nharapanmu tidak tertunai,\n" +
                            "\nkenapa dia dan kamu\ntidak menjadi satu adalah\nkerana perlindungan Tuhanmu\ndaripada sesuatu yang salah\ndalam hidupmu.\n" +
                            "\nKamu sepatutnya bersyukur\ndiatas kenyataan itu."},
            {"39","Countless already\nhow many times your name is called\nin my prayers and moans.\n\nTruly you are my appeal\n" +
                    "to my god\nfor you to be my destiny",
                    "Sudah tidak terkira\nberapa kali namamu disebut\ndidalam doa dan rintihanku.\n\nSungguh kamu adalah rayuanku\n" +
                            "kepada tuhan ku\nagar kamu menjadi takdirku"},
            {"40","Your lament will not\nchange anything but\nYour heart condition will get worse\nafter swallowing too much grief.\n\n" +
                    "nothing will change\nbecause of your crying\n\nThe fate has happened.\nyou just need to find a place\n" +
                    "the right one to shelter\nfor the healing process to happen.\n\nWith God, you will be healed.",
                    "Ratapanmu tidak akan\nmengubah apa-apa melainkan\nkondisi hatimu akan semakin buruk\nsetelah menelan terlalu banyak kesedihan.\n\n" +
                            "Tiada apa yang akan berubah\nkerana tengisanmu.\n\nTakdir itu telah berlaku.\nkamu cuma perlu cari tempat\n" +
                            "yang betul untuk berteduh\nagar proses sembuh itu tejadi.\n\nDengan Allah, kamu akan sembuh."},
            {"41","If you miss,\npray for me\n\nMaybe the prayer\nwill make me happy\nwith my new way\n\nDon't look for me anymore,\n" +
                    "because we cannot possibly be one.\n\nI also pray\nfor you to be happy together\nyour new choice.",
                    "Jika kamu rindi,\ndoakan aku.\n\nMungkin doa itu\nakan membahagiakan aku\ndengan jalan baruku.\n\nJangan lagi cari aku,\n" +
                            "kerana kita tidak mungkin menjadi satu.\n\nAku juga mendoakan\nagar kamu bahagia bersama\npilihan barumu."},
            {"42","Don't feel wasted\n\nIf you fail\nin survival\n\nAt least,\nYou have tried to fight",
                    "Jangan Merasa sia-sia\n\nJika kamu gagal\ndalam bertahan\n\nSetidaknya,\nKamu pernah Berusaha berjuang"},
            {"43","His presence can still be felt\nThe feeling is gripping.\n\nIndescribable pain.\n\nBut I have to mature\nin going through life.\n\n" +
                    "who left,\nwill still go\n\nAt least,\nI can still walk again.\nHope to be able to stand tomorrow.",
                    "Hadirnya masih dapat dirasakan\nRasa iru mencengkam.\n\nSakit yang tak dapat digambarkan.\n\nNamun aku harus matang\n" +
                            "dalam menjalanu kehidupan.\n\nYang pergi,\ntetap akan pergi\n\nSetidaknya,\naku masih mampu berjalan lagi.\nSemoga esok mampu berdiri."},
            {"44","He was just too tired.\nThat's why he decided\nto go.\n\nOnly by road\n" +
                    "allow him to rest\nfrom everything that tired him.",
                    "Dia cuma terlalu penat.\nKerana itu dia memutuskan\nuntuk pergi.\n\nHanya dengan jalan pergi sahaja\n" +
                            "membolehkan dia berehat\ndari segala yang memenatkannya."},
            {"45","No matter how small the money,\nit is still used by\nsmart people use it\n\n" +
                    "Just like Life,\n\nNo matter how small the service,\nit remains appreciated by\nthe right people appreciate",
                    "Sekecil apapun wangnya,\nia tetap digunakan oleh\norang yang bijak menggunakannya\n\n" +
                            "Sama seperti Kehidupan,\n\nSekecil apapun jasa,\nia tetap dihargai oleh \norang yang betul menghargai"},
            {"46","Your lament will not\nchange anything but\nYour heart condition will get worse\nafter swallowing too much grief.\n\n" +
                    "nothing will change\nbecause of your crying\n\nThe fate has happened.\nyou just need to find a place\nthe right one to shelter\n" +
                    "for the healing process to happen.\n\nWith God, you will be healed",
                    "Ratapanmu tidak akan\nmengubah apa-apa melainkan\nkondisi hatimu akan semakin buruk\nsetelah menelan terlalu banyak kesedihan.\n\n" +
                            "Tiada apa yang akan berubah\nkerana tengisanmu.\n\nTakdir itu telah berlaku.\nkamu cuma perlu cari tempat\n" +
                            "yang betul untuk berteduh\nagar proses sembuh itu tejadi.\n\nDengan Allah, kamu akan sembuh"},
            {"47","When you feel pain\n\nRemember!\n\nThat is a sign that your sins\nis decreasing",
                    "Saat kamu merasakan sakit\n\nIngatlah !\n\nItu pertanda bahawa dosa-dosamu\nmakin berkurang"},
            {"48","If patience is an object\nand can be seen with the eyes\nsurely many will be surprised to see that patience.\n\n" +
                    "Your patience is not in vain\n\nThere must be a reward.\n\nIf not in the world, in heaven.",
                    "Jika sabar itu merupakan objek\ndan boleh nampak dengan mata\npasti ramai akan terkejut melihat sabar itu.\n\n" +
                            "Sungguh sabarmu itu tidak sia-sia\n\nPasti ada ganjarannya.\n\nJika tidak di dunia, di syurga."},
            {"49","Smile even though the burden feels heavy,\n\nWhatever suffering you are facing now,\n\n" +
                    "Trust me,\nTime will make you understand",
                    "Tersenyumlah walaupun beban itu terasa berat,\n\nWalau apapun derita yang tengah kau hadapi kini,\n\n" +
                            "Percayalah,\nWaktu akan buatmu mengerti"},
            {"50","Life is too short\nto waste with tears\nand solutions.\n\nEnjoy this life\n" +
                    "follow your heart as long as possible\nGod's law is your priority.\n\nKeep breathing and living.",
                    "Hidup ini terlalu singkat\nuntuk dibazirkan dengan tangisan\ndan penyelesaian.\n\nNikmatilah kehidupan ini\n" +
                            "mengikut kata hatimu selagi mana\nsyariat Tuhan menjadi keutamaanmu.\n\nTeruslah bernafas dan hiduplah."},
            {"51","Just choose what makes you calm.\n\nThe decision can be decisive\nhow happy you are",
                    "Pilih saja apa yang menenangkanmu.\n\nKepututsan itu boleh menentukan\nsebesar apa bahagiamu"}
    };
    int bilhealing = quotes.length;
    List<String[]> healingQuotes = new ArrayList<>(Arrays.asList(quotes));
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_healing);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

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
                if(bilhealing==0||bilhealing==51){
                    Toast.makeText(getApplicationContext(), resettoast, Toast.LENGTH_SHORT).show();
                }
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

    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
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
        text.setText("\n\nHealing Quote Number : "+BilHeling+"\n\n"+healingBI);
        if(BilHeling.equals("11")){
            text.setText("\n\n\n\n\n\n\nHealing Quote Number : "+BilHeling+"\n\n"+healingBI);
        }
        if(bilhealing!=0){
            rollButton.setText("CLICK TO CHANGE "+bilhealing+" RANDOMLY HEALING QUOTES");
        }
        if(bilhealing==0 || bilhealing ==51){
            rollButton.setText("YOUR HEALING QUOTES REMAIN 0\nCLICK TO RESET YOUR HEALING QUOTES");
            resettoast = "Healing Quote Reseted";
        }
        backtoast = "Healing Quote Reseted";
    }

    @SuppressLint("SetTextI18n")
    private void explainBM() {
        bahasa = "bm";
        bi.setVisibility(View.GONE);
        bm.setVisibility(View.VISIBLE);
        text.setText("\n\nNombor Quotes Healing : "+BilHeling+"\n\n"+healingBM);
        if(BilHeling.equals("30")){
            text.setText("\n\n\n\n\n\n\nNombor Quotes Healing : "+BilHeling+"\n\n"+healingBM);
        }
        if(bilhealing!=0){
            rollButton.setText("KLIK UNTUK UBAH "+bilhealing+" QUOTE HEALING SECARA RAWAK");
        }
        if(bilhealing==0 || bilhealing ==51){
            rollButton.setText("QUOTES HEALING ANDA TINGGAL 0\nKLIK UNTUK RESET QUOTES HEALING ANDA");
            resettoast = "Quote Healing Di Reset";
        }
        backtoast = "Quote Healing Di Reset";
    }
}
