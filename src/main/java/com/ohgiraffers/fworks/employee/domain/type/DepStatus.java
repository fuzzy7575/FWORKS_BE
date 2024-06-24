package com.ohgiraffers.fworks.employee.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DepStatus {
//    ACTIVE, NONACTIVE, DELETED
    ACTIVE("ACTIVE"), NONACTIVE("NONACTIVE"), DELETED("DELETED");

    private final String value;

    DepStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public DepStatus from(String value) {
        for(DepStatus status : DepStatus.values()) {
            if(status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() { return value; }
}
