package com.example.PAN_Errors.PAN_Excel_download.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PAN_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PANDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_serial_no")
    private String cdSerialNo;

    @Column(name = "dd_serial_no")
    private String ddSerialNo;

    @Column(name = "pan_deductee")
    private String panDeductee;

    @Column(name = "name_deductee")
    private String nameDeductee;

    @Column(name = "financial_year")
    private String financialYear;

    @Column(name = "form_type")
    private String formType;

    @Column(name = "quarter")
    private String quarter;

    @Column(name = "pan_status")
    private String panStatus;

    // Other columns you don't need in response
}

