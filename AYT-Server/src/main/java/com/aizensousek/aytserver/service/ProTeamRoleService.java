package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.ProTeamRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目角色信息表(ProTeamRole)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:52
 */
@SuppressWarnings("unused")
public interface ProTeamRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProTeamRole queryById(String id);

    /**
     * 分页查询
     *
     * @param proTeamRole 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<ProTeamRole> queryByPage(ProTeamRole proTeamRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param proTeamRole 实例对象
     * @return 实例对象
     */
    ProTeamRole insert(ProTeamRole proTeamRole);

    /**
     * 修改数据
     *
     * @param proTeamRole 实例对象
     * @return 实例对象
     */
    ProTeamRole update(ProTeamRole proTeamRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}