package com.ohgiraffers.fworks.common.exception;

import com.ohgiraffers.fworks.common.exception.type.ExceptionCode;
import lombok.Getter;

@Getter
public class ConflictException extends CustomException {
    public ConflictException(final ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
