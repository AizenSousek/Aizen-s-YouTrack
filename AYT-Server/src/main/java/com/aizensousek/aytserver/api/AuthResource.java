package com.aizensousek.aytserver.api;

import com.aizensousek.aytserver.domain.ResultCode;
import com.aizensousek.aytserver.domain.ResultJson;
import com.aizensousek.aytserver.domain.auth.ResponseUserToken;
import com.aizensousek.aytserver.domain.auth.Role;
import com.aizensousek.aytserver.domain.auth.User;
import com.aizensousek.aytserver.domain.auth.UserDetail;
import com.aizensousek.aytserver.service.AuthService;
import com.aizensousek.aytserver.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 权限以及用户管理API
 *
 * @author aizensousek
 * @since 2022年06月01日 16:20:38
 */
@RestController
@RequestMapping("/auth")
@SuppressWarnings({"rawtypes", "unused"})
public class AuthResource {
    @Value("${jwt.header}")
    private String tokenHeader;

    private final AuthService authService;
    private final SysRoleService roleService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthResource(AuthService authService, SysRoleService roleService) {
        this.authService = authService;
        this.roleService = roleService;
    }


    /**
     * 登录
     *
     * @param user 用户
     * @return {@link ResultJson}
     */
    @PostMapping(value = "/login")
    public ResultJson login(
            @Valid @RequestBody User user) {
        final ResponseUserToken response = authService.login(user.getName(), user.getPassword());
        return ResultJson.ok(response);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return {@link ResultJson}
     */
    @GetMapping(value = "/logout")
    public ResultJson logout(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultJson.ok();
    }

    /**
     * 获取用户
     *
     * @param request 请求
     * @return {@link ResultJson}
     */
    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    @PreAuthorize("hasRole('USER')")
    public ResultJson getUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        UserDetail userDetail = authService.getUserByToken(token);
        logger.info("userDetail:" + userDetail);
        return ResultJson.ok(userDetail);
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return {@link ResultJson}
     */
    @PostMapping(value = "/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultJson register(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getName(), user.getPassword())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        UserDetail userDetail = new UserDetail(user.getName(), user.getPassword(), Role.builder().id(1L).build());
        return ResultJson.ok(authService.register(userDetail));
    }

    /**
     * 刷新并且身份验证令牌
     *
     * @param request 请求
     * @return {@link ResultJson}
     */
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


    /**
     * 心跳
     *
     * @return {@link ResultJson}
     */
    @GetMapping(value = "/hreatbeats")
    public ResultJson heartbeats() {
        return ResultJson.ok("success");
    }
}