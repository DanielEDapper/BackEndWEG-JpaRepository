package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

/**
 * Registro de auditoria de cada execução de carga (ETL) do CSV da OWID.
 * Guarda o nome do arquivo importado e as contagens de linhas brutas,
 * dias normalizados e duplicidades complementares consolidadas.
 * Não representa dado epidemiológico — é histórico técnico do processo
 * de carga, não exposto pela API de consulta.
 */
@Entity
@Table(name = "etl_load")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class EtlLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "load_id")
    private Long id;

    @Column(name = "source_filename")
    private String souceFilename;

    @Column(name = "raw_row_count")
    private Long rawRowCount;

    @Column(name = "normalized_day_count")
    private Long nomalizedDayCount;

    @Column(name = "complementary_duplicate_count")
    private Long complementaryDuplicateCount;

    @Column(name = "loaded_at")
    private OffsetDateTime loadedAt;
}
