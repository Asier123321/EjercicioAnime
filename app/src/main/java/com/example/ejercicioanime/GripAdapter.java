package com.example.ejercicioanime;

import android.app.Person;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GripAdapter extends BaseAdapter
{
    private Context context = null;
    private ArrayList<Personaje> personajes = null;

    public GripAdapter(Context context, ArrayList<Personaje> personajes)
    {
        this.context = context;
        this.personajes = personajes;
    }

    @Override
    public int getCount()
    {
        return personajes.size();
    }

    @Override
    public Object getItem(int i)
    {
        return personajes.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View vistaImagen = inflater.inflate(R.layout.grid_diseno, viewGroup, false);
        ImageView imagen = vistaImagen.findViewById(R.id.ivImagenPersonaje);
        Glide.with(context).load(this.personajes.get(i).getImagen()).into(imagen);

        return vistaImagen;
    }
}
