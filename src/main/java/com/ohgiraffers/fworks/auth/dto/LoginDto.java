package com.ohgiraffers.fworks.auth.dto;

import com.ohgiraffers.fworks.employee.domain.entity.Employee;
import com.ohgiraffers.fworks.employee.domain.type.EmpRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginDto {

    private final Long empNo;
    private final String empId;
    private final String empPw;
    private final EmpRole empRole;

    public static LoginDto from(Employee employee) {
        return new LoginDto(
                employee.getEmpNo(),
                employee.getEmpId(),
                employee.getEmpPw(),
                employee.getEmpRole()
        );
    }
}
