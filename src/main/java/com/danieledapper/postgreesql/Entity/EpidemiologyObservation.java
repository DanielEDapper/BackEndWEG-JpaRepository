package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "location_type")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EpidemiologyObservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "observation_date")
    private LocalDateTime observationDate;

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
