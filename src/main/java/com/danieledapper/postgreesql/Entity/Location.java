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
@Table(name = "location", schema = "covid")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private Continent continentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationTypeCode")
    private LocationType locationType;
}
