package com.ohgiraffers.fworks.employee.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmpStatus {
//    ACTIVE, NONACTIVE, DELETED
    ACTIVE("ACTIVE"), NONACTIVE("NONACTIVE"), DELETED("DELETED");

    private final String value;

    EmpStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public EmpStatus from(String value) {
        for(EmpStatus empStatus : EmpStatus.values()) {
            if(empStatus.getValue().equals(value)) {
                return empStatus;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() { return value; }
}
