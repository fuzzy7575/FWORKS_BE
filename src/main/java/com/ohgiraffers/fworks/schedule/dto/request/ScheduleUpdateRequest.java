package com.ohgiraffers.fworks.schedule.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ohgiraffers.fworks.schedule.domain.type.SchStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequest {

    @NotNull
    private final String schName;
    private final String schPlace;
    private final String schDescription;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime schSdatetime;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime schEdatetime;
    private final String schAllday;
    @NotNull
    private final String schSharing;
    private final String schColor;
    @NotNull
    private final String schWriter;
    //    private final String prjNo;
    @NotNull
    private final SchStatus schStatus;

}
