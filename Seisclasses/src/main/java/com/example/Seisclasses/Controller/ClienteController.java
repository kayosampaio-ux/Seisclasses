package com.example.Seisclasses.Controller;

import com.example.Seiclasses.entity.ClienteEntity;
import com.example.Seiclasses.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> criar(
            @RequestBody ClienteEntity dados) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.criar(dados));
    }

    @GetMapping
    public List<ClienteEntity> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ClienteEntity buscarPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteEntity atualizar(
            @PathVariable Long id,
            @RequestBody ClienteEntity dados) {

        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}