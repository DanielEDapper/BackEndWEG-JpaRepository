package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "location_type")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ExcessMortalityObservation
{
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "observation_date")
    private Date observationDate;

    @Column(name = "excess_mortality_cumulative_absolute")
    private BigDecimal excessMortalityCumulativeAbsolute;

    @Column(name = "excess_mortality_cumulative")
    private BigDecimal excessMortalityCumulative;

    @Column(name = "excess_mortality")
    private BigDecimal excessMortality;

    @Column(name = "excess_mortality_cumulative_per_million")
    private BigDecimal excessMortalityCumulativePerMilion;
}
