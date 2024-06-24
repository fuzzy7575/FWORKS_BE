package com.ohgiraffers.fworks.employee.repository;

import com.ohgiraffers.fworks.employee.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
