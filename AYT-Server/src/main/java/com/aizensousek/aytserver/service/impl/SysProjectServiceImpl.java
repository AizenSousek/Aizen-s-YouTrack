package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.SysProjectDao;
import com.aizensousek.aytserver.entity.SysProject;
import com.aizensousek.aytserver.service.SysProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目基本信息表(SysProject)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
@Service("sysProjectService")
public class SysProjectServiceImpl implements SysProjectService {
    @Resource
    private SysProjectDao sysProjectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysProject queryById(String id) {
        return this.sysProjectDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysProject  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysProject> queryByPage(SysProject sysProject, PageRequest pageRequest) {
        long total = this.sysProjectDao.count(sysProject);
        return new PageImpl<>(this.sysProjectDao.queryAllByLimit(sysProject, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysProject 实例对象
     * @return 实例对象
     */
    @Override
    public SysProject insert(SysProject sysProject) {
        this.sysProjectDao.insert(sysProject);
        return sysProject;
    }

    /**
     * 修改数据
     *
     * @param sysProject 实例对象
     * @return 实例对象
     */
    @Override
    public SysProject update(SysProject sysProject) {
        this.sysProjectDao.update(sysProject);
        return this.queryById(sysProject.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sysProjectDao.deleteById(id) > 0;
    }
}