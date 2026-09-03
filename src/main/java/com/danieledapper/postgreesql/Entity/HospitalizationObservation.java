package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Série temporal de ocupação hospitalar e de UTI, incluindo
 * admissões semanais. Nem toda localidade/data possui este dado —
 * depende do que foi reportado pela fonte original.
 */
@Entity
@Table(name = "hospitalization_observation", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HospitalizationObservation
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
