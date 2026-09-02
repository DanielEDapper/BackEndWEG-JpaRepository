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
@Table(name = "policy_observation")
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

    @Column(name = "stringency_index")
    private BigDecimal stringencyIndex;
}
