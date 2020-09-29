package com.springboot.repository;

import com.springboot.model.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {

}
