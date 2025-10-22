
package com.biblioteca.controller;

import com.biblioteca.entity.Queja;
import com.biblioteca.service.QuejaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quejas")
public class QuejaController {
    private final QuejaService service;
    public QuejaController(QuejaService service) { this.service = service; }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("queja", new Queja());
        return "quejas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Queja queja, RedirectAttributes ra) {
        service.save(queja);
        ra.addFlashAttribute("msg", "Gracias por su mensaje. Lo atenderemos pronto.");
        return "redirect:/";
    }
}
