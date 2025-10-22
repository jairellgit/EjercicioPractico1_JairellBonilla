
package com.biblioteca.service;

import com.biblioteca.entity.Queja;
import com.biblioteca.repository.QuejaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuejaService {
    private final QuejaRepository repo;
    public QuejaService(QuejaRepository repo) { this.repo = repo; }
    public List<Queja> findAll() { return repo.findAll(); }
    public Queja save(Queja q) { return repo.save(q); }
}
