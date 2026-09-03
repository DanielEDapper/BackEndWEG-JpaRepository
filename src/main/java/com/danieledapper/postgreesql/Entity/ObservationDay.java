package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Grão canônico da série temporal: representa uma localidade em
 * uma data específica. Garante que não existam observações
 * duplicadas para o mesmo par localidade/data e serve como
 * referência para todas as tabelas de fatos diários.
 */
@Entity
@Table(name = "observation_day", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ObservationDay
{
    /**
     * Chave composta de {@link ObservationDay} e das tabelas de série
     * temporal associadas: identifica unicamente uma observação pelo
     * par (localidade, data).
     */

    @EmbeddedId
    private LocationGeneralId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
}
