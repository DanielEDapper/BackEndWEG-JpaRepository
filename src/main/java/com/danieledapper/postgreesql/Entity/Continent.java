package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa um continente no sistema
 * Se relaciona com localização atravez do Identificador Único
 * - Um continente pode ter varias localizações
 * - Uma localização pode ter apenas um continente*/
@Entity
@Table(name = "continent")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Continent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private Short continent_id;

    /**
     *  Nome do Continente*/
    @Column(name = "name")
    private String name;
}
