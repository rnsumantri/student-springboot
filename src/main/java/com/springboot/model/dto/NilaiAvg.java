package com.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NilaiAvg {
    private String namaMahasiswa;
    private Long nilaiRataRata;
}
