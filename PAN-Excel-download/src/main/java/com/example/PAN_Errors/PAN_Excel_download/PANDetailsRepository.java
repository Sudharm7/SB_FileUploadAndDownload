package com.example.PAN_Errors.PAN_Excel_download;

import com.example.PAN_Errors.PAN_Excel_download.entity.PANDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PANDetailsRepository extends JpaRepository<PANDetails, Long> {

    List<PANDetails> findByFinancialYearAndFormTypeAndQuarter(
            String financialYear, String formType, String quarter
    );

}
