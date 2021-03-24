package com.example.grupo2_los_numbe_rone;

public class Pais {
    private int image;
    private String nombre;

    public Pais(){
    }

    public Pais(int image, String nombre) {
        this.image = image;
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
