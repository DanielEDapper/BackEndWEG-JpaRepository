package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "policy_observation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PolicyObservation
{
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "onservation_date")
    private Date observationDate;

    @Column(name = "stringency_index")
    private BigDecimal stringencyIndex;
}
