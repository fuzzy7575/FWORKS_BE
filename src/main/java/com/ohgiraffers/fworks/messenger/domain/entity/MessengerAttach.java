package com.ohgiraffers.fworks.messenger.domain.entity;

import com.ohgiraffers.fworks.messenger.domain.type.MattStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "messenger_attach")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class MessengerAttach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mattNo;
    private int refChrNo;
    private String mattOriginalName;
    private String mattSavedName;
    private String mattSavePath;
    private String mattFileType;

    @CreatedDate
    private LocalDateTime mattUdatetime;
    @Enumerated(value = EnumType.STRING)
    private MattStatus mattStatus = MattStatus.ACTIVE;

}
