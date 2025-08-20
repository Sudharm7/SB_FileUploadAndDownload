package com.example.PAN_Errors.PAN_Excel_download.service;

import com.example.PAN_Errors.PAN_Excel_download.PANDetailsRepository;
import com.example.PAN_Errors.PAN_Excel_download.dto.PANDetailsDTO;
import com.example.PAN_Errors.PAN_Excel_download.dto.PANDetailsRequestDto;
import com.example.PAN_Errors.PAN_Excel_download.dto.SearchRequest;
import com.example.PAN_Errors.PAN_Excel_download.entity.PANDetails;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PANService {

    @Autowired
    private PANDetailsRepository repository;


    public void savePanDetails(PANDetailsRequestDto dto) {
        PANDetails panDetails = new PANDetails();
        panDetails.setCdSerialNo(dto.getCdSerialNo());
        panDetails.setDdSerialNo(dto.getDdSerialNo());
        panDetails.setPanDeductee(dto.getPanDeductee());
        panDetails.setNameDeductee(dto.getNameDeductee());
        panDetails.setFinancialYear(dto.getFinancialYear());
        panDetails.setFormType(dto.getFormType());
        panDetails.setQuarter(dto.getQuarter());
        panDetails.setPanStatus("Unknown"); // default or later calculated
        repository.save(panDetails);
    }

    public void generateExcel(HttpServletResponse response) throws IOException {
        List<PANDetails> panDetailsList = repository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("PAN Details");
        HSSFRow headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("CD Serial No");
        headerRow.createCell(1).setCellValue("DD Serial No");
        headerRow.createCell(2).setCellValue("PAN of Deductee");
        headerRow.createCell(3).setCellValue("Name of Deductee");
        headerRow.createCell(4).setCellValue("Financial Year");
        headerRow.createCell(5).setCellValue("Form Type");
        headerRow.createCell(6).setCellValue("Quarter");
        headerRow.createCell(7).setCellValue("PAN Status");

        int dataRowIndex = 1;
        for (PANDetails panDetails : panDetailsList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(panDetails.getCdSerialNo());
            dataRow.createCell(1).setCellValue(panDetails.getDdSerialNo());
            dataRow.createCell(2).setCellValue(panDetails.getPanDeductee());
            dataRow.createCell(3).setCellValue(panDetails.getNameDeductee());
            dataRow.createCell(4).setCellValue(panDetails.getFinancialYear());
            dataRow.createCell(5).setCellValue(panDetails.getFormType());
            dataRow.createCell(6).setCellValue(panDetails.getQuarter());
            dataRow.createCell(7).setCellValue(panDetails.getPanStatus());
            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();

    }





}

