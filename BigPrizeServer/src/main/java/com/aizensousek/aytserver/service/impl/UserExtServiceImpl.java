package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.UserExtDao;
import com.aizensousek.aytserver.entity.UserExt;
import com.aizensousek.aytserver.service.UserExtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户扩展字段表(UserExt)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@Service("userExtService")
@SuppressWarnings("unused")
public class UserExtServiceImpl implements UserExtService {
    @Resource
    private UserExtDao userExtDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserExt queryById(String id) {
        return this.userExtDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userExt     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserExt> queryByPage(UserExt userExt, PageRequest pageRequest) {
        long total = this.userExtDao.count(userExt);
        return new PageImpl<>(this.userExtDao.queryAllByLimit(userExt, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userExt 实例对象
     * @return 实例对象
     */
    @Override
    public UserExt insert(UserExt userExt) {
        this.userExtDao.insert(userExt);
        return userExt;
    }

    /**
     * 修改数据
     *
     * @param userExt 实例对象
     * @return 实例对象
     */
    @Override
    public UserExt update(UserExt userExt) {
        this.userExtDao.update(userExt);
        return this.queryById(userExt.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userExtDao.deleteById(id) > 0;
    }
}