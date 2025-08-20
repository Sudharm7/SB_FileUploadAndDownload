package com.example.PAN_Errors.PAN_Excel_download.controller;

import com.example.PAN_Errors.PAN_Excel_download.dto.PANDetailsRequestDto;
//import com.example.PAN_Errors.PAN_Excel_download.exception.ExcelGenerationException;
import com.example.PAN_Errors.PAN_Excel_download.service.PANService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/pan")
public class PANController {

    @Autowired
    private PANService panService;




    @PostMapping("/add")
    public ResponseEntity<String> addPanDetails(@Valid @RequestBody PANDetailsRequestDto requestDto) {
        panService.savePanDetails(requestDto);
        return ResponseEntity.ok("PAN details added successfully.");
    }

    @GetMapping("/download")
    public void downloadPanDetails(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");//application/vnd.ms-excel

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pan_details.xls";
        response.setHeader(headerKey, headerValue);

        panService.generateExcel(response);
    }


}

