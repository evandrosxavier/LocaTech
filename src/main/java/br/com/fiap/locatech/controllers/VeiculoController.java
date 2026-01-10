package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Veiculo;
import br.com.fiap.locatech.service.VeiculoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/veiculos")
@Tag(name = "Veículo Controller", description = "(Controller para crud de veículos)")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll (
        @RequestParam("page") int page,
        @RequestParam("size") int size) {
        var veiculos = veiculoService.findAll(page, size);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Veiculo>> findById (
            @PathVariable("id") Long id) {
        var veiculo = veiculoService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Veiculo veiculo) {
        veiculoService.save(veiculo);
        return ResponseEntity.ok().build();
    }


    @PutMapping ("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") Long id,
            @RequestBody Veiculo veiculo) {
        veiculoService.update(veiculo, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete (
            @PathVariable ("id") Long id){
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
