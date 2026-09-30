package com.example.Seiclasses.repository;

import com.example.Seiclasses.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
