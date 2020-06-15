package com.gy.utils;

import com.gy.entity.ExcelStockPrice;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelReader {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private static final String STOCK_PRICE = "StockPrice";

    public static List<ExcelStockPrice> readExcel(MultipartFile file) {

        Workbook workbook = null;

        try {
            String fileName = file.getOriginalFilename();
            if (fileName == null || fileName.isEmpty() || fileName.lastIndexOf(".") < 0) {
                log.warn("The filename of Excel file is invalid!");
                return null;
            }
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

            workbook = getWorkbook(file.getInputStream(), fileType);

            List<ExcelStockPrice> resultDataList = parseExcel(workbook);

            return resultDataList;
        } catch (Exception e) {
            log.warn("Failed to parse Excel file，Filename：" + file.getOriginalFilename() + " Error message：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
            } catch (Exception e) {
                log.warn("Failed to close i/o stream！Error message：" + e.getMessage());
                return null;
            }
        }
    }

    private static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    private static List<ExcelStockPrice> parseExcel(Workbook workbook) {
        List<ExcelStockPrice> excelStockPriceList = new ArrayList<>();

        Sheet sheet = workbook.getSheet(STOCK_PRICE);

        if (sheet == null) {
            return null;
        }

        int firstRowNum = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNum);
        if (null == firstRow) {
            log.warn("Failed to parse Excel file, Cannot read any data in the first row！");
        }

        int rowStart = firstRowNum + 1;
        int rowEnd = sheet.getPhysicalNumberOfRows();
        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
            Row row = sheet.getRow(rowNum);

            if (null == row) {
                continue;
            }

            ExcelStockPrice excelStockPrice = convertRowToData(row);
            if (null == excelStockPrice) {
                log.warn("The data in " + row.getRowNum() + " row is illegal, it was ignored!");
                continue;
            }
            excelStockPriceList.add(excelStockPrice);
        }

        return excelStockPriceList;
    }

    private static ExcelStockPrice convertRowToData(Row row) {
        ExcelStockPrice excelStockPrice = new ExcelStockPrice();

        Cell cell;
        int cellNum = 0;
        // CompanyCode
        cell = row.getCell(cellNum++);
        CellType cellType = cell.getCellType();
        String companyCode = null;
        if (CellType.NUMERIC == cellType) {
            double doubleValue = cell.getNumericCellValue();
            Integer intValue = (int) doubleValue;
            companyCode = intValue.toString();
        } else {
            companyCode = cell.getStringCellValue();
        }
        excelStockPrice.setCompanyCode(companyCode);
        // CompanyName
        cell = row.getCell(cellNum++);
        String companyName = cell.getStringCellValue();
        excelStockPrice.setCompanyName(companyName);

        // CurrentPrice
        cell = row.getCell(cellNum++);
        double currentPrice = cell.getNumericCellValue();
        excelStockPrice.setCurrentPrice(currentPrice);
        // DateTime
        cell = row.getCell(cellNum++);
        LocalDateTime dateTime = cell.getLocalDateTimeCellValue();
        excelStockPrice.setLocalDateTime(dateTime);

        return excelStockPrice;
    }

}