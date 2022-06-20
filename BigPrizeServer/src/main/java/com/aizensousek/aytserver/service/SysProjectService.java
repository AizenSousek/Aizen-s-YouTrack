package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.SysProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目基本信息表(SysProject)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public interface SysProjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysProject queryById(String id);

    /**
     * 分页查询
     *
     * @param sysProject  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysProject> queryByPage(SysProject sysProject, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysProject 实例对象
     * @return 实例对象
     */
    SysProject insert(SysProject sysProject);

    /**
     * 修改数据
     *
     * @param sysProject 实例对象
     * @return 实例对象
     */
    SysProject update(SysProject sysProject);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}