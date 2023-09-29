package com.example.lab7.controllers;

import com.example.lab7.entitiies.Tecnicos;
import com.example.lab7.repository.TecnicoRepositorio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    final TecnicoRepositorio tecnicoRepositorio;

    public TecnicoController(TecnicoRepositorio tecnicoRepositorio) {
        this.tecnicoRepositorio = tecnicoRepositorio;
    }

    @GetMapping(value = { "/listaTecnico","", "/"})
    public String listarEmpleados(Model model) {
        model.addAttribute("listaTecnico", tecnicoRepositorio.findAll());
        return "tecnico/list";
    }

    @GetMapping("/new")
    public String nuevoProductoFrm(Model model, @ModelAttribute("tecnico") Tecnicos tecnico) {
        tecnico = new Tecnicos(); // Crea una instancia del objeto formulario
        model.addAttribute("formulario", tecnico);
        return "tecnico/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Tecnicos tecnicos, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal
            if (tecnicos.getId() == 0) {
                attr.addFlashAttribute("msg", "Producto creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
            }
            tecnicoRepositorio.save(tecnicos);
            return "redirect:/tecnico";
        } else { //hay al menos 1 error
            return "tecnico/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("tecnico") Tecnicos tecnico,
                                      Model model, @RequestParam("id") int id) {

        Optional<Tecnicos> optProduct = tecnicoRepositorio.findById(id);

        if (optProduct.isPresent()) {
            tecnico = optProduct.get();
            model.addAttribute("tecnico", tecnico);
            return "tecnico/editFrm";
        } else {
            return "redirect:/tecnico";
        }
    }

}
