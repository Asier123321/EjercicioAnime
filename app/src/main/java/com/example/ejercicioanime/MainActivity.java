package com.example.ejercicioanime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
                    Log.d("Nombre", item.getPersonajes().get(0).getNombre());
//                    Intent intent = new Intent();
//                    startActivity(intent);
                }

            }
        });
    }

    private ArrayList<Anime> crearAnimes()
    {
        ArrayList<Anime> animes = new ArrayList<Anime>();
        animes.add(new Anime("https://static.wikia.nocookie.net/jujutsu-kaisen/images/f/f6/JJK_New_Key_Visual.jpg/revision/latest?cb=20200914020414&path-prefix=es", "Jujutsu Kaisen", crearPersonajes()));
        return animes;

    }

    private ArrayList<Personaje> crearPersonajes()
    {
        ArrayList<Personaje> personajesJujutsu = new ArrayList<Personaje>();
        personajesJujutsu.add(new Personaje("Satoru Goju", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/a/a2/Satoru_Gojo_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201017190313&path-prefix=es"));
        personajesJujutsu.add(new Personaje("Megumi Fushiguro", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/8/83/Megumi_Fushiguro_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201009215353&path-prefix=es"));
        personajesJujutsu.add(new Personaje("Nobara Kugisaki", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/1/1f/Nobara_Kugisaki_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201022190210&path-prefix=es"));
        personajesJujutsu.add(new Personaje("Yuji Itadori", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/6/66/Yuji_Itadori_-_Anime.jpg/revision/latest/scale-to-width-down/350?cb=20201031200040&path-prefix=es"));

        return personajesJujutsu;
    }
}