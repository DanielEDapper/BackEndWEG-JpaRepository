package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "hospitalization_observation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HospitalizationObservation
{
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "observation_date")
    private Date observationDate;

    @Column(name = "icu_patients")
    private BigDecimal icuPatients;

    @Column(name = "icu_patients_per_million")
    private BigDecimal icuPatientsPerMilion;

    @Column(name = "hosp_patients")
    private BigDecimal hospitalizedPatients;

    @Column(name = "hosp_patients_per_million")
    private BigDecimal hospitalizedPatientsPerMilion;

    @Column(name = "weekly_icu_admissions")
    private BigDecimal weeklyIcuAdmissions;

    @Column(name = "weekly_icu_admissions_per_million")
    private BigDecimal weeklyIcuAdmissionsPerMilion;

    @Column(name = "weekly_hosp_admissions")
    private BigDecimal weeklyHospitalizedAdmissions;

    @Column(name = "weekly_hosp_admissions_per_million")
    private BigDecimal weeklyHospitalizedAdmissionsPerMilion;

}
