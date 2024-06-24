package com.ohgiraffers.fworks.common.exception;

import com.ohgiraffers.fworks.common.exception.type.ExceptionCode;
import lombok.Getter;

@Getter
public class NotFoundException extends CustomException {
    public NotFoundException(final ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
