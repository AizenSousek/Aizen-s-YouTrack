package com.aizensousek.aytserver.service;

import com.aizensousek.aytserver.entity.IssueTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 问题标记信息表(IssueTag)表服务接口
 *
 * @author makejava
 * @since 2022-06-01 14:40:17
 */
public interface IssueTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IssueTag queryById(String id);

    /**
     * 分页查询
     *
     * @param issueTag    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<IssueTag> queryByPage(IssueTag issueTag, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param issueTag 实例对象
     * @return 实例对象
     */
    IssueTag insert(IssueTag issueTag);

    /**
     * 修改数据
     *
     * @param issueTag 实例对象
     * @return 实例对象
     */
    IssueTag update(IssueTag issueTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}