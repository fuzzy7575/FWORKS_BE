package com.ohgiraffers.fworks.employee.domain.entity;

import com.ohgiraffers.fworks.employee.domain.type.DepStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Department {

    @Id
    private Long depNo;
    private String depCode;
    private String depName;
    private Long depSort;
    private Long depPhase;
    @CreatedDate
    private LocalDateTime depWdate;
    @Enumerated(value = EnumType.STRING)
    private DepStatus depStatus = DepStatus.ACTIVE;

}
