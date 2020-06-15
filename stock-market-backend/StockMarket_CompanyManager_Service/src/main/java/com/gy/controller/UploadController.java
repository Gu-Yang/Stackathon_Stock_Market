package com.gy.controller;

import com.gy.entity.ExcelStockPrice;
import com.gy.service.UploadService;
import com.gy.utils.ExcelReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value="uploadExcel")
    public ResponseEntity<Integer> uploadExcel(MultipartFile file) {

        if (null == file || file.isEmpty()) {
            log.warn("The excel data file is null or empty！Upload time：" + LocalDateTime.now());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // Parse Excel
            List<ExcelStockPrice> excelStockPriceList = ExcelReader.readExcel(file);

            Integer uploadedCount = uploadService.UploadStockPrices(excelStockPriceList);

            return new ResponseEntity<Integer>(uploadedCount, HttpStatus.OK);
        } catch (Exception e) {
            log.warn("The data in excel file is incorrect！Upload time：" + LocalDateTime.now());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="downloadExcel")
    public void downloadExcel(HttpServletResponse response, HttpServletRequest request)throws IOException {

        String filePath = "templates/StockPrice_Template.xlsx";
        Resource resource = new ClassPathResource(filePath);
        InputStream bis = resource.getInputStream();
        String filename = "StockPrice_Template.xlsx";

        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}