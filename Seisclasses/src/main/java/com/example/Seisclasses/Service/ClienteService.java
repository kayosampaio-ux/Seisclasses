package com.example.Seiclasses.service;

import com.example.Seiclasses.entity.ClienteEntity;
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

    public ClienteEntity criar(ClienteEntity dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<ClienteEntity> listar() {
        return repository.findAll();
    }

    public ClienteEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Cliente não encontrado, id: " + id
                        )
                );
    }

    public ClienteEntity atualizar(
            Long id, ClienteEntity dados) {

        ClienteEntity existente = buscarPorId(id);
        dados.setId(existente.getId());

        return repository.save(dados);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}