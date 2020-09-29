package com.springboot.Assembler;

import com.springboot.model.dto.DataNilaiDto;
import com.springboot.model.entity.DataNilai;
import com.springboot.model.entity.Mahasiswa;
import com.springboot.repository.DataNilaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataNilaiAssembler implements InterfaceAssembler<DataNilai, DataNilaiDto>{

    @Autowired
    private DataNilaiRepository repository;

    @Override
    public DataNilai fromDto(DataNilaiDto dto) {
        if (dto==null)
            return null;

        DataNilai dataNilai = new DataNilai();
        if (dto.getIdDataNilai()!=null){
            Optional<DataNilai> temp = this.repository.findById(dto.getIdDataNilai());
            if (temp.isPresent()){
                dataNilai = temp.get();
            }
        }
        if (dto.getIdDataNilai()!=null) dataNilai.setIdDataNilai(dto.getIdDataNilai());
        if (dto.getIdMahasiswa()!=null) dataNilai.setIdMahasiswa(dto.getIdMahasiswa());
        if (dto.getIdMataKuliah()!= null) dataNilai.setIdMataKuliah(dto.getIdMataKuliah());
        if (dto.getNilai()!=null) dataNilai.setNilai(dto.getNilai());
        if (dto.getKeterangan()!= null) dataNilai.setKeterangan(dto.getKeterangan());
        return dataNilai;
    }

    @Override
    public DataNilaiDto fromEntity(DataNilai entity) {
        if (entity==null)
            return null;
        return DataNilaiDto.builder()
                .idDataNilai(entity.getIdDataNilai())
                .idMahasiswa(entity.getIdMahasiswa())
                .idMataKuliah(entity.getIdMataKuliah())
                .nilai(entity.getNilai())
                .keterangan(entity.getKeterangan())
                .build();
    }
}
