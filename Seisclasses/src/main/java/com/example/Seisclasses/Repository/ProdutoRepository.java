package com.example.Seiclasses.repository;

import com.example.Seiclasses.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
