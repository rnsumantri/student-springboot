package com.springboot.repository;

import com.springboot.model.entity.DataNilai;
import com.springboot.model.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataNilaiRepository extends JpaRepository<DataNilai,Integer> {

    @Query(value = "SELECT avg(nilai) as rata_rata FROM data_nilai INNER JOIN mahasiswa m on data_nilai.id_mahasiswa = m.id_mahasiswa GROUP BY m.id_mahasiswa", nativeQuery = true)
    List<Long> findAverage();

    @Query(value = "SELECT m.nama_mahasiswa FROM data_nilai INNER JOIN mahasiswa m on data_nilai.id_mahasiswa = m.id_mahasiswa GROUP BY m.id_mahasiswa", nativeQuery = true)
    List<String> findNama();
}
