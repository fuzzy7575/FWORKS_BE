package com.ohgiraffers.fworks.member.domain.entity;

import com.ohgiraffers.fworks.member.domain.type.MemStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    private Long memNo;
    private String memDivision;
    private String memType;
    private Long empNo;
    private Long depPhase;
    @CreatedDate
    private LocalDateTime memWdate;
    @Enumerated(value = EnumType.STRING)
    private MemStatus memStatus = MemStatus.ACTIVE;

    private Long schNo;
    private Long prjNo;
    private Long workNo;
    private Long docNo;

}
