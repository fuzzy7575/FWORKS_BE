package com.ohgiraffers.fworks.schedule.dto.response;

import com.ohgiraffers.fworks.schedule.domain.entity.Schedule;
import com.ohgiraffers.fworks.schedule.domain.type.SchStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class MyScheduleResponse {

    private final Long schNo;
    private final String schName;
    private final String schPlace;
    private final String schDescription;
    private final LocalDateTime schSdatetime;
    private final LocalDateTime schEdatetime;
    private final String schAllday;
    private final String schSharing;
    private final String schColor;
    private final String schWriter;
    private final LocalDateTime schWdate;
    private final SchStatus schStatus;

    public static MyScheduleResponse from(Schedule schedule) {

        return new MyScheduleResponse(
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
