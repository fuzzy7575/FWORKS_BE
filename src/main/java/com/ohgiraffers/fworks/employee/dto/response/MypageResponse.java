package com.ohgiraffers.fworks.employee.dto.response;

import com.ohgiraffers.fworks.employee.domain.entity.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class MypageResponse {

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

    public static MypageResponse from(Employee employee) {

        return new MypageResponse(
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
                employee.getEmpJdate()
        );

    }
}
