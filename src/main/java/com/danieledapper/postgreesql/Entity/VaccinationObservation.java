package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vaccination_observation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class VaccinationObservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(name = "observation_date")
    private Date observation;

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
