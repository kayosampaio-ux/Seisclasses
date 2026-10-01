package com.example.Seisclasses.Repository ;

import com.example.Seiclasses.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository
        extends JpaRepository<ProdutoEntity, Long> {
}