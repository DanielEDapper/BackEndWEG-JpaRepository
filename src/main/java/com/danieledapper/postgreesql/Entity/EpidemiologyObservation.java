package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

import java.math.BigDecimal;

/**
 * Série temporal de casos e óbitos por COVID-19 (valores absolutos,
 * suavizados e por milhão de habitantes), além da taxa de reprodução
 * do vírus. Um registro por localidade/data.
 */
@Entity
@Table(name = "epidemiology_observation", schema = "covid")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EpidemiologyObservation
{
    @EmbeddedId
    private LocationGeneralId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "location_id", referencedColumnName = "location_id"),
            @JoinColumn(name = "observation_date", referencedColumnName = "observation_date")
    })
    private ObservationDay observationDay;

    @Column(name = "total_cases")
    private BigDecimal totalCases;

    @Column(name = "new_cases")
    private BigDecimal newCases;

    @Column(name = "new_cases_smoothed")
    private BigDecimal newCasesSmoothed;

    @Column(name = "total_deaths")
    private BigDecimal totalDeaths;

    @Column(name = "new_deaths")
    private BigDecimal newDeaths;

    @Column(name = "new_deaths_smoothed")
    private BigDecimal newDeathsSmoothed;

    @Column(name = "total_cases_per_million")
    private BigDecimal totalCasesPerMilion;

    @Column(name = "new_cases_per_million")
    private BigDecimal newCasesPerMilion;

    @Column(name = "new_cases_smoothed_per_million")
    private BigDecimal newCasesSmoothedPerMilion;

    @Column(name = "total_deaths_per_million")
    private BigDecimal totalDeathsPerMilion;

    @Column(name = "new_deaths_per_million")
    private BigDecimal newDeathsPerMilion;

    @Column(name = "new_deaths_smoothed_per_million")
    private BigDecimal newDeathsSmoothedPerMilion;

    @Column(name = "reproduction_rate")
    private BigDecimal reproductionRate;
}
