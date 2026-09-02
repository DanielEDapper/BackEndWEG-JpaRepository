package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

/**
 * Grão canônico da série temporal: representa uma localidade em
 * uma data específica. Garante que não existam observações
 * duplicadas para o mesmo par localidade/data e serve como
 * referência para todas as tabelas de fatos diários.
 */
@Entity
@Table(name = "observation_day")
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
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "observation_date")
    private Date observationDate;
}
