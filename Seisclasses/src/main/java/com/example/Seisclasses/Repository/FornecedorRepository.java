package com.example.Seisclasses.Repository;

import com.example.Seiclasses.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository
        extends JpaRepository<FornecedorEntity, Long> {
}