package com.example.ejercicioanime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lvAnimes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAnimes = findViewById(R.id.lvAnime);

        AdaptadorAnime adapter = new AdaptadorAnime(this, crearAnimes());
        lvAnimes.setAdapter(adapter);

        lvAnimes.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Pongo el IF para que no pete al pulsar "ANIME"
                if (i != 0)
                {
                    Anime item = (Anime) adapter.getItem(i);
                    Intent intent = new Intent(getApplicationContext(), PersonajesActivity.class);

                    //Para poder enviar el anime he tenido que hacer un implements Serializable en la clase de Anime y Personaje
                    //(supongo que en la clase de Personaje lo he necesitado porque Anime tiene un ArrayList de Personaje)
                    intent.putExtra("anime", item);
                    startActivity(intent);
                }
            }
        });
    }

    private ArrayList<Anime> crearAnimes()
    {
        ArrayList<Anime> animes = new ArrayList<Anime>();
        animes.add(new Anime("https://static.wikia.nocookie.net/jujutsu-kaisen/images/f/f6/JJK_New_Key_Visual.jpg/revision/latest?cb=20200914020414&path-prefix=es", "Jujutsu Kaisen", crearPersonajes(0)));
        animes.add(new Anime("https://areajugones.sport.es/wp-content/uploads/2020/07/hunter-x-hunter-233.jpg", "Hunter x Hunter", crearPersonajes(1)));
        animes.add(new Anime("https://laverdadnoticias.com/__export/1627498181749/sites/laverdad/img/2021/07/28/haikyuu_temporada_5_anime.jpg_514966513.jpg", "Haikyuu", crearPersonajes(2)));
        animes.add(new Anime("https://larepublica.pe/resizer/I1iNd8TlfjommIaT2UMLKBWHP2E=/1250x735/top/smart/arc-anglerfish-arc2-prod-gruporepublica.s3.amazonaws.com/public/WV6GG4SHGVF37HTQYI2V4ZTZKE.jpg", "Fullmetal Alchemist", crearPersonajes(3)));
        return animes;
    }

    private ArrayList<Personaje> crearPersonajes(int i)
    {
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();

        if (i == 0)
        {
            personajes.add(new Personaje("Satoru Goju", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/a/a2/Satoru_Gojo_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201017190313&path-prefix=es"));
            personajes.add(new Personaje("Megumi Fushiguro", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/8/83/Megumi_Fushiguro_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201009215353&path-prefix=es"));
            personajes.add(new Personaje("Nobara Kugisaki", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/1/1f/Nobara_Kugisaki_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201022190210&path-prefix=es"));
            personajes.add(new Personaje("Yuji Itadori", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/6/66/Yuji_Itadori_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201031200040&path-prefix=es"));
        }

        if (i == 1)
        {
            personajes.add(new Personaje("Hisoka Morow", "https://static.wikia.nocookie.net/hunterxhunter/images/6/67/Hisoka_PR_Movie.png/revision/latest/scale-to-width-down/195?cb=20130530145606&path-prefix=es"));
            personajes.add(new Personaje("Killua Zoldyck", "https://static.wikia.nocookie.net/hunterxhunter/images/7/7c/Killua-2011.png/revision/latest/scale-to-width-down/190?cb=20121113132331&path-prefix=es"));
            personajes.add(new Personaje("Gon Freecss", "https://static.wikia.nocookie.net/hunterxhunter/images/b/b4/Gon-2011.png/revision/latest/scale-to-width-down/204?cb=20130530222837&path-prefix=es"));
            personajes.add(new Personaje("Kurapika", "https://static.wikia.nocookie.net/hunterxhunter/images/2/25/Kurapika-2011.png/revision/latest/scale-to-width-down/186?cb=20130530225248&path-prefix=es"));
        }

        if (i == 2)
        {
            personajes.add(new Personaje("Shoyo Hinata", "https://static.wikia.nocookie.net/haikyuu/images/8/8c/Shoyo_Competitivo.png/revision/latest/scale-to-width-down/350?cb=20201031221416&path-prefix=es"));
            personajes.add(new Personaje("Kenma Kozume", "https://static.wikia.nocookie.net/haikyuu/images/b/bc/Kenma_Calmado.png/revision/latest/scale-to-width-down/350?cb=20201101002244&path-prefix=es"));
            personajes.add(new Personaje("Kotaro Bokuto", "https://static.wikia.nocookie.net/haikyuu/images/0/0a/Bokutottp.jpg/revision/latest/scale-to-width-down/350?cb=20200528072309&path-prefix=es"));
            personajes.add(new Personaje("Tobio Kageyama", "https://static.wikia.nocookie.net/haikyuu/images/3/34/Kageyama_2_%28S4%29.png/revision/latest/scale-to-width-down/350?cb=20200113224202&path-prefix=es"));
        }

        if (i == 3)
        {
            personajes.add(new Personaje("Alphonse Elric", "https://static.wikia.nocookie.net/fma/images/f/f6/AlphonseElricEp7.png/revision/latest/scale-to-width-down/350?cb=20190709035140&path-prefix=es"));
            personajes.add(new Personaje("Edward Elric", "https://static.wikia.nocookie.net/fma/images/a/a4/EDOWADO-S.jpg/revision/latest/scale-to-width-down/350?cb=20190508204433&path-prefix=es"));
            personajes.add(new Personaje("Van Hohenheim", "https://static.wikia.nocookie.net/fma/images/9/92/Hoho1.png/revision/latest/scale-to-width-down/350?cb=20140105204621&path-prefix=es"));
            personajes.add(new Personaje("Solf J. Kimblee", "https://static.wikia.nocookie.net/fma/images/1/16/Solf_J._Kimblee.png/revision/latest/scale-to-width-down/350?cb=20150106165906&path-prefix=es"));
        }

        return personajes;
    }
}