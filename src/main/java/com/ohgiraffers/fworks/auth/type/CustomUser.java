package com.ohgiraffers.fworks.auth.type;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


@Getter
public class CustomUser extends User {
    private Long empNo;
    public CustomUser(Long empNo, UserDetails userDetails) {
        super(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        this.empNo = empNo;
    }
}
