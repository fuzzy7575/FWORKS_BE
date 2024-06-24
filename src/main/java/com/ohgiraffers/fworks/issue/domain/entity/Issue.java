package com.ohgiraffers.fworks.issue.domain.entity;

import com.ohgiraffers.fworks.issue.domain.type.IsuStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "issue")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isuNo;
    private String isuDivision;
    private String isuComments;
    private String isuWriter;

    @CreatedDate
    private LocalDateTime isuWdate;
    @Enumerated(value = EnumType.STRING)
    private IsuStatus isuStatus = IsuStatus.ACTIVE;

    private int docNo;
    private int workNo;
}
