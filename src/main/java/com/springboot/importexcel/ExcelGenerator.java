package com.springboot.importexcel;

import com.springboot.model.entity.Mahasiswa;
import com.springboot.repository.MahasiswaRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

@Component
public class ExcelGenerator {
    @Autowired
    private MahasiswaRepository repository;

    public void importExcel(MultipartFile file) throws Exception{

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for(int i=0;i<(CoutRowExcel(sheet.rowIterator()));i++) {
            if(i == 0) {
                continue;
            }

            Row row = sheet.getRow(i);

            Integer mhs = Integer.parseInt(row.getCell(0).getStringCellValue());
            Integer id = mhs;
            String nama = row.getCell(1).getStringCellValue();
            String alamat = row.getCell(2).getStringCellValue();

            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setIdMahasiswa(id);
            mahasiswa.setNamaMahasiswa(nama);
            mahasiswa.setAlamat(alamat);

            repository.save(mahasiswa);
        }

    }

    /* Cout Row of Excel Table */
    public static int CoutRowExcel(Iterator<Row> iterator) {
        int size = 0;
        while(iterator.hasNext()) {
            Row row = iterator.next();
            size++;
        }
        return size;
    }
}
