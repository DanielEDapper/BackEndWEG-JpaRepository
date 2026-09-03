package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Série temporal de testagem: totais e taxas de positividade.
 * A unidade de medida do teste (pessoas, amostras, etc.) varia por
 * localidade e é referenciada via {@link TestUnit}.
 */
@Entity
@Table(name = "testing_observation", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TestingObservation
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

    @Column(name = "total_tests")
    private BigDecimal totalTests;

    @Column(name = "new_tests")
    private BigDecimal newTests;

    @Column(name = "total_tests_per_thousand")
    private BigDecimal totalTestsPerThousand;

    @Column(name = "new_tests_per_thousand")
    private BigDecimal newTestsPerThousand;

    @Column(name = "new_tests_smoothed")
    private BigDecimal newTestsSmoothed;

    @Column(name = "new_tests_smoothed_per_thousand")
    private BigDecimal newTestsSmoothedPerThousand;

    @Column(name = "positive_rate")
    private BigDecimal positiveRate;

    @Column(name = "tests_per_case")
    private BigDecimal testsPerCase;

    @Column(name = "test_unit_code")
    private BigDecimal testUnitCode;
}
