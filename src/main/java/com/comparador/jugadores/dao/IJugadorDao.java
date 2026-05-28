package com.comparador.jugadores.dao;

import com.comparador.jugadores.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJugadorDao extends JpaRepository<Jugador, Long> {

    @Query("select distinct j.nacionalidad from Jugador j order by j.nacionalidad")
    List<String> listarNacionalidades();

    @Query("select distinct j.posicion from Jugador j where j.nacionalidad = ?1 order by j.posicion")
    List<String> listarPosicionesPorNacionalidad(String nacionalidad);

    @Query("select j from Jugador j where j.nacionalidad = ?1 and j.posicion = ?2 order by j.nombre")
    List<Jugador> listarJugadoresPorNacionalidadYPosicion(String nacionalidad, String posicion);
}