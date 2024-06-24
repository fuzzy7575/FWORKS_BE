package com.ohgiraffers.fworks.auth.service;

import com.ohgiraffers.fworks.auth.dto.LoginDto;
import com.ohgiraffers.fworks.auth.dto.TokenDto;
import com.ohgiraffers.fworks.auth.type.CustomUser;
import com.ohgiraffers.fworks.auth.util.TokenUtils;
import com.ohgiraffers.fworks.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {

        LoginDto loginDto = employeeService.findByEmpId(empId);

        return User.builder()
                .username(loginDto.getEmpId())
                .password(loginDto.getEmpPw())
                .roles(loginDto.getEmpRole().name())
                .build();
    }

    public void updateRefreshToken(String empId, String refreshToken) {
        employeeService.updateRefreshToken(empId, refreshToken);
    }

    public TokenDto checkRefreshTokenAndReIssueToken(String refreshToken) {

        LoginDto loginDto = employeeService.findByRefreshToken(refreshToken);
        String reIssuedRefreshToken = TokenUtils.createRefreshToken();
        String reIssuedAccessToken = TokenUtils.createAccessToken(getEmpInfo(loginDto));
        employeeService.updateRefreshToken(loginDto.getEmpId(), reIssuedRefreshToken);
        return TokenDto.of(reIssuedAccessToken, reIssuedRefreshToken);
    }

    private Map<String,Object> getEmpInfo(LoginDto loginDto) {
        return Map.of(
                "empId", loginDto.getEmpId(),
                "empRole", "ROLE_" + loginDto.getEmpRole()
        );
    }

    public void saveAuthentication(String empId) {

        LoginDto loginDto = employeeService.findByEmpId(empId);

        UserDetails user = User.builder()
            .username(loginDto.getEmpId())
            .password(loginDto.getEmpPw())
            .roles(loginDto.getEmpRole().name())
            .build();

        CustomUser customUser = new CustomUser(loginDto.getEmpNo(), user);

        Authentication authentication
                = new UsernamePasswordAuthenticationToken(customUser, null, customUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
