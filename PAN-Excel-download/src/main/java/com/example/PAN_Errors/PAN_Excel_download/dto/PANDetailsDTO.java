package com.example.PAN_Errors.PAN_Excel_download.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PANDetailsDTO {

    private int srNo;
    private String cdSerialNo;
    private String ddSerialNo;
    private String panDeductee;
    private String nameDeductee;
    private String panStatus;
}
