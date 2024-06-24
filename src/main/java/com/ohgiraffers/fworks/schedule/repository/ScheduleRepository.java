package com.ohgiraffers.fworks.schedule.repository;

import com.ohgiraffers.fworks.schedule.domain.entity.Schedule;
import com.ohgiraffers.fworks.schedule.domain.type.SchStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

//    /* 사원 아이디로 조회 */
//    Optional<Schedule> findByEmpId(String empId);

    /* 일정 번호로 조회 */
    Optional<Schedule> findBySchNo(Long schNo);

    /* 일정 조회 : 페이징, 삭제 설정된 일정 포함 */
//    @EntityGraph(attributePaths = {"department"})
    Page<Schedule> findBySchStatusNot(Pageable pageable, SchStatus schStatus);
}
