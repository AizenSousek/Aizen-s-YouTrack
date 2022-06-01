package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.SysDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (SysDict)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:19
 */
public interface SysDictService {

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    SysDict queryById(String keyId);

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysDict> queryByPage(SysDict sysDict, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    SysDict insert(SysDict sysDict);

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    SysDict update(SysDict sysDict);

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 是否成功
     */
    boolean deleteById(String keyId);

}