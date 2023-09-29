package com.example.lab7.controllers;

import com.example.lab7.repository.TecnicoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TecnicoController {

    final TecnicoRepositorio tecnicoRepositorio;

    public TecnicoController(TecnicoRepositorio tecnicoRepositorio) {
        this.tecnicoRepositorio = tecnicoRepositorio;
    }

    @GetMapping(value = { "/listaTecnico"})
    public String listarEmpleados(Model model) {
        model.addAttribute("listaTecnico", tecnicoRepositorio.findAll());
        return "tecnico/list";
    }


}
