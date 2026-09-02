package com.danieledapper.postgreesql.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

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
