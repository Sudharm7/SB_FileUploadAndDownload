package com.example.PAN_Errors.PAN_Excel_download.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PANDetailsRequestDto {

    @NotBlank(message = "CD Serial No. is required")
    private String cdSerialNo;

    @NotBlank(message = "DD Serial No. is required")
    private String ddSerialNo;

    @NotBlank(message = "PAN of Deductee is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN format")
    private String panDeductee;

    @NotBlank(message = "Name of Deductee is required")
    private String nameDeductee;

    @NotBlank(message = "Financial Year is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}$", message = "Financial year must be in the format YYYY-YY (e.g., 2024-25)")
    private String financialYear;

    @NotBlank(message = "Form Type is required")
    private String formType;

    @NotBlank(message = "Quarter is required")
    @Pattern(regexp = "Q[1-4]", message = "Quarter must be one of Q1, Q2, Q3, Q4")
    private String quarter;
}

