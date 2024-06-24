package com.ohgiraffers.fworks.schedule.service;

import com.ohgiraffers.fworks.common.exception.NotFoundException;
import com.ohgiraffers.fworks.common.exception.type.ExceptionCode;
import com.ohgiraffers.fworks.schedule.domain.entity.Schedule;
import com.ohgiraffers.fworks.schedule.dto.request.ScheduleRegistRequest;
import com.ohgiraffers.fworks.schedule.dto.request.ScheduleUpdateRequest;
import com.ohgiraffers.fworks.schedule.dto.response.ScheduleResponse;
import com.ohgiraffers.fworks.schedule.dto.response.MyScheduleResponse;
import com.ohgiraffers.fworks.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ohgiraffers.fworks.schedule.domain.type.SchStatus.DELETED;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private Pageable getPageable(final Integer page) {
        return PageRequest.of(page - 1, 10, Sort.by("schNo").descending());
    }

    /* 일정 조회 */
    @Transactional(readOnly = true)
    public Page<ScheduleResponse> getSchedules(final Integer page) {

        Page<Schedule> schedules = scheduleRepository.findBySchStatusNot(getPageable(page), DELETED);

        return schedules.map(ScheduleResponse::from);

    }

    /* 일정 등록 */
    public void regist(ScheduleRegistRequest scheduleRegistRequest) {
//
//        Department department = departmentRepository.findById(employeeRegistRequest.getDepNo())
//                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_DEPARTMENT_NO));

        final Schedule schedule = Schedule.of(
                scheduleRegistRequest.getSchName(),
                scheduleRegistRequest.getSchPlace(),
                scheduleRegistRequest.getSchDescription(),
                scheduleRegistRequest.getSchSdatetime(),
                scheduleRegistRequest.getSchEdatetime(),
                scheduleRegistRequest.getSchAllday(),
                scheduleRegistRequest.getSchSharing(),
                scheduleRegistRequest.getSchColor(),
                scheduleRegistRequest.getSchWriter()

        );

        scheduleRepository.save(schedule);
    }

    /* 일정 수정 */
    public void modify(Long schNo, ScheduleUpdateRequest scheduleUpdateRequest) {

        Schedule schedule = scheduleRepository.findBySchNo(schNo)
                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_SCHEDULE_NO));

//        Department department = departmentRepository.findById(employeeUpdateRequest.getDepNo())
//                .orElseThrow(() -> new NotFoundException(ExceptionCode.NOT_FOUND_DEPARTMENT_NO));

        /* 수정을 위해 엔터티 정보 변경 */
        schedule.modify(
                scheduleUpdateRequest.getSchName(),
                scheduleUpdateRequest.getSchPlace(),
                scheduleUpdateRequest.getSchDescription(),
                scheduleUpdateRequest.getSchSdatetime(),
                scheduleUpdateRequest.getSchEdatetime(),
                scheduleUpdateRequest.getSchAllday(),
                scheduleUpdateRequest.getSchSharing(),
                scheduleUpdateRequest.getSchColor(),
                scheduleUpdateRequest.getSchWriter(),
                scheduleUpdateRequest.getSchStatus()
        );

    }

    /* 일정 삭제 */
    public void remove(Long schNo) {

        scheduleRepository.deleteById(schNo);
    }

//    /* 나의 일정 조회 */
//    @Transactional(readOnly = true)
//    public MyScheduleResponse getMySchedule(String empId) {
//
//        Schedule schedule = scheduleRepository.findByEmpId(empId)
//                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디가 존재하지 않습니다."));
//
//        return MyScheduleResponse.from(schedule);
//
//    }

}
