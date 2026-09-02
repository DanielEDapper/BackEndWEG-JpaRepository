package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa uma localização do Sistema*/
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
