package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * */
@Entity
@Table(name = "location_type")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LocationType
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "location_type_code", length = 30)
    private String locationTypeCode;

    @Column(name = "description", length = 150)
    private String description;
}