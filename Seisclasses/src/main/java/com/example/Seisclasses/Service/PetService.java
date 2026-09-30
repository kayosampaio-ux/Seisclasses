package com.example.Seiclasses.service;

import com.example.Seiclasses.entity.Pet;
import com.example.Seiclasses.exception.RecursoNaoEncontradoException;
import com.example.Seiclasses.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Pet criar(Pet pet) {
        pet.setId(null);
        return repository.save(pet);
    }

    public List<Pet> listar() {
        return repository.findAll();
    }

    public Pet buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pet não encontrado(a), id: " + id));
    }

    public Pet atualizar(Long id, Pet dados) {
        Pet existente = buscarPorId(id);
        dados.setId(existente.getId());
        return repository.save(dados);
    }

    public void excluir(Long id) {
        Pet existente = buscarPorId(id);
        repository.delete(existente);
    }
}
