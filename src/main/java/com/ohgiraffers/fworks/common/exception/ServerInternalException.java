package com.ohgiraffers.fworks.common.exception;

import com.ohgiraffers.fworks.common.exception.type.ExceptionCode;
import lombok.Getter;

@Getter
public class ServerInternalException extends CustomException {
    public ServerInternalException(final ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
