package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Série temporal do índice de rigor das políticas de resposta à
 * pandemia (stringency index), numa escala de 0 a 100.
 */
@Entity
@Table(name = "policy_observation", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PolicyObservation
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

    @Column(name = "stringency_index")
    private BigDecimal stringencyIndex;
}
