package com.example.Seiclasses.service;

import com.example.Seiclasses.entity.Cliente;
import com.example.Seiclasses.exception.RecursoNaoEncontradoException;
import com.example.Seiclasses.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado(a), id: " + id));
    }

    public Cliente atualizar(Long id, Cliente dados) {
        Cliente existente = buscarPorId(id);
        dados.setId(existente.getId());
        return repository.save(dados);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
