package com.springboot.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Mahasiswa {
    @Id
    @Column(name = "id_mahasiswa")
    private Integer idMahasiswa;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;

    @Column(name = "alamat")
    private String alamat;

}
