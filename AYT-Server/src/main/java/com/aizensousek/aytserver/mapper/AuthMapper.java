package com.aizensousek.aytserver.mapper;

import com.aizensousek.aytserver.domain.auth.Role;
import com.aizensousek.aytserver.domain.auth.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthMapper {
    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     * @return 用户信息
     */
    UserDetail findByUsername(@Param("name") String name);

    /**
     * 创建新用户
     *
     * @param userDetail 用户基本信息
     */
    void insert(UserDetail userDetail);

    /**
     * 创建用户角色
     *
     * @param userId 用户ID
     * @param roleId 用户角色ID
     */
    void insertRole(@Param("userId") long userId, @Param("roleId") long roleId);

    /**
     * 根据角色id查找角色
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    Role findRoleById(@Param("roleId") long roleId);

    /**
     * 根据用户id查找该用户角色
     *
     * @param userId 用户id
     * @return 用户角色信息
     */
    Role findRoleByUserId(@Param("userId") long userId);
}