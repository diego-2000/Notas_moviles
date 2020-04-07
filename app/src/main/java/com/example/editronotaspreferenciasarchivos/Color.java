package com.example.editronotaspreferenciasarchivos;

public class Color {
    private String nombre;
    private String hex;

    public Color(String nombre, String hex) {
        this.nombre = nombre;
        this.hex = hex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
