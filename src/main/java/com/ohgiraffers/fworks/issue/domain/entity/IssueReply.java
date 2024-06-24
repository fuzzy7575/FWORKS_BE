package com.ohgiraffers.fworks.issue.domain.entity;

import com.ohgiraffers.fworks.issue.domain.type.IsrStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "issue_reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class IssueReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isrNo;
    private int refIsuNo;
    private String isrComments;
    private String isrWriter;

    @CreatedDate
    private LocalDateTime isrWdate;
    @Enumerated(value = EnumType.STRING)
    private IsrStatus isrStatus = IsrStatus.ACTIVE;

}
