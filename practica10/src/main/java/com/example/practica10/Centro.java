package com.example.practica10;

public class Centro {
    private final String nombre;
    private final String tipo;
    private final String localidad;
    private final int logo;
    private final int imagen;

    public Centro(String nombre, String tipo, String localidad,
                  int logo, int imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.localidad = localidad;
        this.logo = logo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getLogo() {
        return logo;
    }

    public int getImagen() {
        return imagen;
    }
}