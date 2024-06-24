package com.ohgiraffers.fworks.employee.dto.response;

import com.ohgiraffers.fworks.employee.domain.entity.Employee;
import com.ohgiraffers.fworks.employee.domain.type.DepStatus;
import com.ohgiraffers.fworks.employee.domain.type.EmpQuitYn;
import com.ohgiraffers.fworks.employee.domain.type.EmpStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeResponse {

    private final Long empNo;
    private final String empId;
    private final String empPW;
    private final String empName;
    private final Long empBirth;
    private final String empPhone;
    private final String empEmail;
    private final String empAdress;
    private final String empJobtitle;
    private final String empPosition;
    private final LocalDate empJdate;
    private final LocalDate empQdate;
    private final EmpQuitYn empQuitYn;
    private final LocalDateTime empWdate;
    private final EmpStatus empStatus;

    private final Long depNo;
    private final String depCode;
    private final String depName;
    private final Long depSort;
    private final Long depPhase;
    private final LocalDateTime depWdate;
    private final DepStatus depStatus;

    public static EmployeeResponse from(Employee employee) {

        return new EmployeeResponse(
                employee.getEmpNo(),
                employee.getEmpId(),
                employee.getEmpPw(),
                employee.getEmpName(),
                employee.getEmpBirth(),
                employee.getEmpPhone(),
                employee.getEmpEmail(),
                employee.getEmpAdress(),
                employee.getEmpJobtitle(),
                employee.getEmpPosition(),
                employee.getEmpJdate(),
                employee.getEmpQdate(),
                employee.getEmpQuitYn(),
                employee.getEmpWdate(),
                employee.getEmpStatus(),

                employee.getDepartment().getDepNo(),
                employee.getDepartment().getDepCode(),
                employee.getDepartment().getDepName(),
                employee.getDepartment().getDepSort(),
                employee.getDepartment().getDepPhase(),
                employee.getDepartment().getDepWdate(),
                employee.getDepartment().getDepStatus()
        );

    }

}