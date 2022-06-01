package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.ProRoleTeamUserDao;
import com.aizensousek.aytserver.entity.ProRoleTeamUser;
import com.aizensousek.aytserver.service.ProRoleTeamUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目团队信息表(ProRoleTeamUser)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@Service("proRoleTeamUserService")
public class ProRoleTeamUserServiceImpl implements ProRoleTeamUserService {
    @Resource
    private ProRoleTeamUserDao proRoleTeamUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProRoleTeamUser queryById(String id) {
        return this.proRoleTeamUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param proRoleTeamUser 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProRoleTeamUser> queryByPage(ProRoleTeamUser proRoleTeamUser, PageRequest pageRequest) {
        long total = this.proRoleTeamUserDao.count(proRoleTeamUser);
        return new PageImpl<>(this.proRoleTeamUserDao.queryAllByLimit(proRoleTeamUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 实例对象
     */
    @Override
    public ProRoleTeamUser insert(ProRoleTeamUser proRoleTeamUser) {
        this.proRoleTeamUserDao.insert(proRoleTeamUser);
        return proRoleTeamUser;
    }

    /**
     * 修改数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 实例对象
     */
    @Override
    public ProRoleTeamUser update(ProRoleTeamUser proRoleTeamUser) {
        this.proRoleTeamUserDao.update(proRoleTeamUser);
        return this.queryById(proRoleTeamUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.proRoleTeamUserDao.deleteById(id) > 0;
    }
}