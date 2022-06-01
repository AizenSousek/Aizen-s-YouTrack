package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.ProRoleTeamUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目团队信息表(ProRoleTeamUser)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
public interface ProRoleTeamUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProRoleTeamUser queryById(String id);

    /**
     * 分页查询
     *
     * @param proRoleTeamUser 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<ProRoleTeamUser> queryByPage(ProRoleTeamUser proRoleTeamUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 实例对象
     */
    ProRoleTeamUser insert(ProRoleTeamUser proRoleTeamUser);

    /**
     * 修改数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 实例对象
     */
    ProRoleTeamUser update(ProRoleTeamUser proRoleTeamUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}