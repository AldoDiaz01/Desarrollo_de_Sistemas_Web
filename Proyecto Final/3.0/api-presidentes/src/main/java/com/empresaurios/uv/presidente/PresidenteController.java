package com.empresaurios.uv.presidente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/presidentes")
public class PresidenteController {

    @Autowired
    private PresidenteRepository repository;

    @GetMapping
    public Iterable<Presidente> get() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Presidente getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Boolean post(@RequestBody Presidente entity) {
        try {
            repository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public Boolean put(@PathVariable Integer id, @RequestBody Presidente entity) {
        try {
            entity.setId(id);
            repository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
