package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test_unit")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class TestUnit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_unit_code", length = 30)
    private String testUnitCode;

    @Column(name = "description", length = 100)
    private String description;
}
