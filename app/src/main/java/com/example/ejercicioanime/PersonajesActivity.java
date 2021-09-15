package com.example.ejercicioanime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonajesActivity extends AppCompatActivity
{
    private GridView gvPersonajes = null;
    private Anime anime = null;
    private TextView tvPersonajesTitulo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        anime = (Anime) getIntent().getSerializableExtra("anime");
        ArrayList<Personaje> personajes = anime.getPersonajes();

        tvPersonajesTitulo = findViewById(R.id.tvPersonajesTitulo);
        tvPersonajesTitulo.setText(tvPersonajesTitulo.getText() + anime.getNombre());

        gvPersonajes = findViewById(R.id.gvPersonajes);
        gvPersonajes.setAdapter(new GripAdapter(getApplicationContext(), personajes));

        gvPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getApplicationContext(), PantallaGrande.class);
                intent.putExtra("personaje", personajes.get(i));
                startActivity(intent);
            }
        });
    }
}