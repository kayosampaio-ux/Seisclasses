package com.example.Seiclasses.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 60)
    private String especie;

    @Column(length = 100)
    private String raca;

    // ID do cliente responsável. Pode virar @ManyToOne quando a entidade Cliente estiver pronta.
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
}
