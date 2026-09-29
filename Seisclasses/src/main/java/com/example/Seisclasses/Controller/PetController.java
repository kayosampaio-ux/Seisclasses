package com.example.Seiclasses.controller;

import com.example.Seiclasses.entity.Pet;
import com.example.Seiclasses.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pet> criar(@RequestBody Pet dados) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dados));
    }

    @GetMapping
    public List<Pet> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public Pet buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/<built-in function id>")
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
