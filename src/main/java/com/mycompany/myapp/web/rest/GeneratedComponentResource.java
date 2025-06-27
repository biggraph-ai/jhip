package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.GeneratedComponent;
import com.mycompany.myapp.repository.GeneratedComponentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generated-components")
public class GeneratedComponentResource {

    private final GeneratedComponentRepository repository;

    public GeneratedComponentResource(GeneratedComponentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<GeneratedComponent> create(@RequestBody GeneratedComponent gc) {
        GeneratedComponent saved = repository.save(gc);
        return ResponseEntity.created(URI.create("/api/generated-components/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<GeneratedComponent> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneratedComponent> get(@PathVariable Long id) {
        Optional<GeneratedComponent> gc = repository.findById(id);
        return gc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneratedComponent> update(@PathVariable Long id, @RequestBody GeneratedComponent gc) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        gc.setId(id);
        return ResponseEntity.ok(repository.save(gc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
