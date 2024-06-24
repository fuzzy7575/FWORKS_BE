package com.ohgiraffers.fworks.employee.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class EmployeeRegistRequest {

    @NotNull
    private final String empId;
    @NotNull
    private final String empPw;
    @NotNull
    private final String empName;
    private final Long empBirth;
    private final String empPhone;
    @NotNull
    private final String empEmail;
    private final String empAdress;
    private final String empJobtitle;
    private final String empPosition;
    private final LocalDate empJdate;
    private final LocalDate empQdate;
    private final String empQuitYn;
    private final String empRole;
    private final String empStatus;
    private final Long depNo;

}
