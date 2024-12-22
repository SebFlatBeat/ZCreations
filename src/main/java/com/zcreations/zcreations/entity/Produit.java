package com.zcreations.zcreations.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    @PositiveOrZero
    private BigDecimal prix;

    @Column(nullable = false)
    @PositiveOrZero
    private int stock;

    @Column(nullable = false)
    private boolean personnalisable;

    @Column(name = "url_image")
    private String urlImage;

    @Enumerated(EnumType.STRING)
    private StatutProduit statut;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}

enum StatutProduit {
    DISPONIBLE,
    INDISPONIBLE
}
