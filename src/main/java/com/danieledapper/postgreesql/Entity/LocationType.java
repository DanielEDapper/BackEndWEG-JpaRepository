package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Tabela de domínio que classifica a natureza de uma localidade
 * (país, continente, união política, agregação mundial, etc.).
 * Usada como referência pela entidade {@link Location}.
 */
@Entity
@Table(name = "location_type", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LocationType
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "location_type_code", length = 30)
    private String locationTypeCode;

    @Column(name = "description", length = 150)
    private String description;
}