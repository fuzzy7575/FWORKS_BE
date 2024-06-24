package com.ohgiraffers.fworks.employee.dto.request;

import com.ohgiraffers.fworks.employee.domain.type.EmpQuitYn;
import com.ohgiraffers.fworks.employee.domain.type.EmpStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class EmployeeUpdateRequest {

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
    @NotNull
    private final EmpQuitYn empQuitYn;
    @NotNull
    private final EmpStatus empStatus;
    @NotNull
    private final Long depNo;

}
