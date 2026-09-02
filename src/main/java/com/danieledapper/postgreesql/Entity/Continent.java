package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Tabela de domínio com os continentes usados para agrupar
 * localidades do tipo país/território.
 */
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
