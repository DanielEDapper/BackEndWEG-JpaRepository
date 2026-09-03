package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Série temporal de vacinação: doses aplicadas, pessoas vacinadas
 * (parcial e totalmente) e reforços, em valores absolutos e por
 * cem habitantes.
 */
@Entity
@Table(name = "vaccination_observation", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class VaccinationObservation
{
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocationGeneralId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "location_id", referencedColumnName = "location_id"),
            @JoinColumn(name = "observation_date", referencedColumnName = "observation_date")
    })
    private ObservationDay observationDay;

    @Column(name = "total_vaccinations")
    private BigDecimal totalVaccination;

    @Column(name = "people_vaccinated")
    private BigDecimal peopleVaccinated;

    @Column(name = "people_fully_vaccinated")
    private BigDecimal peopleFullyVaccinated;

    @Column(name = "total_boosters")
    private BigDecimal totalBoosters;

    @Column(name = "new_vaccinations")
    private BigDecimal newVaccinations;

    @Column(name = "new_vaccinations_smoothed")
    private BigDecimal newVaccinationsSmoothes;

    @Column(name = "total_vaccinations_per_hundred")
    private BigDecimal totalVaccinationsPerHundred;

    @Column(name = "people_vaccinated_per_hundred")
    private BigDecimal peopleVaccinatedPerHundred;

    @Column(name = "people_fully_vaccinated_per_hundred")
    private BigDecimal peopleFullyVaccinatedPerHundred;

    @Column(name = "total_boosters_per_hundred")
    private BigDecimal totalBoostersPerHundred;

    @Column(name = "new_vaccinations_smoothed_per_million")
    private BigDecimal newVaccinationsSmoothedPerMillion;

    @Column(name = "new_people_vaccinated_smoothed")
    private BigDecimal newPeopleVaccinatedSmoothed;

    @Column(name = "new_people_vaccinated_smoothed_per_hundred")
    private BigDecimal newPeopleVaccinatedSmoothedPerHundred;
}
