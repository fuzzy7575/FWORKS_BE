package com.ohgiraffers.fworks.alarm.domain.entity;

import com.ohgiraffers.fworks.alarm.domain.type.AlmStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "alarm")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int almNo;
    private String almRecipient;
    private String almCreater;
    private String almCode;
    private String almMessage;
    private String almCheckYn;
    private LocalDateTime almRdatetime;

    @CreatedDate
    private LocalDateTime almCdatetime;
    @Enumerated(value = EnumType.STRING)
    private AlmStatus almStatus = AlmStatus.ACTIVE;

}
