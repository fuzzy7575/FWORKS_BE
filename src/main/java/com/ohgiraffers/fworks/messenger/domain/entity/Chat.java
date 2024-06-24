package com.ohgiraffers.fworks.messenger.domain.entity;

import com.ohgiraffers.fworks.messenger.domain.type.ChtStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chtNo;
    private int refChrNo;
    private String chtMessage;

    @CreatedDate
    private LocalDateTime chtCdatetime;
    @Enumerated(value = EnumType.STRING)
    private ChtStatus chtStatus = ChtStatus.ACTIVE;

}
