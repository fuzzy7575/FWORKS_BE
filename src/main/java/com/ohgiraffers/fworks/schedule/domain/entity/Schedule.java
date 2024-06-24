package com.ohgiraffers.fworks.schedule.domain.entity;

import com.ohgiraffers.fworks.employee.domain.entity.Department;
import com.ohgiraffers.fworks.member.domain.entity.Member;
import com.ohgiraffers.fworks.schedule.domain.type.SchStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE schedule SET sch_status = 'DELETED' WHERE sch_no = ?")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schNo;
    private String schName;
    private String schPlace;
    private String schDescription;
    @CreatedDate
    private LocalDateTime schSdatetime;
    @CreatedDate
    private LocalDateTime schEdatetime;
    private String schAllday;
    private String schSharing;
    private String schColor;
    private String schWriter;
//    private String prjNo;

    @CreatedDate
    private LocalDateTime schWdate;

    @Enumerated(value = EnumType.STRING)
    private SchStatus schStatus = SchStatus.ACTIVE;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "schNo")
    private List<Member> schMember;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "prjNo")
    private List<Member>  prjMember;


    private Schedule(String schName, String schPlace, String schDescription, LocalDateTime schSdatetime, LocalDateTime schEdatetime, String schAllday, String schSharing, String schColor, String schWriter) {
        this.schName = schName;
        this.schPlace = schPlace;
        this.schDescription = schDescription;
        this.schSdatetime = schSdatetime;
        this.schEdatetime = schEdatetime;
        this.schAllday = schAllday;
        this.schSharing = schSharing;
        this.schColor = schColor;
        this.schWriter = schWriter;
    }

    public static Schedule of(String schName, String schPlace, String schDescription, LocalDateTime schSdatetime, LocalDateTime schEdatetime, String schAllday, String schSharing, String schColor, String schWriter) {
        return new Schedule(
                schName,
                schPlace,
                schDescription,
                schSdatetime,
                schEdatetime,
                schAllday,
                schSharing,
                schColor,
                schWriter
        );
    }


    public void modify(String schName, String schPlace, String schDescription, LocalDateTime schSdatetime, LocalDateTime schEdatetime, String schAllday, String schSharing, String schColor, String schWriter, SchStatus schStatus) {
        this.schName = schName;
        this.schPlace = schPlace;
        this.schDescription = schDescription;
        this.schSdatetime = schSdatetime;
        this.schEdatetime = schEdatetime;
        this.schAllday = schAllday;
        this.schSharing = schSharing;
        this.schColor = schColor;
        this.schWriter = schWriter;
        this.schStatus = schStatus;
    }
}
