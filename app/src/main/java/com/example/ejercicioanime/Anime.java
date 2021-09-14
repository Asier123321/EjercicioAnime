package com.example.ejercicioanime;

import java.util.ArrayList;

public class Anime
{
    private String icono, nombre = "";
    private ArrayList<Personaje> personajes = null;

    public Anime(String icono, String nombre, ArrayList<Personaje> personajes)
    {
        this.icono = icono;
        this.nombre = nombre;
        this.personajes = personajes;
    }

    public String getIcono()
    {
        return icono;
    }

    public void setIcono(String icono)
    {
        this.icono = icono;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public ArrayList<Personaje> getPersonajes()
    {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes)
    {
        this.personajes = personajes;
    }
}
