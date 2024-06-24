package com.ohgiraffers.fworks.employee.domain.entity;

import com.ohgiraffers.fworks.employee.domain.type.EmpQuitYn;
import com.ohgiraffers.fworks.employee.domain.type.EmpRole;
import com.ohgiraffers.fworks.employee.domain.type.EmpStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE employee SET emp_status = 'DELETED' WHERE emp_no = ?")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;
    private String empId;
    private String empPw;
    private String empName;
    private Long empBirth;
    private String empPhone;
    private String empEmail;
    private String empAdress;
    private String empJobtitle;
    private String empPosition;
    private LocalDate empJdate;
    private LocalDate empQdate;

    @Enumerated(value = EnumType.STRING)
    private EmpQuitYn empQuitYn = EmpQuitYn.N;
    @Enumerated(value = EnumType.STRING)
    private EmpRole empRole = EmpRole.USER;
    @CreatedDate
    private LocalDateTime empWdate;
    @Enumerated(value = EnumType.STRING)
    private EmpStatus empStatus = EmpStatus.ACTIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depNo")
    private Department department;

    private String refreshToken;

    private Employee(String empId, String empPw, String empName, Long empBirth, String empPhone, String empEmail, String empAdress, String empJobtitle, String empPosition, LocalDate empJdate, LocalDate empQdate, Department department) {
        this.empId = empId;
        this.empPw = empPw;
        this.empName = empName;
        this.empBirth = empBirth;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empAdress = empAdress;
        this.empJobtitle = empJobtitle;
        this.empPosition = empPosition;
        this.empJdate = empJdate;
        this.empQdate = empQdate;
        this.department = department;
    }

    public static Employee of(String empId, String empPw, String empName, Long empBirth, String empPhone, String empEmail, String empAdress, String empJobtitle, String empPosition, LocalDate empJdate, LocalDate empQdate, Department department) {
        return new Employee(
                empId,
                empPw,
                empName,
                empBirth,
                empPhone,
                empEmail,
                empAdress,
                empJobtitle,
                empPosition,
                empJdate,
                empQdate,
                department
        );
    }

    public void modify(String empName, Long empBirth, String empPhone, String empEmail, String empAdress, String empJobtitle, String empPosition, LocalDate empJdate, LocalDate empQdate, EmpQuitYn empQuitYn, EmpStatus empStatus, Department department) {
        this.empName = empName;
        this.empBirth = empBirth;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empAdress = empAdress;
        this.empJobtitle = empJobtitle;
        this.empPosition = empPosition;
        this.empJdate = empJdate;
        this.empQdate = empQdate;
        this.empQuitYn = empQuitYn;
        this.empStatus = empStatus;
        this.department = department;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
