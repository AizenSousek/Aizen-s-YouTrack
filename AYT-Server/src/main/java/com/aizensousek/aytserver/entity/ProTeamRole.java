package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * 项目角色信息表(ProTeamRole)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:52
 */
@SuppressWarnings("unused")
public class ProTeamRole implements Serializable {
    private static final long serialVersionUID = 397499884234147093L;
    /**
     * 项目团队角色关系ID
     */
    private String id;
    /**
     * 项目ID
     */
    private String proId;
    /**
     * 角色ID
     */
    private String roleId;


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

}