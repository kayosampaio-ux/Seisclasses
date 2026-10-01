package com.example.Seisclasses.Controller;

import com.example.Seiclasses.entity.FornecedorEntity;
import com.example.Seiclasses.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(
            FornecedorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FornecedorEntity> criar(
            @RequestBody FornecedorEntity dados) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(dados));
    }

    @GetMapping
    public List<FornecedorEntity> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FornecedorEntity buscarPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FornecedorEntity atualizar(
            @PathVariable Long id,
            @RequestBody FornecedorEntity dados) {

        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}