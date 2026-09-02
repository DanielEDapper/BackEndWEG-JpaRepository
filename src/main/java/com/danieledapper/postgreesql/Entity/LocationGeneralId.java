package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class LocationGeneralId implements Serializable
{
    @Serial
    private static final long serialVersionUID = 123L;

    @NotNull
    @Column(name = "location_id", nullable = false)
    private Long location_id;

    @NotNull
    @Column(name = "observation_date", nullable = false)
    private LocalDate observationDate;
}
