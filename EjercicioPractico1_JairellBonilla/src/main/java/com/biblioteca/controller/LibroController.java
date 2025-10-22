
package com.biblioteca.controller;

import com.biblioteca.entity.Libro;
import com.biblioteca.entity.Categoria;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;
    private final CategoriaService categoriaService;
    public LibroController(LibroService libroService, CategoriaService categoriaService) {
        this.libroService = libroService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias", categoriaService.findAll());
        return "libros/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro, RedirectAttributes ra) {
        libroService.save(libro);
        ra.addFlashAttribute("msg", "Libro guardado correctamente");
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Libro> l = libroService.findById(id);
        if (l.isPresent()) {
            model.addAttribute("libro", l.get());
            model.addAttribute("categorias", categoriaService.findAll());
            return "libros/form";
        }
        return "redirect:/libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
        libroService.deleteById(id);
        ra.addFlashAttribute("msg", "Libro eliminado");
        return "redirect:/libros";
    }
}
