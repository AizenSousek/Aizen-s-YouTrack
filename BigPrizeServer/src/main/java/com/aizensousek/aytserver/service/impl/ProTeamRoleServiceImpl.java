package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.ProTeamRoleDao;
import com.aizensousek.aytserver.entity.ProTeamRole;
import com.aizensousek.aytserver.service.ProTeamRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目角色信息表(ProTeamRole)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@Service("proTeamRoleService")
@SuppressWarnings("unused")
public class ProTeamRoleServiceImpl implements ProTeamRoleService {
    @Resource
    private ProTeamRoleDao proTeamRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProTeamRole queryById(String id) {
        return this.proTeamRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param proTeamRole 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProTeamRole> queryByPage(ProTeamRole proTeamRole, PageRequest pageRequest) {
        long total = this.proTeamRoleDao.count(proTeamRole);
        return new PageImpl<>(this.proTeamRoleDao.queryAllByLimit(proTeamRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param proTeamRole 实例对象
     * @return 实例对象
     */
    @Override
    public ProTeamRole insert(ProTeamRole proTeamRole) {
        this.proTeamRoleDao.insert(proTeamRole);
        return proTeamRole;
    }

    /**
     * 修改数据
     *
     * @param proTeamRole 实例对象
     * @return 实例对象
     */
    @Override
    public ProTeamRole update(ProTeamRole proTeamRole) {
        this.proTeamRoleDao.update(proTeamRole);
        return this.queryById(proTeamRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.proTeamRoleDao.deleteById(id) > 0;
    }
}