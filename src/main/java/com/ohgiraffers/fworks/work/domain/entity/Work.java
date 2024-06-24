package com.ohgiraffers.fworks.work.domain.entity;

import com.ohgiraffers.fworks.work.domain.type.WorkStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "work")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workNo;
    private String workName;
    private String workImportance;
    private String workDescription;
    private LocalDateTime workSdatetime;
    private LocalDateTime workEdatetime;
    private String workSharing;
    private String workProgress;

    @CreatedDate
    private LocalDateTime workWdate;
    @Enumerated(value = EnumType.STRING)
    private WorkStatus workStatus = WorkStatus.ACTIVE;

}
