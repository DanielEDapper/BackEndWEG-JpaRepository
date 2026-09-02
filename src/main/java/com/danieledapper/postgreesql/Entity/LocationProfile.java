package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "location_profile")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LocationProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "population")
    private Long population;

    @Column(name = "population_density")
    private BigDecimal populationDensity;

    @Column(name = "median_age")
    private BigDecimal medianAge;

    @Column(name = "aged_65_older")
    private BigDecimal aged65Older;

    @Column(name = "aged_70_aged")
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
