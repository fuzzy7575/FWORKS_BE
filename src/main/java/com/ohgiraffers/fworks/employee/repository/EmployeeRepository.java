package com.ohgiraffers.fworks.employee.repository;

import com.ohgiraffers.fworks.employee.domain.entity.Employee;
import com.ohgiraffers.fworks.employee.domain.type.EmpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /* 사원 아이디로 조회 */
    Optional<Employee> findByEmpId(String empId);

    /* 사원 번호로 조회 */
    Optional<Employee> findByEmpNo(Long empNo);

    /* 리프레시 토큰 조회 */
    Optional<Employee> findByRefreshToken(String refreshToken);

    /* 사원 목록 조회 : 페이징, 삭제 설정된 사원 포함 (관리자) */
    @EntityGraph(attributePaths = {"department"})
    Page<Employee> findByEmpStatusNot(Pageable pageable, EmpStatus empStatus);
}
