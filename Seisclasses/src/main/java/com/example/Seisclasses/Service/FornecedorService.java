package com.example.Seisclasses.Service;

import com.example.Seiclasses.entity.FornecedorEntity;
import com.example.Seiclasses.exception.RecursoNaoEncontradoException;
import com.example.Seiclasses.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(
            FornecedorRepository repository) {
        this.repository = repository;
    }

    public FornecedorEntity criar(
            FornecedorEntity dados) {

        dados.setId(null);
        return repository.save(dados);
    }

    public List<FornecedorEntity> listar() {
        return repository.findAll();
    }

    public FornecedorEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Fornecedor não encontrado, id: " + id
                        )
                );
    }

    public FornecedorEntity atualizar(
            Long id, FornecedorEntity dados) {

        FornecedorEntity existente = buscarPorId(id);
        dados.setId(existente.getId());

        return repository.save(dados);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}