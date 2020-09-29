package com.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class DataNilai {
    @Id
    @Column(name = "id_data_nilai")
    private Integer idDataNilai;

    @ManyToOne
    @JoinColumn(name="id_mata_kuliah",insertable = false, updatable = false)
    private MataKuliah mataKuliah;

    @ManyToOne
    @JoinColumn(name="id_mahasiswa",insertable = false, updatable = false)
    private Mahasiswa mahasiswa;

    @Column(name = "id_mahasiswa")
    private Integer idMahasiswa;

    @Column(name = "id_mata_kuliah")
    private Integer idMataKuliah;

    @Column(name = "nilai")
    private Long nilai;

    @Column(name = "keterangan")
    private String keterangan;

}
