package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * 项目团队信息表(ProRoleTeamUser)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
public class ProRoleTeamUser implements Serializable {
    private static final long serialVersionUID = 749002358107287101L;
    /**
     * 项目团队关系ID
     */
    private String id;
    /**
     * 关联的项目ID
     */
    private String proId;
    /**
     * 关联的角色ID
     */
    private String roleId;
    /**
     * 关联的用户ID
     */
    private String userId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}