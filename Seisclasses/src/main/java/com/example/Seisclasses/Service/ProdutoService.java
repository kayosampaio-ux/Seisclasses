package com.example.Seiclasses.service;

import com.example.Seiclasses.entity.Produto;
import com.example.Seiclasses.exception.RecursoNaoEncontradoException;
import com.example.Seiclasses.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criar(Produto dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado(a), id: " + id));
    }

    public Produto atualizar(Long id, Produto dados) {
        Produto existente = buscarPorId(id);
        dados.setId(existente.getId());
        return repository.save(dados);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}
