package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Série temporal de mortalidade em excesso: comparação entre óbitos
 * observados e a média histórica esperada para o período.
 * Disponível apenas para um subconjunto das localidades/datas.
 */
@Entity
@Table(name = "excess_mortality_observation", schema = "covid")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ExcessMortalityObservation
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

    @Column(name = "excess_mortality_cumulative_absolute")
    private BigDecimal excessMortalityCumulativeAbsolute;

    @Column(name = "excess_mortality_cumulative")
    private BigDecimal excessMortalityCumulative;

    @Column(name = "excess_mortality")
    private BigDecimal excessMortality;

    @Column(name = "excess_mortality_cumulative_per_million")
    private BigDecimal excessMortalityCumulativePerMillion;
}
