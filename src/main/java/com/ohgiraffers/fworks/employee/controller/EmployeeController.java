package com.ohgiraffers.fworks.employee.controller;

import com.ohgiraffers.fworks.common.paging.Pagenation;
import com.ohgiraffers.fworks.common.paging.PagingButtonInfo;
import com.ohgiraffers.fworks.common.paging.PagingResponse;
import com.ohgiraffers.fworks.employee.dto.request.EmployeeRegistRequest;
import com.ohgiraffers.fworks.employee.dto.request.EmployeeUpdateRequest;
import com.ohgiraffers.fworks.employee.dto.response.EmployeeResponse;
import com.ohgiraffers.fworks.employee.dto.response.MypageResponse;
import com.ohgiraffers.fworks.employee.service.EmployeeService;
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
public class EmployeeController {

    private final EmployeeService employeeService;

    /* 사원 목록 조회 (관리자) */
    @GetMapping("/employees")
    public ResponseEntity<PagingResponse> getEmployees(
            @RequestParam(defaultValue = "1") final Integer page
    ) {

        final Page<EmployeeResponse> employees = employeeService.getEmployees(page);
        final PagingButtonInfo pagingButtonInfo = Pagenation.getPagingButtonInfo(employees);
        final PagingResponse pagingResponse = PagingResponse.of(employees.getContent(), pagingButtonInfo);

        return ResponseEntity.ok(pagingResponse);
    }

    /* 사원 등록 */
    @PostMapping("/employees/regist")
    public ResponseEntity<Void> regist(@RequestBody @Valid EmployeeRegistRequest employeeRegistRequest) {

        employeeService.regist(employeeRegistRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* 사원 수정 */
    @PutMapping("/employees/{empNo}")
    public ResponseEntity<Void> modify(
            @PathVariable final Long empNo,
            @RequestBody @Valid final EmployeeUpdateRequest employeeUpdateRequest
    ) {

        employeeService.modify(empNo, employeeUpdateRequest);

        return ResponseEntity.created(URI.create("/api/v1/employees/" + empNo)).build();
    }

    /* 사원 삭제 */
    @DeleteMapping("/employees/{empNo}")
    public ResponseEntity<Void> remove(@PathVariable final Long empNo) {

        employeeService.remove(empNo);

        return ResponseEntity.noContent().build();
    }

    /* 인증 테스트를 위한 메소드 */
    @GetMapping("/employees/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test 응답 완료");
    }

    /* 마이페이지 조회 */
    @GetMapping("/employees/{empId}")
    @PreAuthorize("#empId == authentication.principal.username")
//    @PostAuthorize("returnObject.writer == authentication.principal.username")
    public ResponseEntity<MypageResponse> getMypage(@PathVariable String empId) {

        MypageResponse mypageResponse = employeeService.getMypage(empId);

        return ResponseEntity.ok(mypageResponse);
    }

    /* 로그아웃 시 DB 토큰 무효화 */
    @PostMapping("/employees/logout")
    public ResponseEntity<Void> logout(@AuthenticationPrincipal UserDetails userDetails) {

        employeeService.updateRefreshToken(userDetails.getUsername(), null);

        return ResponseEntity.ok().build();
    }

}
