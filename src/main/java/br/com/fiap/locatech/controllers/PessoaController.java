package br.com.fiap.locatech.controllers;

import br.com.fiap.locatech.entities.Pessoa;
import br.com.fiap.locatech.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Pessoa>> findByID(
            @PathVariable ("id") Long id) {
        var pessoa = this.pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(
        @RequestParam("page") int page,
        @RequestParam("size") int size) {
       var pessoas = this.pessoaService.findAll(page, size);
        return ResponseEntity.ok(pessoas);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Pessoa pessoa) {
        this.pessoaService.save(pessoa);
         return ResponseEntity.ok().build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity update(
            @RequestBody Pessoa pessoa,
            @PathVariable("id") Long id) {
        this.pessoaService.update(pessoa, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity delete(
            @PathVariable ("id") Long id) {
        this.pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
