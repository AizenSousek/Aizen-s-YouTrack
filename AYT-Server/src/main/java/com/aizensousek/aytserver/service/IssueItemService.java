package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.IssueItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 问题信息表(IssueItem)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:37:59
 */
public interface IssueItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IssueItem queryById(String id);

    /**
     * 分页查询
     *
     * @param issueItem   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<IssueItem> queryByPage(IssueItem issueItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param issueItem 实例对象
     * @return 实例对象
     */
    IssueItem insert(IssueItem issueItem);

    /**
     * 修改数据
     *
     * @param issueItem 实例对象
     * @return 实例对象
     */
    IssueItem update(IssueItem issueItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}