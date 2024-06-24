package com.ohgiraffers.fworks.schedule.controller;

import com.ohgiraffers.fworks.common.paging.Pagenation;
import com.ohgiraffers.fworks.common.paging.PagingButtonInfo;
import com.ohgiraffers.fworks.common.paging.PagingResponse;
import com.ohgiraffers.fworks.schedule.dto.request.ScheduleRegistRequest;
import com.ohgiraffers.fworks.schedule.dto.request.ScheduleUpdateRequest;
import com.ohgiraffers.fworks.schedule.dto.response.MyScheduleResponse;
import com.ohgiraffers.fworks.schedule.dto.response.ScheduleResponse;
import com.ohgiraffers.fworks.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /* 일정 조회 */
    @GetMapping("/schedules")
    public ResponseEntity<PagingResponse> getSchedules(
            @RequestParam(defaultValue = "1") final Integer page
    ) {

        final Page<ScheduleResponse> schedules = scheduleService.getSchedules(page);
        final PagingButtonInfo pagingButtonInfo = Pagenation.getPagingButtonInfo(schedules);
        final PagingResponse pagingResponse = PagingResponse.of(schedules.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    /* 일정 등록 */
    @PostMapping("/schedules/regist")
    public ResponseEntity<Void> regist(@RequestBody @Valid ScheduleRegistRequest scheduleRegistRequest) {

        scheduleService.regist(scheduleRegistRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* 일정 수정 */
    @PutMapping("/schedules/{schNo}")
    public ResponseEntity<Void> modify(
            @PathVariable final Long schNo,
            @RequestBody @Valid final ScheduleUpdateRequest scheduleUpdateRequest
    ) {


        log.info("Received scheduleUpdateRequest: {}", scheduleUpdateRequest);
        scheduleService.modify(schNo, scheduleUpdateRequest);

        return ResponseEntity.created(URI.create("/api/v1/schedules/" + schNo)).build();
    }

    /* 일정 삭제 */
    @DeleteMapping("/schedules/{schNo}")
    public ResponseEntity<Void> remove(@PathVariable final Long schNo) {

        scheduleService.remove(schNo);

        return ResponseEntity.noContent().build();
    }

//    /* 나의 일정 조회 */
//    @GetMapping("/schedules/{empId}")
//    @PreAuthorize("#empId == authentication.principal.username")
////    @PostAuthorize("returnObject.writer == authentication.principal.username")
//    public ResponseEntity<MyScheduleResponse> getMySchedule(@PathVariable String empId) {
//
//        MyScheduleResponse myScheduleResponse = scheduleService.getMySchedule(empId);
//
//        return ResponseEntity.ok(myScheduleResponse);
//    }

}
