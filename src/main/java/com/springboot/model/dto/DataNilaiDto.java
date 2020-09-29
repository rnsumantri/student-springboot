package com.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataNilaiDto {
    private Integer idDataNilai;
    private Integer idMataKuliah;
    private Integer idMahasiswa;
    private Long nilai;
    private String keterangan;
}
