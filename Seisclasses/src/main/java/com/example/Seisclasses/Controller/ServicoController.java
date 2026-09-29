package com.example.Seiclasses.controller;

import com.example.Seiclasses.entity.Servico;
import com.example.Seiclasses.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico dados) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dados));
    }

    @GetMapping
    public List<Servico> listar() {
        return service.listar();
    }

    @GetMapping("/<built-in function id>")
    public Servico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/<built-in function id>")
    public Servico atualizar(@PathVariable Long id, @RequestBody Servico dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/<built-in function id>")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
