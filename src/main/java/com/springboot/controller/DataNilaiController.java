package com.springboot.controller;

import com.springboot.Assembler.DataNilaiAssembler;
import com.springboot.model.dto.DataNilaiDto;
import com.springboot.model.dto.GetNilaiMahasiswaDto;
import com.springboot.model.dto.NilaiAvg;
import com.springboot.model.entity.DataNilai;
import com.springboot.model.entity.Mahasiswa;
import com.springboot.repository.DataNilaiRepository;
//import com.springboot.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/datanilai")
public class DataNilaiController {
//    @Autowired
//    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private DataNilaiRepository repository;

    @Autowired
    private DataNilaiAssembler assembler;

//    @GetMapping
//    public List<DataNilaiDto> get(){
//        List<DataNilai> dataNilaiList = repository.findAll();
//        List<DataNilaiDto> dataNilaiDtoList = dataNilaiList.stream().map(dataNilai -> assembler.fromEntity(dataNilai))
//                .collect(Collectors.toList());
//        return dataNilaiDtoList;
//    }

    @PostMapping
    public DataNilai insert(@RequestBody DataNilaiDto dto){
        DataNilai dataNilai = assembler.fromDto(dto);
        repository.save(dataNilai);
        return dataNilai;
    }

    @PutMapping("/{id}")
    public DataNilai edit(@RequestBody DataNilaiDto dto,@PathVariable Integer id){
        return repository.findById(id)
                .map(data -> {
                    data.setIdDataNilai(dto.getIdDataNilai());
                    data.setIdMahasiswa(dto.getIdMahasiswa());
                    data.setNilai(dto.getNilai());
                    data.setKeterangan(dto.getKeterangan());
                    data.setIdMataKuliah(dto.getIdMataKuliah());
                    return repository.save(data);
                })
                .orElseGet(()->{
                    dto.setIdDataNilai(id);
                    return repository.save(assembler.fromDto(dto));
                });
    }

    @DeleteMapping("/datanilai/delete/{id}")
    public void DataNilai (@PathVariable Integer id){
        repository.deleteById(id);
    }

    @GetMapping("/nilai")
    public List<GetNilaiMahasiswaDto> getNilai(){
        List<DataNilai> dataNilaiList = repository.findAll();
        List<GetNilaiMahasiswaDto> data = new ArrayList<>();
        for (int i = 0; i< dataNilaiList.size(); i++){
            GetNilaiMahasiswaDto jd = new GetNilaiMahasiswaDto();
            jd.setIdMahasiswa(dataNilaiList.get(i).getIdMahasiswa());
            jd.setNamaMahasiswa(dataNilaiList.get(i).getMahasiswa().getNamaMahasiswa());
            jd.setNamaMataKuliah(dataNilaiList.get(i).getMataKuliah().getNamaMataKuliah());
            jd.setNilai(dataNilaiList.get(i).getNilai());
            data.add(jd);
        }
        return data;
    }

    @GetMapping("/nilairata")
    public List<NilaiAvg> nilaiAvg(){
        List<Long> dataNilaiList = repository.findAverage();
        List<String> mahasiswaList = repository.findNama();
        List<NilaiAvg> data = new ArrayList<>();
        for (int i = 0; i< dataNilaiList.size(); i++){
            NilaiAvg jd = new NilaiAvg();
            jd.setNamaMahasiswa(mahasiswaList.get(i));
            jd.setNilaiRataRata(dataNilaiList.get(i).longValue());
            data.add(jd);
        }
        return data;
    }





}
