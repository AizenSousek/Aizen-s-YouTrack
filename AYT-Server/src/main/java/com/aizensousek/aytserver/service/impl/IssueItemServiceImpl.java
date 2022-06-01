package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.IssueItemDao;
import com.aizensousek.aytserver.entity.IssueItem;
import com.aizensousek.aytserver.service.IssueItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 问题信息表(IssueItem)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:52
 */
@Service("issueItemService")
@SuppressWarnings("unused")
public class IssueItemServiceImpl implements IssueItemService {
    @Resource
    private IssueItemDao issueItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public IssueItem queryById(String id) {
        return this.issueItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param issueItem   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<IssueItem> queryByPage(IssueItem issueItem, PageRequest pageRequest) {
        long total = this.issueItemDao.count(issueItem);
        return new PageImpl<>(this.issueItemDao.queryAllByLimit(issueItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param issueItem 实例对象
     * @return 实例对象
     */
    @Override
    public IssueItem insert(IssueItem issueItem) {
        this.issueItemDao.insert(issueItem);
        return issueItem;
    }

    /**
     * 修改数据
     *
     * @param issueItem 实例对象
     * @return 实例对象
     */
    @Override
    public IssueItem update(IssueItem issueItem) {
        this.issueItemDao.update(issueItem);
        return this.queryById(issueItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.issueItemDao.deleteById(id) > 0;
    }
}