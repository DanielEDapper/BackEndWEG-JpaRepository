package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa uma localidade da base OWID: país, território,
 * agregação continental ou outra unidade de análise definida
 * em {@link LocationType}.
 * É a entidade central do modelo — todas as séries temporais
 * (epidemiologia, testagem, vacinação, etc.) partem dela.
 */
@Entity
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "iso_code", length = 12)
    private String isoCode;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "continent_id")
    private Short continentId;

    @Column(name = "location_type_code", length = 30)
    private String locationTypeCode;
}
