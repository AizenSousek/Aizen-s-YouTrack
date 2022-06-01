package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.SysDictItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (SysDictItem)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public interface SysDictItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    SysDictItem queryById(String keyId);

    /**
     * 分页查询
     *
     * @param sysDictItem 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysDictItem> queryByPage(SysDictItem sysDictItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysDictItem 实例对象
     * @return 实例对象
     */
    SysDictItem insert(SysDictItem sysDictItem);

    /**
     * 修改数据
     *
     * @param sysDictItem 实例对象
     * @return 实例对象
     */
    SysDictItem update(SysDictItem sysDictItem);

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 是否成功
     */
    boolean deleteById(String keyId);

}