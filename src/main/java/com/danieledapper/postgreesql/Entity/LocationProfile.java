package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Atributos demográficos e econômicos estáveis de uma localidade
 * (população, PIB per capita, IDH, expectativa de vida, entre outros).
 * Mantidos separados de {@link Location} porque não variam por data,
 * evitando repetição nas tabelas de série temporal.
 * Relacionamento 1:1 com {@link Location}, compartilhando a mesma
 * chave primária (location_id).
 */
@Entity
@Table(name = "location_profile", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LocationProfile {

    @Id
    @Column(name = "location_id")
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "population", nullable = false)
    private Long population;

    @Column(name = "population_density")
    private BigDecimal populationDensity;

    @Column(name = "median_age")
    private BigDecimal medianAge;

    @Column(name = "aged_65_older")
    private BigDecimal aged65Older;

    @Column(name = "aged_70_older")
    private BigDecimal aged70Older;

    @Column(name = "gdp_per_capita")
    private BigDecimal gpdPerCapita;

    @Column(name = "extreme_poverty")
    private BigDecimal extremePoverty;

    @Column(name = "cardiovasc_death_rate")
    private BigDecimal cardiovascDeathRate;

    @Column(name = "diabetes_prevalence")
    private BigDecimal diabetesPrevalence;

    @Column(name = "female_smokers")
    private BigDecimal femaleSmokers;

    @Column(name = "male_smokers")
    private BigDecimal maleSmokers;

    @Column(name = "handwashing_facilities")
    private BigDecimal handwashingFacilities;

    @Column(name = "hospital_beds_per_thousand")
    private BigDecimal hospitalBedsPerThousand;

    @Column(name = "life_expectancy")
    private BigDecimal lifeExpectancy;

    @Column(name = "human_development_index")
    private BigDecimal humanDevelopmentIndex;
}
