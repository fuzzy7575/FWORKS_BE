package com.ohgiraffers.fworks.document.domain.entity;

import com.ohgiraffers.fworks.document.domain.type.DocStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docNo;
    private String docName;
    private String docKind;
    private String docDescription;

    @CreatedDate
    private LocalDateTime docWdate;
    @Enumerated(value = EnumType.STRING)
    private DocStatus docStatus = DocStatus.ACTIVE;

}
