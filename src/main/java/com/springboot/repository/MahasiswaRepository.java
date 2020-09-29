//package com.springboot.repository;
//
//import com.springboot.model.entity.Mahasiswa;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
//    @Query(value = "SELECT m.nama_mahasiswa FROM data_nilai INNER JOIN mahasiswa m on data_nilai.id_mahasiswa = m.id_mahasiswa GROUP BY m.id_mahasiswa", nativeQuery = true)
//    List<Mahasiswa> findAverageNama();
//}
