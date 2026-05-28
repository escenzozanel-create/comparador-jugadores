package com.comparador.jugadores.servicesimp;

import com.comparador.jugadores.dao.IJugadorDao;
import com.comparador.jugadores.entities.Jugador;
import com.comparador.jugadores.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService implements IJugadorService {

    @Autowired
    private IJugadorDao jugadorDao;

    @Override
    public List<String> listarNacionalidades() {
        return jugadorDao.listarNacionalidades();
    }

    @Override
    public List<String> listarPosicionesPorNacionalidad(String nacionalidad) {
        return jugadorDao.listarPosicionesPorNacionalidad(nacionalidad);
    }

    @Override
    public List<Jugador> listarJugadoresPorNacionalidadYPosicion(String nacionalidad, String posicion) {
        return jugadorDao.listarJugadoresPorNacionalidadYPosicion(nacionalidad, posicion);
    }

    @Override
    public Jugador buscarPorId(Long id) {
        return jugadorDao.findById(id).orElse(null);
    }

    @Override
    public Jugador obtenerGanador(Jugador jugador1, Jugador jugador2) {
        if (jugador1.calcularPuntaje() >= jugador2.calcularPuntaje()) {
            return jugador1;
        } else {
            return jugador2;
        }
    }

    @Override
    public Jugador obtenerPerdedor(Jugador jugador1, Jugador jugador2) {
        if (jugador1.calcularPuntaje() < jugador2.calcularPuntaje()) {
            return jugador1;
        } else {
            return jugador2;
        }
    }
}
