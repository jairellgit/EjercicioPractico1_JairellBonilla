
package com.biblioteca.service;

import com.biblioteca.entity.Categoria;
import com.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository repo;
    public CategoriaService(CategoriaRepository repo) { this.repo = repo; }
    public List<Categoria> findAll() { return repo.findAll(); }
    public Optional<Categoria> findById(Long id) { return repo.findById(id); }
    public Categoria save(Categoria c) { return repo.save(c); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
