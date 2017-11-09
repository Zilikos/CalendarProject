package com.scolari.calendarproject.Model;

/**
 * Created by zilikos on 9/11/17.
 */

public class LeerActividad {

    private String titulo;
    private String Descripcion;
    private Boolean hecho;

    public LeerActividad(String titulo, String descripcion, Boolean hecho) {
        this.titulo = titulo;
        Descripcion = descripcion;
        this.hecho = hecho;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Boolean getHecho() {
        return hecho;
    }

    public void setHecho(Boolean hecho) {
        this.hecho = hecho;
    }
}

