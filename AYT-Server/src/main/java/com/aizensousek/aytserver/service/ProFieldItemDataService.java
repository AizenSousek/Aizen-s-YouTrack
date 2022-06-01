package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.ProFieldItemData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目自定义字段数据表(ProFieldItemData)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
public interface ProFieldItemDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProFieldItemData queryById(String id);

    /**
     * 分页查询
     *
     * @param proFieldItemData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ProFieldItemData> queryByPage(ProFieldItemData proFieldItemData, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param proFieldItemData 实例对象
     * @return 实例对象
     */
    ProFieldItemData insert(ProFieldItemData proFieldItemData);

    /**
     * 修改数据
     *
     * @param proFieldItemData 实例对象
     * @return 实例对象
     */
    ProFieldItemData update(ProFieldItemData proFieldItemData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}