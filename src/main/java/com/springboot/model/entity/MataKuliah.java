package com.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class MataKuliah {
    @Id
    @Column(name = "id_mata_kuliah")
    private Integer idMataKuliah;

    @Column(name = "nama_mata_kuliah")
    private String namaMataKuliah;

    @ManyToOne
    @JoinColumn(name="id_mahasiswa",insertable = false, updatable = false)
    private Mahasiswa mahasiswa;

    @Column(name = "id_mahasiswa")
    private Integer idMahasiswa;
}
