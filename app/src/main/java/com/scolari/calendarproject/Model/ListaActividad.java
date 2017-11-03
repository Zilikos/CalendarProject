package com.scolari.calendarproject.Model;

/**
 * Created by zilikos on 15/10/17.
 */

public class ListaActividad {

    private String materia;
    private String tareaName;
    private String description;
    private String fecha;
    private String horario;

    public ListaActividad() {
    }

    public ListaActividad(String materia, String tareaName, String description, String fecha, String horario) {
        this.materia = materia;
        this.tareaName = tareaName;
        this.description = description;
        this.fecha = fecha;
        this.horario = horario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTareaName() {
        return tareaName;
    }

    public void setTareaName(String tareaName) {
        this.tareaName = tareaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
