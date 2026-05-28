package com.comparador.jugadores.service;

import com.comparador.jugadores.entities.Jugador;

import java.util.List;

public interface IJugadorService {

    List<String> listarNacionalidades();

    List<String> listarPosicionesPorNacionalidad(String nacionalidad);

    List<Jugador> listarJugadoresPorNacionalidadYPosicion(String nacionalidad, String posicion);

    Jugador buscarPorId(Long id);

    Jugador obtenerGanador(Jugador jugador1, Jugador jugador2);

    Jugador obtenerPerdedor(Jugador jugador1, Jugador jugador2);
}