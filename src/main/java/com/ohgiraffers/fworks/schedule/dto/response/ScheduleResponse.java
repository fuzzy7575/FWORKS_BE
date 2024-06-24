package com.ohgiraffers.fworks.schedule.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ohgiraffers.fworks.schedule.domain.entity.Schedule;
import com.ohgiraffers.fworks.schedule.domain.type.SchStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduleResponse {

    private final Long schNo;
    private final String schName;
    private final String schPlace;
    private final String schDescription;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime schSdatetime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime schEdatetime;
    private final String schAllday;
    private final String schSharing;
    private final String schColor;
    private final String schWriter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime schWdate;
    private final SchStatus schStatus;

    public static ScheduleResponse from(Schedule schedule) {

        return new ScheduleResponse(
                schedule.getSchNo(),
                schedule.getSchName(),
                schedule.getSchPlace(),
                schedule.getSchDescription(),
                schedule.getSchSdatetime(),
                schedule.getSchEdatetime(),
                schedule.getSchAllday(),
                schedule.getSchSharing(),
                schedule.getSchColor(),
                schedule.getSchWriter(),
                schedule.getSchWdate(),
                schedule.getSchStatus()
        );

    }

}