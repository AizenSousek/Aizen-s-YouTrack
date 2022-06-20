package com.aizensousek.bigprize.service;


import com.aizensousek.bigprize.domain.auth.ResponseUserToken;
import com.aizensousek.bigprize.domain.auth.UserDetail;

public interface AuthService {
    /**
     * 注册用户
     *
     * @param userDetail 用户信息
     * @return 用户信息
     */
    UserDetail register(UserDetail userDetail);

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 授权token
     */
    ResponseUserToken login(String username, String password);


    /**
     * 刷新Token
     *
     * @param oldToken 旧的token
     * @return 授权token
     */
    ResponseUserToken refresh(String oldToken);


    /**
     * 登出
     *
     * @param token token
     */
    void logout(String token);


    /**
     * 根据Token获取用户信息
     *
     * @param token token信息
     * @return 用户信息
     */
    UserDetail getUserByToken(String token);
}