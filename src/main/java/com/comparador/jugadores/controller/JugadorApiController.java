package com.comparador.jugadores.controller;

import com.comparador.jugadores.entities.Jugador;
import com.comparador.jugadores.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JugadorApiController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping("/api/posiciones")
    public List<String> listarPosicionesPorNacionalidad(@RequestParam String nacionalidad) {
        return jugadorService.listarPosicionesPorNacionalidad(nacionalidad);
    }

    @GetMapping("/api/jugadores")
    public List<Jugador> listarJugadoresPorNacionalidadYPosicion(
            @RequestParam String nacionalidad,
            @RequestParam String posicion) {

        return jugadorService.listarJugadoresPorNacionalidadYPosicion(nacionalidad, posicion);
    }
}
