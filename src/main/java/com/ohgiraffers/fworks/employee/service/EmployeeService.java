package com.ohgiraffers.fworks.employee.service;

import com.ohgiraffers.fworks.auth.dto.LoginDto;
import com.ohgiraffers.fworks.common.exception.NotFoundException;
import com.ohgiraffers.fworks.common.exception.type.ExceptionCode;
import com.ohgiraffers.fworks.employee.domain.entity.Department;
import com.ohgiraffers.fworks.employee.domain.entity.Employee;
import com.ohgiraffers.fworks.employee.dto.request.EmployeeRegistRequest;
import com.ohgiraffers.fworks.employee.dto.request.EmployeeUpdateRequest;
import com.ohgiraffers.fworks.employee.dto.response.EmployeeResponse;
import com.ohgiraffers.fworks.employee.dto.response.MypageResponse;
import com.ohgiraffers.fworks.employee.repository.DepartmentRepository;
import com.ohgiraffers.fworks.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ohgiraffers.fworks.common.exception.type.ExceptionCode.NOT_FOUND_REFRESH_TOKEN;
import static com.ohgiraffers.fworks.employee.domain.type.EmpStatus.DELETED;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page - 1, 10, Sort.by("empNo").descending());
    }

    /* 사원 목록 조회 (관리자) */
    @Transactional(readOnly = true)
    public Page<EmployeeResponse> getEmployees(final Integer page) {

        Page<Employee> employees = employeeRepository.findByEmpStatusNot(getPageable(page), DELETED);

        return employees.map(EmployeeResponse::from);

    }

    /* 사원 등록 */
    public void regist(EmployeeRegistRequest employeeRegistRequest) {

        Department department = departmentRepository.findById(employeeRegistRequest.getDepNo())
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_DEPARTMENT_NO));

        final Employee employee = Employee.of(
                employeeRegistRequest.getEmpId(),
                passwordEncoder.encode(employeeRegistRequest.getEmpPw()),
                employeeRegistRequest.getEmpName(),
                employeeRegistRequest.getEmpBirth(),
                employeeRegistRequest.getEmpPhone(),
                employeeRegistRequest.getEmpEmail(),
                employeeRegistRequest.getEmpAdress(),
                employeeRegistRequest.getEmpJobtitle(),
                employeeRegistRequest.getEmpPosition(),
                employeeRegistRequest.getEmpJdate(),
                employeeRegistRequest.getEmpQdate(),
                department // 부서 엔티티
        );

        employeeRepository.save(employee);
    }

    /* 사원 수정 */
    public void modify(Long empNo, EmployeeUpdateRequest employeeUpdateRequest) {

        Employee employee = employeeRepository.findByEmpNo(empNo)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사원이 존재하지 않습니다."));

        Department department = departmentRepository.findById(employeeUpdateRequest.getDepNo())
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_DEPARTMENT_NO));

        /* 수정을 위해 엔터티 정보 변경 */
        employee.modify(
                employeeUpdateRequest.getEmpName(),
                employeeUpdateRequest.getEmpBirth(),
                employeeUpdateRequest.getEmpPhone(),
                employeeUpdateRequest.getEmpEmail(),
                employeeUpdateRequest.getEmpAdress(),
                employeeUpdateRequest.getEmpJobtitle(),
                employeeUpdateRequest.getEmpPosition(),
                employeeUpdateRequest.getEmpJdate(),
                employeeUpdateRequest.getEmpQdate(),
                employeeUpdateRequest.getEmpQuitYn(),
                employeeUpdateRequest.getEmpStatus(),
                department
        );

    }

    /* 사원 삭제 */
    public void remove(Long empNo) {

        employeeRepository.deleteById(empNo);
    }

    /* 마이페이지 조회 */
    @Transactional(readOnly = true)
    public MypageResponse getMypage(String empId) {

        Employee employee = employeeRepository.findByEmpId(empId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));

        return MypageResponse.from(employee);

    }

    /* 아이디로 사원 조회 */
    @Transactional(readOnly = true)
    public LoginDto findByEmpId(String empId) {

        Employee employee = employeeRepository.findByEmpId(empId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));

        return LoginDto.from(employee);
    }

    /* 리프레시 토큰 업데이트 */
    public void updateRefreshToken(String empId, String refreshToken) {

        Employee employee = employeeRepository.findByEmpId(empId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));
        employee.updateRefreshToken(refreshToken);

    }

    /* 리프레시 토큰 조회 */
    @Transactional(readOnly = true)
    public LoginDto findByRefreshToken(String refreshToken) {
        Employee employee = employeeRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_REFRESH_TOKEN));

        return LoginDto.from(employee);
    }

}
