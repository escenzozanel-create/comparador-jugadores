package com.comparador.jugadores.controller;

import com.comparador.jugadores.entities.Jugador;
import com.comparador.jugadores.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JugadorController {

    @Autowired
    private IJugadorService jugadorService;

    @GetMapping("/")
    public String inicio() {
        return "redirect:/comparar";
    }

    @GetMapping("/comparar")
    public String mostrarComparador(Model model) {
        model.addAttribute("nacionalidades", jugadorService.listarNacionalidades());
        return "comparar";
    }

    @PostMapping("/resultado")
    public String mostrarResultado(Long jugador1Id, Long jugador2Id, Model model) {

        Jugador jugador1 = jugadorService.buscarPorId(jugador1Id);
        Jugador jugador2 = jugadorService.buscarPorId(jugador2Id);

        if (jugador1 == null || jugador2 == null) {
            model.addAttribute("error", "Debe seleccionar dos jugadores válidos.");
            model.addAttribute("nacionalidades", jugadorService.listarNacionalidades());
            return "comparar";
        }

        if (jugador1.getId().equals(jugador2.getId())) {
            model.addAttribute("error", "No puede comparar el mismo jugador dos veces.");
            model.addAttribute("nacionalidades", jugadorService.listarNacionalidades());
            return "comparar";
        }

        Jugador ganador = jugadorService.obtenerGanador(jugador1, jugador2);
        Jugador perdedor = jugadorService.obtenerPerdedor(jugador1, jugador2);

        model.addAttribute("jugador1", jugador1);
        model.addAttribute("jugador2", jugador2);
        model.addAttribute("ganador", ganador);
        model.addAttribute("perdedor", perdedor);
        model.addAttribute("puntajeGanador", ganador.calcularPuntaje());
        model.addAttribute("puntajePerdedor", perdedor.calcularPuntaje());

        return "resultado";
    }
}
