package com.example.ejercicioanime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorAnime extends BaseAdapter
{
    private Context contexto = null;
    ArrayList<Anime> animes = new ArrayList<Anime>();

    public AdaptadorAnime(Context contexto, ArrayList<Anime> animes)
    {
        this.contexto = contexto;
        this.animes = animes;
    }

    @Override
    public int getCount()
    {
        return animes.size() + 1;
    }

    @Override
    public Object getItem(int i)
    {
        return animes.get(i - 1);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = ((Activity) contexto).getLayoutInflater();
        View fila;
        if (i==0)
        {
            fila = inflater.inflate(R.layout.cabecera, null);
        }
        else
        {
            fila = inflater.inflate(R.layout.list_view_anime, null);

            Anime anime = animes.get(i-1);

            ImageView ivImagen = fila.findViewById(R.id.ivImagen);
            Glide.with(contexto).load(anime.getIcono()).centerCrop().into(ivImagen);

            TextView tvNombre = fila.findViewById(R.id.tvNombre);
            tvNombre.setText(anime.getNombre());
        }

        return fila;
    }
}
