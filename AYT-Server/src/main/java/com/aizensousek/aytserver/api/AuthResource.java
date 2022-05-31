package com.aizensousek.aytserver.api;

import com.aizensousek.aytserver.domain.ResultCode;
import com.aizensousek.aytserver.domain.ResultJson;
import com.aizensousek.aytserver.domain.auth.ResponseUserToken;
import com.aizensousek.aytserver.domain.auth.Role;
import com.aizensousek.aytserver.domain.auth.User;
import com.aizensousek.aytserver.domain.auth.UserDetail;
import com.aizensousek.aytserver.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class AuthResource {
    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthService authService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResultJson login(
            @Valid @RequestBody User user) {
        final ResponseUserToken response = authService.login(user.getName(), user.getPassword());
        return ResultJson.ok(response);
    }

    @GetMapping(value = "/logout")
    public ResultJson logout(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultJson.ok();
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultJson getUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        UserDetail userDetail = authService.getUserByToken(token);
        logger.info("userDetail:" + userDetail);
        return ResultJson.ok(userDetail);
    }

    @PostMapping(value = "/sign")
    public ResultJson sign(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getName(), user.getPassword())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        UserDetail userDetail = new UserDetail(user.getName(), user.getPassword(), Role.builder().id(1L).build());
        return ResultJson.ok(authService.register(userDetail));
    }

    @GetMapping(value = "refresh")
    public ResultJson refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        ResponseUserToken response = authService.refresh(token);
        System.out.println("response:" + response);
        if (response == null) {
            return ResultJson.failure(ResultCode.BAD_REQUEST, "token无效");
        } else {
            return ResultJson.ok(response);
        }
    }


    @GetMapping(value = "/current")
    public ResultJson current() {
        return ResultJson.ok("success");
    }
}