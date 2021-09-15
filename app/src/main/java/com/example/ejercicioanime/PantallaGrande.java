package com.example.ejercicioanime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PantallaGrande extends AppCompatActivity
{
    private Personaje personaje = null;
    private ImageView ivFotoPersonaje = null;
    private TextView tvNombrePersonaje = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_grande);

        personaje = (Personaje) getIntent().getSerializableExtra("personaje");

        ivFotoPersonaje = findViewById(R.id.ivFotoPersonaje);
        Glide.with(this).load(personaje.getImagen()).into(ivFotoPersonaje);

        tvNombrePersonaje = findViewById(R.id.tvNombrePersonaje);
        tvNombrePersonaje.setText(personaje.getNombre());
    }
}