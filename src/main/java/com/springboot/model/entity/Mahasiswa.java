package com.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Mahasiswa {
    @Id
    @Column(name = "id_mahasiswa", nullable = false)
    private Integer idMahasiswa;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;

    @Column(name = "alamat")
    private String alamat;


}
