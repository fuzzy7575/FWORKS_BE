package com.ohgiraffers.fworks.messenger.domain.entity;

import com.ohgiraffers.fworks.messenger.domain.type.ChrStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatroom")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chrNo;
    private int chrTitle;
    private String chrMessage;

    @CreatedDate
    private LocalDateTime chrCdatetime;
    @LastModifiedDate
    private LocalDateTime chrMdatetime;
    @Enumerated(value = EnumType.STRING)
    private ChrStatus chrStatus = ChrStatus.ACTIVE;

}
