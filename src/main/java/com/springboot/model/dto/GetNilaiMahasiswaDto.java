package com.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetNilaiMahasiswaDto {
    private Integer idMahasiswa;
    private String namaMahasiswa;
    private String namaMataKuliah;
    private Long nilai;
}
