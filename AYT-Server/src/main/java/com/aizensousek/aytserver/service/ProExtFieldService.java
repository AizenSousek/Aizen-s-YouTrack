package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.ProExtField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 项目自定义字段信息表(ProExtField)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
public interface ProExtFieldService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProExtField queryById(String id);

    /**
     * 分页查询
     *
     * @param proExtField 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<ProExtField> queryByPage(ProExtField proExtField, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param proExtField 实例对象
     * @return 实例对象
     */
    ProExtField insert(ProExtField proExtField);

    /**
     * 修改数据
     *
     * @param proExtField 实例对象
     * @return 实例对象
     */
    ProExtField update(ProExtField proExtField);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}