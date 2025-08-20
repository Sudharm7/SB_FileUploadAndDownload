package com.example.PAN_Errors.PAN_Excel_download.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {

    @NotBlank(message = "Financial Year is mandatory")
    private String financialYear;

    @NotBlank(message = "Form Type is mandatory")
    private String formType;

    @NotBlank(message = "Quarter is mandatory")
    private String quarter;
}
