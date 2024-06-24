package com.ohgiraffers.fworks.messenger.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "chatroom_emp")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ChatroomEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chgNo;
    private int refChrNo;
    private int refEmpNo;

}
