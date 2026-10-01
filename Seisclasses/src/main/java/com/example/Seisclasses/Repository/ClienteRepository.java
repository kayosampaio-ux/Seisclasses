package com.example.Seiclasses.repository;

import com.example.Seiclasses.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository
        extends JpaRepository<ClienteEntity, Long> {
}