package com.example.Seiclasses.service;

import com.example.Seiclasses.entity.Fornecedor;
import com.example.Seiclasses.exception.RecursoNaoEncontradoException;
import com.example.Seiclasses.repository.FornecedorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FornecedorService {
    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public Fornecedor criar(Fornecedor dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Fornecedor não encontrado(a), id: " + id));
    }

    public Fornecedor atualizar(Long id, Fornecedor dados) {
        Fornecedor existente = buscarPorId(id);
        dados.setId(existente.getId());
        return repository.save(dados);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
