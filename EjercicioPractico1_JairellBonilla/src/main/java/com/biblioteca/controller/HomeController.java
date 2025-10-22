
package com.biblioteca.controller;

import com.biblioteca.entity.Libro;
import com.biblioteca.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LibroService libroService;
    public HomeController(LibroService libroService) { this.libroService = libroService; }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("nuevo", new Libro());
        model.addAttribute("ultimos", libroService.findAll());
        return "index";
    }
}
