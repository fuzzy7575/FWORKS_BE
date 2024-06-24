package com.ohgiraffers.fworks.project.domain.entity;

import com.ohgiraffers.fworks.project.domain.type.PrjStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "project")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prjNo;
    private String prjCode;
    private String prjName;
    private String prjSeason;
    private String prjDescription;
    private LocalDateTime prjSdatetime;
    private LocalDateTime prjEdatetime;
    private String prjSharing;

    @CreatedDate
    private LocalDateTime prjWdate;

    @Enumerated(value = EnumType.STRING)
    private PrjStatus prjStatus = PrjStatus.ACTIVE;

}
