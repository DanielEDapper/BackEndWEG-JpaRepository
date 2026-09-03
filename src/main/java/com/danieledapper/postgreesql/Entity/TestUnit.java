package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Tabela de domínio com as unidades de medida possíveis para
 * testagem (pessoas testadas, amostras testadas, testes realizados
 * ou unidade não especificada pela fonte).
 */
@Entity
@Table(name = "test_unit", schema = "covid")
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
