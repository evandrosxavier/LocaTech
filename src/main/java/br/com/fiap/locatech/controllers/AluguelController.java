package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.dtos.AluguelRequestDTO;
import br.com.fiap.locatech.entities.Aluguel;
import br.com.fiap.locatech.service.AluguelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findByID(
            @PathVariable("id") Long id) {
        var aluguel = this.aluguelService.findById(id);
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        var alugueis = this.aluguelService.findAll(page, size);
        return ResponseEntity.ok(alugueis);

    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AluguelRequestDTO aluguel) {
        this.aluguelService.save(aluguel);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @RequestBody Aluguel aluguel,
            @PathVariable("id") Long id) {
        this.aluguelService.update(aluguel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id) {
        this.aluguelService.delete(id);
        return ResponseEntity.ok().build();
    }
}

