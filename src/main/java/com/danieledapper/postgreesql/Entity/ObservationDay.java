package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "observation_day")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ObservationDay
{
    @Id
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "observation_date")
    private Date observationDate;
}
