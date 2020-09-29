package com.springboot.controller;

import com.springboot.importexcel.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Controller
public class MahasiswaController {
    @Autowired
    private ExcelGenerator excel;

    @PostMapping("/import")
    public String cretePostImport(@RequestParam(name = "file") MultipartFile file) throws Exception {


        excel.importExcel(file);

        return "redirect:/import";
    }
}
