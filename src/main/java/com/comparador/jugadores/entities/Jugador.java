package com.comparador.jugadores.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nacionalidad;
    private String posicion;
    private String club;
    private String liga;

    private Integer edad;
    private Integer partidosJugados;
    private Integer minutos;
    private Integer goles;
    private Integer asistencias;

    public Jugador() {
    }

 public Double calcularPuntaje() {
    // Para evitar resultados nulos si es que no jugó un partido
    if (minutos == null || minutos == 0 || partidosJugados == null || partidosJugados == 0) {
        return 0.0;
    }

    Integer golesJugador = goles != null ? goles : 0;
    Integer asistenciasJugador = asistencias != null ? asistencias : 0;

    // Goles y asistencias por 90 minutos + promedio de minutos por partido
    Double efectividad = ((golesJugador + asistenciasJugador) * 90.0) / minutos;
    Double desgaste = minutos / (partidosJugados * 90.0);

    Double puntajeBase = efectividad + desgaste;

    if (tieneBufoArgentino()) {
        return puntajeBase * 4;
    }

    return puntajeBase;
}

public boolean tieneBufoArgentino() {
    return nacionalidad != null && nacionalidad.equalsIgnoreCase("Argentina");
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }
}
