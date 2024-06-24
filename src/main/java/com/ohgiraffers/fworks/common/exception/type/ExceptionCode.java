package com.ohgiraffers.fworks.common.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {
    FAIL_TO_UPLOAD_FILE(1001, "파일 저장에 실패하였습니다."),
    FAIL_TO_DELETE_FILE(1002, "파일 삭제에 실패하였습니다."),
    NOT_FOUND_DEPARTMENT_NO(2000, "부서번호에 해당하는 부서가 존재하지 않습니다."),
    NOT_FOUND_PROJECT_NO(3000, "프로젝트 번호에 해당하는 프로젝트가 존재하지 않습니다."),
    NOT_FOUND_SCHEDULE_NO(5000, "일정 번호에 해당하는 일정이 존재하지 않습니다."),
    FAIL_LOGIN(4000, "로그인에 실패하였습니다."),
    NOT_FOUND_REFRESH_TOKEN(4001, "해당 리프레시 토큰이 유효하지 않습니다."),
    UNAUTHORIZED(4002, "인증 되지 않은 요청입니다."),
    ACCESS_DENIED(4003, "허가 되지 않은 요청입니다."),

    ALREADY_EXIST_REVIEW(6000, "해당 주문 건에 이미 작성 된 리뷰가 있습니다.");

    private final int code;
    private final String message;
}
