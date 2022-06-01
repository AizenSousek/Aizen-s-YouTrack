package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.UserExt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户扩展字段表(UserExt)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
public interface UserExtService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserExt queryById(String id);

    /**
     * 分页查询
     *
     * @param userExt     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<UserExt> queryByPage(UserExt userExt, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userExt 实例对象
     * @return 实例对象
     */
    UserExt insert(UserExt userExt);

    /**
     * 修改数据
     *
     * @param userExt 实例对象
     * @return 实例对象
     */
    UserExt update(UserExt userExt);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}